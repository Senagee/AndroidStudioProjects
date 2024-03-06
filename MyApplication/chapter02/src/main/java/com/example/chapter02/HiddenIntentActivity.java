package com.example.chapter02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class HiddenIntentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidden_intent);

        findViewById(R.id.btn_dial).setOnClickListener(this);
        findViewById(R.id.btn_sendto).setOnClickListener(this);
        findViewById(R.id.btn_my).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //隐式意图
        Intent intent = new Intent();
        Uri uri = Uri.parse("tel:" + "18934299467");
        switch(v.getId()){
            case R.id.btn_dial:
                intent.setAction(Intent.ACTION_DIAL);
                Uri uri1 = Uri.parse("tel:" + "18934299467");
                intent.setData(uri1);
                startActivity(intent);
                break;
            case R.id.btn_sendto:
                intent.setAction(Intent.ACTION_SENDTO);
                Uri uri2 = Uri.parse("sms:" + "18934299467");
                //intent.setData(uri2);
                startActivity(intent);
                break;
            case R.id.btn_my:
                intent.setAction("android.intent.action.LIU");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intent);
                break;


        }
    }
}