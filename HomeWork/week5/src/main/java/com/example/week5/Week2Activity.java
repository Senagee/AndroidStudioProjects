package com.example.week5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Week2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week2);
        findViewById(R.id.button1).setOnClickListener(this);        //登录
        findViewById(R.id.button2).setOnClickListener(this);        //注册
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button1){
            startActivity(new Intent(this, Week4Activity.class));
        }

        if(v.getId() == R.id.button2){
            Intent intent = new Intent();
            intent.setAction("cn.gcu.student_manager");

            // 跳转至SignupActivity
            startActivity(intent);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}