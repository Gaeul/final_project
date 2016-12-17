package com.example.gaeul.fianlproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Gaeul on 2016-12-17.
 */

public class ReportActivity extends Activity implements AdapterView.OnItemSelectedListener {

    //하고 있는 일 띄울 텍스트뷰
    TextView Do_textview;

    //사진찍는 곳으로 이동
    Button photobtn;

    //PhotoActivity로 넘어감
    Intent i;


    //스피너를 위한 아이템 정의
    String[] items = {"놀기", "먹기", "자기", "근로", "수업", "공부", "운동","쉬기"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);


        // 텍스트뷰 객체 참조
        Do_textview = (TextView) findViewById(R.id.Do_textview);

        //타이머 사용
        final Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
        Button buttonStart = (Button) findViewById(R.id.buttonstart);
        Button buttonStop = (Button) findViewById(R.id.buttonstop);
        Button buttonReset = (Button) findViewById(R.id.buttonreset);

        //사진찍는데 사용
        photobtn = (Button) findViewById(R.id.photobtn);


        i = new Intent(ReportActivity.this, PhotoActivity.class);


        photobtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                startActivity(i);
            }
        });



        //android 내부에는 타이머 기능을 수행할 수 있는 chronometer class가 존재
        //https://developer.android.com/reference/android/widget/Chronometer.html 참고

        //START
        buttonStart.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                chronometer.start();
            }
        });

        //STOP
        buttonStop.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                chronometer.stop();
            }
        });


        //RESET
        buttonReset.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
            }
        });

        // 스피너 객체 참조
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        // 어댑터 객체 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 어댑터 설정
        spinner.setAdapter(adapter);
    }
    /**
     * 아이템이 선택되었을 때 처리
     */
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        Do_textview.setText(items[position]);
    }

    /**
     * 아무것도 선택되지 않았을 때 처리
     */
    public void onNothingSelected(AdapterView<?> parent) {
        Do_textview.setText("");
    }

    public void onSavebtnClicked(View v) {

        Toast toastview = Toast.makeText(this, "저장되었습니다!", Toast.LENGTH_LONG);
        toastview.setGravity(Gravity.CENTER, 160, 240);

        toastview.show();

    }



}
