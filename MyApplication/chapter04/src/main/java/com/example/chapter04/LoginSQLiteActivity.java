package com.example.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.chapter04.database.LoginDBHelper;
import com.example.chapter04.enity.LoginInfo;
import com.example.chapter04.util.ViewUtil;

public class LoginSQLiteActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_phone;
    private EditText et_password;
    private CheckBox cb_remember;

    private LoginDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sqlite);

        et_phone = findViewById(R.id.et_phone);
        et_password = findViewById(R.id.et_password);
        cb_remember = findViewById(R.id.cb_remember);

        et_phone.addTextChangedListener(new MyTextWatcher(et_phone, 11));
        et_password.addTextChangedListener(new MyTextWatcher(et_password, 6));

        findViewById(R.id.btn_login).setOnClickListener(this);
        Log.d("liu", "Activity.onCreate");
    }

    private void reLoad(){
        //判断是否有记住密码的账号
        LoginInfo info = helper.queryTop();
        if(info != null){
            et_phone.setText(info.getPhone());
            et_password.setText(info.getPassword());
            cb_remember.setChecked(true);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        helper = LoginDBHelper.getInstance(this);
        helper.OpenReadLink();
        helper.OpenWriteLink();

        reLoad();
    }

    @Override
    protected void onStop() {
        super.onStop();
        helper.CloseLink();
    }

    @Override
    public void onClick(View v) {


        //无论是否选定记住密码，都先将数据保存到数据库中，再做后续处理

        String phone = et_phone.getText().toString();
        String password = et_password.getText().toString();
        boolean remember = cb_remember.isChecked();
        LoginInfo info = new LoginInfo(phone, password, remember);
        helper.save(info);
    }

    //输入正确的位数后，自动隐藏输入软盘
    class MyTextWatcher implements TextWatcher{

        private EditText et;
        private int maxLength;

        public MyTextWatcher(EditText et, int MaxLength){
            this.et = et;
            this.maxLength = MaxLength;

        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if(s.toString().length() == maxLength)
                ViewUtil.HiddenInputMethod(LoginSQLiteActivity.this, et);
        }
    }
}