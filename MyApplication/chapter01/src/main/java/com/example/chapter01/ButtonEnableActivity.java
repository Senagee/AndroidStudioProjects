package com.example.chapter01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chapter01.util.DateUtil;

public class ButtonEnableActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_enable;
    private Button btn_disable;
    private Button btn_test;
    private TextView tv_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_enable);

        btn_enable = findViewById(R.id.btn_enable);
        btn_disable = findViewById(R.id.btn_disable);
        btn_test = findViewById(R.id.btn_test);

        tv_time = findViewById(R.id.tv_time);

        btn_enable.setOnClickListener(this);
        btn_disable.setOnClickListener(this);
        btn_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case(R.id.btn_enable):
                btn_test.setEnabled(true);
                break;
            case(R.id.btn_disable):
                btn_test.setEnabled(false);
                break;
            case(R.id.btn_test):
                String decs = String.format("%s 您点击了按钮 %s", DateUtil.getNowTime(),((Button)view).getText());
                tv_time.setText(decs);
        }

    }
}