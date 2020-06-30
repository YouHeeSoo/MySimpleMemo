package com.example.mysimplememo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static String MAIN = "MainActivity";
    Button load,save,del;
    EditText content;

    TextView timeNow;
    SimpleDateFormat sdftime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String time = sdftime.format(new Date(System.currentTimeMillis()));
    //현재 시간을 출력하는 함수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load=(Button) findViewById(R.id.load); //저장한 파일 불러오는 변수
        save=(Button) findViewById(R.id.save);//파일 저장하는 변수
        del=(Button) findViewById(R.id.del);//파일 삭제하는 변수
        content = (EditText) findViewById(R.id.content);//메모 입력창

        load.setOnClickListener(onClick);
        save.setOnClickListener(onClick);
        del.setOnClickListener(onClick);

        timeNow = (TextView) findViewById(R.id.timeNow);
        timeNow.setText(time); //현재 날짜,시간 출력
    }
}