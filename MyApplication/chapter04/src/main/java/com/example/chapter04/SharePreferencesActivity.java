package com.example.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SharePreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_name;
    private EditText et_name;

    private TextView tv_age;
    private EditText et_age;

    private TextView tv_phone;
    private EditText et_phone;

    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferences);

       tv_name =  findViewById(R.id.tv_name);
       et_name = findViewById(R.id.et_name);

        tv_age =  findViewById(R.id.tv_age);
        et_age = findViewById(R.id.et_age);

        tv_phone =  findViewById(R.id.tv_phone);
        et_phone = findViewById(R.id.et_phone);

        findViewById(R.id.btn_save).setOnClickListener(this);
        //  将数据保存到对应的XML文件中
        preferences = getSharedPreferences("uerConfig" , Context.MODE_PRIVATE);

        reload();
    }

    private void reload() {
        String name = preferences.getString("name", null);
        if(name != null && !name.equals(""))
            et_name.setText(name);
        String age = preferences.getString("age", null);
        if(age != null && !age.equals(""))
            et_age.setText(age);
        String phone = preferences.getString("phone", null);
        if(phone != null && !phone.equals(""))
            et_phone.setText(phone);
    }

    @Override
    public void onClick(View v) {

        String name = et_name.getText().toString();
        String age = et_age.getText().toString();
        String phone = et_phone.getText().toString();

        //编辑器
        SharedPreferences.Editor edit = preferences.edit();

        //key:value
        edit.putString("name", name);
        edit.putString("age", age);
        edit.putString("phone", phone);
        edit.apply();

    }
}