package com.example.gaeul.fianlproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button ReportButton, AnalyzeButton,dbbutton;
    Intent i,i2,temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReportButton = (Button) findViewById(R.id.ReportButton);
        AnalyzeButton = (Button) findViewById(R.id.AnalyzeButton);
        dbbutton = (Button) findViewById(R.id.dbbutton);

        i = new Intent(MainActivity.this, ReportActivity.class);
        i2 = new Intent(MainActivity.this, AnalyzeActivity.class);
        temp = new Intent(MainActivity.this, DBActivity.class);

        //Report 버튼을 누르면 !
        ReportButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });

        //Analyze 버튼을 누르면 !
        AnalyzeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(i2);
            }
        });
        dbbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(temp);
            }
        });

    }
}
