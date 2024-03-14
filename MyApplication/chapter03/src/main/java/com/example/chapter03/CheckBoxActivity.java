package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class CheckBoxActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox cb_change ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        cb_change = findViewById(R.id.cb_change);
        cb_change.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String dict = String.format("你%s按钮",isChecked ? "选中" : "没选");
        cb_change.setText(dict);
    }
}