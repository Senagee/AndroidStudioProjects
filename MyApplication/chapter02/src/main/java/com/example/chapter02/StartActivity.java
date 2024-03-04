package com.example.chapter02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{

    private static final  String TVG = "Liu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        findViewById(R.id.btn_jump).setOnClickListener(this);
        Log.d(TVG, "StartActivity OnCreate");
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, FinishActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TVG, "StartActivity OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TVG, "StartActivity OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TVG, "StartActivity OnPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TVG, "StartActivity OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TVG, "StartActivity OnDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TVG, "StartActivity OnRestart");
    }
}
