package com.example.shopingstore;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import androidx.room.Room;

import com.example.shopingstore.DataBase.StoreDataBase;
import com.example.shopingstore.dao.GoodsDAO;
import com.example.shopingstore.entity.Goods;
import com.example.shopingstore.util.FileUtil;
import com.example.shopingstore.util.ShareUtil;

import java.io.File;

public class MyApplication extends Application {

    private static MyApplication mapp;

    private StoreDataBase sdb;

    public static MyApplication getInstance(){
        return mapp;
    }
    private MyApplication(){};

    @Override
    public void onCreate() {
        super.onCreate();

        mapp = this;
        sdb = Room.databaseBuilder(this, StoreDataBase.class, "store")
                .addMigrations()
                //允许主线程操作数据库，通常情况下不应该这样操作，主线程数UI线程，在操作数据时浪费时间会影响用户体验
                .allowMainThreadQueries()
                .build();


        initGoods();


    }
    //首次进入，初始化信息
    private void initGoods(){
        if(ShareUtil.getInstance(this).readBoolean("first", true)){
            //首次进入
            ShareUtil.getInstance(this).writeBoolean("first", false);
            //获取当前App的私有下载路径
            String directory = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() + File.separatorChar;

            //模拟从网上下载图片



            GoodsDAO dao = sdb.getGoodsDAO();
            //应有事务
            for(Goods good : Goods.getDefaultList()){
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), good.getPic());
                //图片完整路径
                String path = directory + good.getId() + ".jpg";
                //将图片存储到存储卡中
                FileUtil.saveImage(path, bitmap);

                good.setPicPath(path);
                //将数据插入数据库
                dao.insert(good);

                bitmap.recycle();
            }
        }
    }
}
