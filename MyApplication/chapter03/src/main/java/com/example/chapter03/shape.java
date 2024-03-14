package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class shape extends AppCompatActivity implements View.OnClickListener{

    private View v_bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);

        v_bg = findViewById(R.id.v_bg);

        findViewById(R.id.btn_rect).setOnClickListener(this);
        findViewById(R.id.btn_oval).setOnClickListener(this);

        v_bg.setBackgroundResource(R.drawable.shape_rect);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_rect:
                v_bg.setBackgroundResource(R.drawable.shape_rect);
                break;
            case R.id.btn_oval:
                v_bg.setBackgroundResource(R.drawable.shape_oval);
                break;
        }
    }
}