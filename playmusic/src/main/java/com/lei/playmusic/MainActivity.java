package com.lei.playmusic;

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
        intent.setClass(this,MusicService.class);
        switch (view.getId()) {
            case R.id.btn_Start:
                startService(intent);
                break;
            case R.id.btn_stop:
                stopService(intent);
                break;
        }
    }
}
