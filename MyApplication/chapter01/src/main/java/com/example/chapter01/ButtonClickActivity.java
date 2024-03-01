package com.example.chapter01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chapter01.util.DateUtil;

public class ButtonClickActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);

        tv = findViewById(R.id.tv_time);

        Button btn_single = findViewById(R.id.btn_single);
        Button btn_public = findViewById(R.id.btn_public);

        //使用内部内创建Listener
        btn_single.setOnClickListener(new MyListener(tv));


        //使用本类创建Listener
        btn_public.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String decs = String.format("%s 您点击了按钮 %s", DateUtil.getNowTime(),((Button)view).getText());
        ((TextView)this.tv).setText(decs);
    }

    //静态内部类，处理内存泄露问题
    static class MyListener implements View.OnClickListener
    {

        private final View view;

        public MyListener(View view){
            this.view = view;

        }

        @Override
        public void onClick(View view) {
            String decs = String.format("%s 您点击了按钮 %s", DateUtil.getNowTime(),((Button)view).getText());
            ((TextView)this.view).setText(decs);
        }
    }
}