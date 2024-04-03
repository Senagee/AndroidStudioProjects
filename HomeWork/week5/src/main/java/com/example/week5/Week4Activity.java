package com.example.week5;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Week4Activity extends AppCompatActivity {

    private ListView lv_list;
    private CustomAdapter adapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week4);

        lv_list = findViewById(R.id.lv_list);
        lv_list.setAdapter(new CustomAdapter());
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return position + 1;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item, parent, false);
            }

            ImageView iv_head = convertView.findViewById(R.id.iv_head);
            TextView tv_number = convertView.findViewById(R.id.tv_number);
            TextView tv_desc = convertView.findViewById(R.id.tv_desc);

            if ((position + 1) % 2 == 0) {
                iv_head.setImageResource(R.drawable.ic_man);
            } else {
                iv_head.setImageResource(R.drawable.ic_woman);
            }

            String number = String.format("%03d", position + 1);
            tv_number.setText(number);
            tv_desc.setText("我是 " + number);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Week4Activity.this, tv_desc.getText(), Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }
    }
}