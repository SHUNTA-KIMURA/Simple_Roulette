package android.lifeistech.com.simpleroulette;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void next(View v){
        editText=(EditText)findViewById(R.id.editText);
        text=editText.getText().toString();
        int maxCount=Integer.parseInt(text);
        Intent intent = new Intent(getApplication(), RouletteActivity.class);
        intent.putExtra("number",maxCount);
        startActivity(intent);
    }
}
