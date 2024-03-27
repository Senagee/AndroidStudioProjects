package com.example.chapter04.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static void show(Context context, String decs){
        Toast.makeText(context, decs, Toast.LENGTH_SHORT).show();
    }
}
