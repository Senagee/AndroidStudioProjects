package com.example.chapter01.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getNowTime(){
        SimpleDateFormat nowTime = new SimpleDateFormat("HH:mm:ss");
        return nowTime.format(new Date());



    }
}
