package com.lei.studyservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this,MyService.class);
        switch(view.getId()) {
            case R.id.btn_start://启动服务
                startService(intent);
                break;
            case R.id.btn_stop://停止服务
                stopService(intent);
                break;
        }
    }
}
