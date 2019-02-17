package android.lifeistech.com.simpleroulette;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteActivity extends AppCompatActivity {
    Button startButton, stopButton;
    int maxCount;
    PieChart mPieChart;
    int result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);
        startButton = (Button) findViewById(R.id.startButton);
        Intent intent = getIntent();
        maxCount = intent.getIntExtra("number", maxCount);
        mPieChart = (PieChart) findViewById(R.id.pie_chart);
        setupPieChartView();
    }

    public void start(View v) {
        Random random = new Random();
        int number = random.nextInt(3000) + 5000;
        int bunshi = ((maxCount * (number + 5000)) / 360);
        result = maxCount - (bunshi % maxCount);
        mPieChart.spin(number, mPieChart.getRotationAngle(), mPieChart.getRotationAngle() + (float) (number + 5000), Easing.EasingOption.EaseOutQuart);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new AlertDialog.Builder(RouletteActivity.this)
                                .setMessage(result + "")
                                .setPositiveButton("CONTINUE", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .show();
                    }
                });
            }
        }, number);



    }

    private void setupPieChartView() {
        mPieChart.setUsePercentValues(true);
        mPieChart.setTouchEnabled(false);
        Legend legend = mPieChart.getLegend();
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);

        List<Float> values = new ArrayList<>();
        for (int i = 0; i < maxCount; i++) {
            values.add(100f);
        }

        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < maxCount; i++) {
            entries.add(new Entry(values.get(i), i));
        }

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setDrawValues(false);
        dataSet.setSliceSpace(3f);


        List<String> labels = new ArrayList<>();
        for (int i = 0; i < maxCount; i++) {
            labels.add(i + 1 + "");
        }

        PieData pieData = new PieData(labels, dataSet);
        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(20f);
        pieData.setValueTextColor(Color.BLACK);


        mPieChart.setData(pieData);

    }


}
