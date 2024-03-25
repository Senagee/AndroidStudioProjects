package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity implements View.OnClickListener , DatePickerDialog.OnDateSetListener {

    private DatePicker dp_date ;
    private TextView tv_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        findViewById(R.id.btn_ok).setOnClickListener(this);
        findViewById(R.id.btn_get).setOnClickListener(this);

        dp_date = findViewById(R.id.dp_date);

        tv_content = findViewById(R.id.tv_content);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            /*
            *
            *
            *
            * */
            case R.id.btn_ok:
                String decs = String.format("你选择的日期为%d年%d月%d日", dp_date.getYear(),dp_date.getMonth() + 1,dp_date.getDayOfMonth());
                tv_content.setText(decs);
                break;
            case R.id.btn_get:
                /*
                *
                * //获取当前日历类，获取年月日
                *   Calendar calendar = Calendar.getInstance();
                    calendar.get(Calendar.YEAR);
                    calendar.get(Calendar.MONTH);
                    calendar.get(Calendar.DAY_OF_MONTH);
                *
                *
                * */
                DatePickerDialog dialog = new DatePickerDialog(this, this, 2023,3 ,18);
                dialog.show();
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String decs = String.format("你选择的日期为%d年%d月%d日",year,month,dayOfMonth);
        tv_content.setText(decs);
    }
}