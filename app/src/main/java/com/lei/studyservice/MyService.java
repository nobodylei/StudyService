package com.lei.studyservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by yanle on 2018/3/3.
 */

public class MyService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("tag","onCreate");
        return null;
    }

    /**
     * Service创建后调用
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("tag","onCreate");
    }

    /**
     * Service被start后调用
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("tag","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * Service被停止后调用
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("tag","onDestroy");
    }
}
