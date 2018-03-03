package com.lei.studyservicestartandbind;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ServiceConnection conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i("tag","onServiceConnected");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        switch (view.getId()) {
            case R.id.btn_start:
                startService(intent);
                break;
            case R.id.btn_stop:
                stopService(intent);
                break;
            case R.id.btn_bind:
                bindService(intent, conn, Context.BIND_ABOVE_CLIENT);
                break;
            case R.id.btn_unbind://解绑销毁服务
                unbindService(conn);
        }
    }
}
