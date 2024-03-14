package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FocusChangeActivity extends AppCompatActivity implements View.OnFocusChangeListener{

    private  EditText et_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_change);

        et_phone = findViewById(R.id.et_phone);
        EditText et_password = findViewById(R.id.et_password);

        et_password.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus)
        {
            String phone = et_phone.getText().toString();
            //判断输入是否小于11位
            if(TextUtils.isEmpty(phone) || phone.length() < 11)
            {
                et_phone.requestFocus();
                Toast.makeText(this,"请输入11位电话号码",Toast.LENGTH_SHORT).show();
            }

        }
    }
}