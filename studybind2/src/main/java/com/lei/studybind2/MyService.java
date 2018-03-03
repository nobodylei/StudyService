package com.lei.studybind2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;


/**
 * Created by yanle on 2018/3/3.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public int sum(int a, int b) {
        return a + b;
    }

    private class MyBinder extends MyServiceInterface.Stub {
        @Override
        public int sum(int a, int b) throws RemoteException {
            return MyService.this.sum(a, b);
        }
    }

}
