package com.example.chapter01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chapter01.util.DateUtil;

public class ButtonStyleActivity extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_style);
        tv = findViewById(R.id.tv_time);
    }
    public void getNowTime(View view){
        String decs = String.format("%s 您点击了按钮 %s", DateUtil.getNowTime(),((Button)view).getText());
        tv.setText(decs);


    }

}