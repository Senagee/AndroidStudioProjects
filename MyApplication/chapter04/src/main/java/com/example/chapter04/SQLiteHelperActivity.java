package com.example.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.chapter04.database.UserDBHelper;
import com.example.chapter04.enity.User;
import com.example.chapter04.util.ToastUtil;

public class SQLiteHelperActivity extends AppCompatActivity implements View.OnClickListener{


    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    private CheckBox cb_marry;

    private UserDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_helper);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        cb_marry = findViewById(R.id.cb_marry);

        findViewById(R.id.btn_save).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        findViewById(R.id.btn_modify).setOnClickListener(this);
        findViewById(R.id.btn_check).setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        helper = UserDBHelper.getInstance(this);
        helper.OpenReadLink();
        helper.OpenWriteLink();

    }

    @Override
    protected void onStop() {
        super.onStop();
        helper.CloseLink();
    }

    @Override
    public void onClick(View v) {
        String name = et_name.getText().toString();
        int age = Integer.parseInt(et_age.getText().toString());
        float height = Float.parseFloat(et_height.getText().toString());
        float weight = Float.parseFloat(et_weight.getText().toString());
        boolean marry = cb_marry.isChecked();

        User user = null;
        switch(v.getId()){
            case R.id.btn_save:
                user = new User(name, age, height, weight, marry);
                if(helper.insert(user) > 0)
                    ToastUtil.show(this,"添加成功");
                break;
            case R.id.btn_delete:
                break;
            case R.id.btn_modify:
                break;
            case R.id.btn_check:
                break;
        }
    }
}