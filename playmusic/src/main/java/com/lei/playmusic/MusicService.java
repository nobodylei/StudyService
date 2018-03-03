package com.lei.playmusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * Created by yanle on 2018/3/3.
 */

public class MusicService extends Service{
    //媒体播放器
    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("tag","onBind");
        return null;
    }

    @Override
    public void onCreate() {
        Log.i("tag","onCreate");
        File file = new File(Environment.getExternalStorageDirectory(), "a.mp3");
        player = new MediaPlayer();
        try {
            //设置播放源
            player.setDataSource(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("tag","onStartCommand");
        //准备资源
        try {
            //设置准备资源监听器，当资源准备完毕回调监听器中的函数
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    //播放音乐
                    player.start();
                }
            });
            //异步方法
            player.prepareAsync();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("tag","onDestroy");
        player.stop();//停止播放
        player.release();//释放资源
        super.onDestroy();
    }
}
