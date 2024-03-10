package com.example.chapter02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {

    private TextView tv_receive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        tv_receive = findViewById(R.id.tv_receive);

        //从上一个Activity中的意图（Intent）取出包裹（Bundle）
        Bundle bundle = getIntent().getExtras();
        String request_time = bundle.getString("request-time");
        String request_data = bundle.getString("request-data");
        String decs = String.format("从上一个Activity收到的数据的time为：%s \n 数据为：%s", request_time,request_data);
        tv_receive.setText(decs);

    }
}