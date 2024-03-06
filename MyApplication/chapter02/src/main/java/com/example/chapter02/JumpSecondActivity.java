package com.example.chapter02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
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
        //  ! 显示Intent

        //1. Intent it = new Intent(this,JumpFirstActivity.class);

        //2. 调用意图的setClass方法指定
        Intent it = new Intent();
        it.setClass(this,JumpFirstActivity.class);

        //3. 调用意图的Component方法指定     知道包名、类名、引用其他包中的Activity
        //ComponentName component = new ComponentName("pkg","cln");
        //it.setComponent(component);


        //默认为反复叠加Task Stack

        //Stack中有一个本Activity被用到时，回到本Activity中，并且清除其上面的所有Task
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(it);
    }
}