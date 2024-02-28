package com.example.chapter01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TextSizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_size);
        //通过setTextSize()设置字体大小
        TextView tv = findViewById(R.id.textsize_dp);
        //默认单位sp
        tv.setTextSize(30);
    }
}