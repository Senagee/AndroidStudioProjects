package com.example.chapter02;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.chapter02.util.DateUtil;

public class RequestForResultActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String msg = "吃饭了吗？";
    private TextView tv_request;
    private TextView tv_response;
    private ActivityResultLauncher<Intent> register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_for_result);

        findViewById(R.id.btn_request).setOnClickListener(this);

        tv_response = findViewById(R.id.tv_response);

        tv_request = findViewById(R.id.tv_request);
        tv_request.setText("待发送的消息：" + msg);

        //获取从上一个页面返回来的消息
        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result != null){
                Intent intent = result.getData();
                    if(intent != null && result.getResultCode() == Activity.RESULT_OK){

                        Bundle bundle = intent.getExtras();
                        String response_time = bundle.getString("response-time");
                        String response_data = bundle.getString("response-data");
                        String decs = String.format("收到回复的数据\n回复时间为：%s \n回复数据为：%s", response_time,response_data);
                        tv_response.setText(decs);

                    }
            }

        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ResponseActivity.class);
        //创建一个包，将想传送的数据打包进去
        Bundle bundle = new Bundle();
        bundle.putString("request-time", DateUtil.getNowTime());
        bundle.putString("request-data", msg);

        intent.putExtras(bundle);

        register.launch(intent);

    }
}