package com.lei.binder2client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lei.studybind2.MyServiceInterface;

public class MainActivity extends AppCompatActivity {

    private ServiceConnection conn;
    private MyServiceInterface binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder = MyServiceInterface.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("com.lei.studybind2.myservice");
        switch (view.getId()) {
            case R.id.btn_bind://绑定服务
                bindService(intent, conn, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind://解绑服务
                unbindService(conn);
                break;
            case R.id.btn_diaovone://调用函数
                if(binder != null) {
                    try {
                        int result = binder.sum(1, 4);
                        Log.i("tag", result + "");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
