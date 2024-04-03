package com.example.week5;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Week3Activity extends AppCompatActivity {

    private ProgressBar pb_progress;
    private EditText et_account, et_phone, et_email, et_password;
    private TextView tv_number;
    private Button btn_submit;
    private int totalProgress = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week3);

        pb_progress = findViewById(R.id.pb_progress);
        tv_number = findViewById(R.id.tv_number);
        et_account = findViewById(R.id.et_account);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btn_submit = findViewById(R.id.btn_submit);

        //开始不可提交
        btn_submit.setEnabled(false);

        // 设置进度条初始值为0
        pb_progress.setProgress(0);

        // 添加TextWatcher监听器
        et_account.addTextChangedListener(new myWatcher());
        et_phone.addTextChangedListener(new myWatcher());
        et_email.addTextChangedListener(new myWatcher());
        et_password.addTextChangedListener(new myWatcher());
    }

    class myWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            // 检查账户输入框
            String accountText = et_account.getText().toString();
            boolean isAccountValid = accountText.length() >= 4;

            // 检查手机输入框
            String phoneText = et_phone.getText().toString();
            boolean isPhoneValid = phoneText.length() == 11 && android.util.Patterns.PHONE.matcher(phoneText).matches();

            // 检查邮箱输入框
            String emailText = et_email.getText().toString();
            boolean isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches();

            // 检查密码输入框
            String passwordText = et_password.getText().toString();
            boolean isPasswordValid = passwordText.length() >= 4;

            // 计算已填写的EditText数量
            int filledEditTextCount = 0;
            if (!TextUtils.isEmpty(et_account.getText().toString()) && isAccountValid) {
                filledEditTextCount++;
            }
            if (!TextUtils.isEmpty(et_phone.getText().toString()) && isPhoneValid) {
                filledEditTextCount++;
            }
            if (!TextUtils.isEmpty(et_email.getText().toString()) && isEmailValid) {
                filledEditTextCount++;
            }
            if (!TextUtils.isEmpty(et_password.getText().toString()) && isPasswordValid) {
                filledEditTextCount++;
            }

            // 控制提交按钮的可点击状态
            if (isAccountValid && isPhoneValid && isEmailValid && isPasswordValid) {
                btn_submit.setEnabled(true);
            } else {
                btn_submit.setEnabled(false);
            }

            // 更新进度条的进度
            int progress = totalProgress / 4 * filledEditTextCount;
            pb_progress.setProgress(progress);

            // 更新TextView显示的进度
            String progressText = String.format("%d/%d", filledEditTextCount * 25, totalProgress);
            tv_number.setText(progressText);
        }
    }
}