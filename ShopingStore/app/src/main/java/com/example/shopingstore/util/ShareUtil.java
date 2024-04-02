package com.example.shopingstore.util;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareUtil {
    private static ShareUtil su;
    private SharedPreferences spf;
    public static ShareUtil getInstance(Context ctt){
        if(su == null){
            su = new ShareUtil();
            su.spf = ctt.getSharedPreferences("store", Context.MODE_PRIVATE);
        }
        return su;
    }

    public void writeBoolean(String Key, boolean value){
        SharedPreferences.Editor edit = spf.edit();
        edit.putBoolean(Key, value);
        edit.apply();
    }
    public boolean readBoolean(String Key, boolean defaultValue){
        return spf.getBoolean(Key, defaultValue);
    }

}
