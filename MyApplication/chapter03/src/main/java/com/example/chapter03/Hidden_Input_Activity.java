package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.chapter03.utils.ViewUtil;

/**
 *        输入完后关闭输入法
 *
 * **/
public class Hidden_Input_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidden_input);

        EditText et_phone = findViewById(R.id.et_phone);
        EditText et_password = findViewById(R.id.et_password);

        //为文本框注册文本变换监听器
        et_phone.addTextChangedListener(new HiddenWatch(et_phone, 11));
        et_password.addTextChangedListener(new HiddenWatch(et_password, 6));

    }

    private class HiddenWatch implements TextWatcher {
        private EditText et;
        private int maxLength;

        public HiddenWatch(EditText et, int maxLength){
            this.et = et;
            this.maxLength = maxLength;
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        //在文本发生变化后执行
        @Override
        public void afterTextChanged(Editable s) {
            String content = s.toString();

            //如果输入到达11位（手机号）或6位（密码）数字，关闭输入法
            if(content.length() == maxLength)
                ViewUtil.HiddenInputMethod(Hidden_Input_Activity.this, et);
        }
    }
}