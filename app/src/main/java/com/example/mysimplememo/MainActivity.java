package com.example.mysimplememo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    View.OnClickListener onClick = new View.OnClickListener(){
        @Override
        public void onClick(View view){ //버튼 클릭했을때 어떤 명령이 실행되어야 하는지 Switch로 케이스 나눠서 실행
            switch(view.getId()){
                case R.id.save: //저장하기 버튼 클릭했을때
                    Log.i("MAIN", "LOAD Start");
                    FileOutputStream fos = null;
                    try{
                        fos = openFileOutput("memo.txt", Context.MODE_PRIVATE);
                        String out = content.getText().toString();
                        fos.write(out.getBytes()); //메모 입력창에 입력
                        Toast.makeText(MainActivity.this, "SAVE!!", Toast.LENGTH_SHORT).show(); //저장완료했다는 메세지 표시


                    }catch(Exception e){
                        e.printStackTrace();
                    }finally{
                        try{
                            if(fos != null)
                                fos.close();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case R.id.del: //삭제하기 버튼 클릭했을때
                    Log.i("MAIN", "DELETE!!");
                    boolean bool = deleteFile("memo.txt");
                    if(bool){
                        Toast.makeText(MainActivity.this, "DELETE!!", Toast.LENGTH_SHORT).show();//삭제 완료했다는 토스트 메세지 출력
                    }else{
                        Toast.makeText(MainActivity.this,"DELETE Failure", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.load: //불러오기 버튼을 클릭했을때
                    Log.i("MAIN", "LOAD Start");
                    FileInputStream fis = null;
                    try{
                        fis = openFileInput("memo.txt");//바로 전에 저장했던 파일을 불러옴
                        byte[]data = new byte[fis.available()];
                        while(fis.read(data) != -1){

                        }
                        content.setText(new String(data));
                        Toast.makeText(MainActivity.this, "LOAD!!", Toast.LENGTH_SHORT).show();//불러오기 완료 메세지 띄우기


                    }catch(Exception e){
                        e.printStackTrace();
                    }finally{
                        try{
                            if(fis != null)
                                fis.close();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    break;

            }
        }
    };
}