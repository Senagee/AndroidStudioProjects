package com.example.chapter04.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.chapter04.enity.LoginInfo;
import com.example.chapter04.enity.User;

import java.util.ArrayList;
import java.util.List;

public class LoginDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME  = "Login.info";
    private static final String TABLE_NAME = "login_info";
    private static final int DB_VERSION  = 1;

    private static LoginDBHelper helper = null;

    //读连接
    private SQLiteDatabase RDB = null;
    //写连接
    private SQLiteDatabase WDB = null;

    //单例
    private LoginDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static LoginDBHelper getInstance(Context context){

        if(helper == null)
            helper = new LoginDBHelper(context);

        return helper;
    }
    //创建数据库，创建表结构
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " +TABLE_NAME +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "phone VARCHAR NOT NULL," +
                "password INTEGER NOT NULL," +
                "remember INTEGER NOT NULL);"
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

    //保存
    public void save(LoginInfo info){
        try{
            WDB.beginTransaction();
            /*
            为什么先删后添加
                考虑到有数据库中有相同的phone时，而登录时密码不同，需要进行修改
                这里就不进行修改操作了，下列方法也能实现。
            */
            delete(info);
            insert(info);
            WDB.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            WDB.endTransaction();
        }

    }
    //添加
    public long insert(LoginInfo info){
        ContentValues values = new ContentValues();
        values.put("phone", info.getPhone());
        values.put("password",info.getPassword());
        values.put("remember", info.isRemember());
        return WDB.insert(TABLE_NAME, null, values);
    }

    public long delete(LoginInfo info){
        return WDB.delete(TABLE_NAME, "phone = ?", new String[]{info.getPhone()});
    }
    //删除
    public long deleteByName(String name){
        //删除全部  WDB.delete(TABLE_NAME, null, null);
        return WDB.delete(TABLE_NAME, "name = ?", new String[]{name});
    }
    //查询所有
    public LoginInfo queryTop(){
        //返回最后登录且记住密码的
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE remember = 1 ORDER BY id DESC LIMIT 1" ;
        Cursor cursor= RDB.rawQuery(sql, null);
        LoginInfo info = null;
        if(cursor.moveToNext()){
            info = new LoginInfo();
            info.setId(cursor.getInt(0));
            info.setPhone(cursor.getString(1));
            info.setPassword(cursor.getString(2));
            info.setRemember(cursor.getInt(3) == 1);
        }
        cursor.close();
        return info;
    }
}
