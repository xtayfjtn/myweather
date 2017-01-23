package com.example.zq.moreweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView editcity;
    private Button btn_getweather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_getweather = (Button) findViewById(R.id.btndownload);
        editcity = (AutoCompleteTextView) findViewById(R.id.city);

        btn_getweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowWeather.class);
                intent.putExtra("city", editcity.getText().toString());
                startActivity(intent);
            }
        });
    }
}
