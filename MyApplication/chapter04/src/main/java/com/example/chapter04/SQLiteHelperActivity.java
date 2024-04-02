package com.example.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.chapter04.database.UserDBHelper;
import com.example.chapter04.entity.User;
import com.example.chapter04.util.ToastUtil;

import java.util.List;

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
        String age = et_age.getText().toString();
        String height = et_height.getText().toString();
        String weight = et_weight.getText().toString();
        boolean marry = cb_marry.isChecked();

        User user = null;
        switch(v.getId()){
            case R.id.btn_save:

                user = new User(name, Integer.parseInt(age), Float.parseFloat(height), Float.parseFloat(weight), marry);
                if(helper.insert(user) > 0)
                    ToastUtil.show(this,"添加成功");
                break;
            case R.id.btn_delete:
                if(helper.deleteByName(name) > 0)
                    ToastUtil.show(this,"删除成功");
                break;
            case R.id.btn_modify:
                user = new User(name, Integer.parseInt(age), Float.parseFloat(height), Float.parseFloat(weight), marry);
                if(helper.upDateByName(user) > 0)
                    ToastUtil.show(this,"修改成功");
                break;
            case R.id.btn_check:
                List<User> users = helper.queryAll();
                for(User u : users)
                    Log.d("liu", u.toString());
                break;
        }
    }
}