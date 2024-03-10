package com.example.chapter02;

import android.content.Intent;
import android.os.Bundle;

import com.example.chapter02.util.DateUtil;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;



public class OnlyRequestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_only);

        tv_request = findViewById(R.id.tv_request);
        findViewById(R.id.btn_sent).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //
        Intent intent = new Intent(this,ReceiveActivity.class);
        //创建一个包，将想传送的数据打包进去
        Bundle bundle = new Bundle();
        bundle.putString("request-time", DateUtil.getNowTime());
        bundle.putString("request-data", tv_request.getText().toString());

        intent.putExtras(bundle);

        startActivity(intent);
    }
}