package com.lei.studyintentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by yanle on 2018/3/3.
 * 执行结束自动销毁
 */

public class MyIntentService extends IntentService{
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public MyIntentService() {
        super(MyIntentService.class.getName());
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * 异步函数
     * @param intent
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        boolean result = Looper.myLooper() == Looper.getMainLooper();
        Log.i("tag","onHandleIntent " + result);
    }
}
