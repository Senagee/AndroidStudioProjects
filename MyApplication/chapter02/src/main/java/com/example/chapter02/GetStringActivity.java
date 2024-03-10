package com.example.chapter02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GetStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_string);

        TextView tv_string = findViewById(R.id.tv_string);
        String string = getString(R.string.hello);
        tv_string.setText(string);
    }
}