package com.example.chapter04;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import androidx.annotation.NonNull;

//Application生命周期
/*
    一个应用程序只有一个Application

*/

public class LifeCycleApplication extends Application {

    //创建时执行
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("liu", "Application.onCreate");
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
}
