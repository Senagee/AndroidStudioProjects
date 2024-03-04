package com.example.chapter02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JumpSecondActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump_second);

        findViewById(R.id.btn_second).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //创建一个意图，设置Activity的启动模式
        Intent it = new Intent(this,JumpFirstActivity.class);
        //默认为反复叠加Task Stack

        //Stack中有一个本Activity被用到时，回到本Activity中，并且清除其上面的所有Task
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(it);
    }
}