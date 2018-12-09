package android.lifeistech.com.simpleroulette;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RouletteActivity extends AppCompatActivity {
    Button startButton,stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);
        stopButton=(Button)findViewById(R.id.stopButton);
        startButton=(Button)findViewById(R.id.startButton);
    }
    public void start(View v){
        startButton.setVisibility(View.GONE);
        stopButton.setVisibility(View.VISIBLE);
    }
    public void stop(View v){
        stopButton.setVisibility(View.GONE);
        startButton.setVisibility(View.VISIBLE);
    }
}
