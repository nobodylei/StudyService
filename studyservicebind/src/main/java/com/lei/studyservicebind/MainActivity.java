package com.lei.studyservicebind;

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
    private ServiceConnection coon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coon = new ServiceConnection() {

            /**
             * 当Service崩溃或被系统强制杀死后调用
             * @param name
             */
            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i("bind","onServiceDisconnected");
            }
            /**
             *  当服务访问者与服务绑定成功后调用
             * @param name
             * @param service
             */
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i("bind","onServiceConnected");
                MyService.MyServiceBinder binder = (MyService.MyServiceBinder)service;
                binder.show();
            }
        };
    }
    /*
    本地绑定，当服务的访问者与服务不在同一个进程就会绑定失败
     */

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        switch (view.getId()) {
            case R.id.btn_bind://绑定服务
                bindService(intent, coon, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind://解绑服务
                unbindService(coon);
                break;
        }
    }
}
