package com.example.chapter04.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME  = "USER.info";
    private static final String TABLE_NAME = "user_info";
    private static final int DB_VERSION  = 1;

    private static UserDBHelper helper = null;

    //读连接
    private SQLiteDatabase RDB = null;
    //写连接
    private SQLiteDatabase WDB = null;

    //单例
    private  UserDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static UserDBHelper getInstance(Context context){

        if(helper == null)
            helper = new UserDBHelper(context);

        return helper;
    }
    //创建数据库，创建表结构
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS TABLE_NAME(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name VARCHAR NOT NULL," +
                "age INTEGER NOT NULL," +
                "height FLOAT NOT NULL," +
                "weight FLOAT NOT NULL," +
                "marry INTEGER NOT NULL);"
                ;
        db.execSQL(sql);
    }

    //更新操作
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //获取读连接
    public SQLiteDatabase OpenReadLink(){
        if(RDB == null || !RDB.isOpen())
            RDB = helper.getReadableDatabase();
        return RDB;
    }

    //获取写连接
    public SQLiteDatabase OpenWriteLink(){
        if(WDB == null || !WDB.isOpen())
            WDB = helper.getWritableDatabase();
        return WDB;
    }

    //关闭连接

    public void CloseLink(){
        if(RDB != null && RDB.isOpen())
        {
            RDB.close();
            RDB = null;
        }
        if(WDB != null && WDB.isOpen())
        {
            WDB.close();
            WDB = null;
        }
    }
}
