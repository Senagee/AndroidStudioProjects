package com.example.chapter04;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;

import com.example.chapter04.database.BookDataBase;

//Application生命周期
/*
    一个应用程序只有一个Application

*/

public class MyApplication extends Application {

    private static MyApplication mapp;

    private BookDataBase bdb;


    public static MyApplication getInstance(){
        return mapp;
    }
    //创建时执行
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("liu", "Application.onCreate");

        mapp = this;
        bdb = Room.databaseBuilder(this, BookDataBase.class, "book")
                .addMigrations()
                //允许主线程操作数据库，通常情况下不应该这样操作，主线程数UI线程，在操作数据时浪费时间会影响用户体验
                .allowMainThreadQueries()
                .build();

    }

    //销毁时执行
    //  Framework层开发时会使用此方法，Application层的开发不会调用此方法
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    //屏幕旋转时执行
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("liu", "Application.onConfigurationChanged");
    }

    public BookDataBase getBdb(){
        return bdb;
    }
}
