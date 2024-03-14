package com.example.chapter03.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ViewUtil {
    public static void HiddenInputMethod(Activity act , View v){
        //从系统服务中获取系统管理器
        InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);

        //关闭输入法软键盘
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

    }
}
