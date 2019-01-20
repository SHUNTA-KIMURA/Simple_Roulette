package android.lifeistech.com.simpleroulette;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

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

public class RouletteActivity extends AppCompatActivity {
    Button startButton, stopButton;
    int maxCount;
    PieChart mPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);
        stopButton = (Button) findViewById(R.id.stopButton);
        startButton = (Button) findViewById(R.id.startButton);

        Intent intent = getIntent();
        maxCount = intent.getIntExtra("number", maxCount);
        mPieChart = (PieChart) findViewById(R.id.pie_chart);
        setupPieChartView();
    }

    public void start(View v) {
        mPieChart.spin(5000, mPieChart.getRotationAngle(), mPieChart.getRotationAngle() + 18000, Easing.EasingOption.EaseOutQuart);
        startButton.setVisibility(View.GONE);
        stopButton.setVisibility(View.VISIBLE);
    }

    public void stop(View v) {
        mPieChart.spin(5000, mPieChart.getRotationAngle(), mPieChart.getRotationAngle() + 1800, Easing.EasingOption.EaseOutQuart);
        stopButton.setVisibility(View.GONE);
        startButton.setVisibility(View.VISIBLE);
    }


    private void setupPieChartView() {
        mPieChart.setUsePercentValues(true);

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
