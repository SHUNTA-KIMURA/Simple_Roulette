package android.lifeistech.com.simpleroulette;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    String text;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView1);
    }
    public void next(View v){
        editText=(EditText)findViewById(R.id.editText);
        text=editText.getText().toString();
        int maxCount=Integer.parseInt(text);
        Intent intent = new Intent(getApplication(), RouletteActivity.class);
        intent.putExtra("number",maxCount);
        intent.putExtra("past","");
        startActivity(intent);
    }
}
