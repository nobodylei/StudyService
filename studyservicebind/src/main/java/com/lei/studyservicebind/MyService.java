package com.lei.studyservicebind;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.FileDescriptor;

/**
 * Created by yanle on 2018/3/3.
 */

public class MyService extends Service {

    /**
     * 当服务被绑定时调用
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("tag","onBind");
        return new MyServiceBinder();
    }

    @Override
    public void onCreate() {
        Log.i("tag","onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("tag","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("tag","onDestroy");
        super.onDestroy();
    }

    /**
     * 当服务被解绑时调用
     * @param intent
     * @return
     */
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("tag","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i("tag","onRebind");
        super.onRebind(intent);
    }

    public void show() {
        Log.i("tag","show");
    }

    /*
	 * IBinder接口包含我们的数据，
	 * 但IBinder接口不能直接去用，
	 * Binder类继承了IBinder类
	 * 重写一个类来继承Binder类
	 * 把它作为IBinder返回即可
	 */
    /*
    中介
     */
    public class MyServiceBinder extends Binder {
        public void show() {
            MyService.this.show();
        }
    }
}
