package com.example.chapter02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.chapter02.util.DateUtil;

public class ResponseActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String msg = "没呢，一起呀";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        TextView tv_request = findViewById(R.id.tv_request);

        //从上一个Activity中的意图获取数据
        Bundle bundle = getIntent().getExtras();
        String request_time = bundle.getString("request-time");
        String request_data = bundle.getString("request-data");
        String decs = String.format("收到上一个Activity的数据\n时间为：%s \n 数据为：%s", request_time,request_data);
        tv_request.setText(decs);

        findViewById(R.id.btn_response).setOnClickListener(this);

        TextView tv_response = findViewById(R.id.tv_response);
        tv_response.setText("待返回消息：" + msg);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("response-time", DateUtil.getNowTime());
        bundle.putString("response-data", msg);

        intent.putExtras(bundle);
        //携带意图返回上一层Activity Activity.RESULT_OK
        setResult(Activity.RESULT_OK, intent);
        finish();

    }
}