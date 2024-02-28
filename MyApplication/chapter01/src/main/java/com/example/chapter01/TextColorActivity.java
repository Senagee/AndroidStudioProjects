package com.example.chapter01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class TextColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_color);
        //系统自带Color类
        TextView tv1 = findViewById(R.id.code_color_system);
        tv1.setTextColor(Color.GREEN);

        //8位十六进制
        TextView tv2 = findViewById(R.id.code_color_eight);
        //每两位各表示 不透明，红，绿，蓝
        tv2.setTextColor(0xffff00ff);


        //6位十六进制
        TextView tv3 = findViewById(R.id.code_color_six);
        //每两位各表示 红，绿，蓝      在代码中，默认透明字体
        tv3.setTextColor(0xff00ff);


        //引用res/values/color.xml中的常量



        //bgColor设置




    }
}