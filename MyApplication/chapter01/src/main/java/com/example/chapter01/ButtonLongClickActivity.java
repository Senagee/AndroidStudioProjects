package com.example.chapter01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chapter01.util.DateUtil;

public class ButtonLongClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_long_click);
        TextView tv = findViewById(R.id.tv_time);


        Button btn_long_click = findViewById(R.id.btn_long_click);
        btn_long_click.setOnLongClickListener(view -> {
            String decs = String.format("%s 您点长按了按钮 %s", DateUtil.getNowTime(),((Button)view).getText());
            tv.setText(decs);


            //return true 表示此事件将会消耗掉点击事件，不会向外传递（冒泡事件）
            return true;
        }
                );

    }
}