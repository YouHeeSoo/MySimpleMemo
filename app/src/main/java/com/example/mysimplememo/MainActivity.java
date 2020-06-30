package com.example.mysimplememo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView timeNow;
    SimpleDateFormat sdftime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String time = sdftime.format(new Date(System.currentTimeMillis()));
    //현재 시간을 출력하는 함수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeNow = (TextView) findViewById(R.id.timeNow);
        timeNow.setText(time); //현재 날짜,시간 출력
    }
}