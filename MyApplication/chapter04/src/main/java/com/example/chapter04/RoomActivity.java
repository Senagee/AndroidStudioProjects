package com.example.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.chapter04.dao.BookDao;
import com.example.chapter04.entity.BookInfo;

import java.util.List;

public class RoomActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText et_name;
    private EditText et_author;
    private EditText et_press;
    private EditText et_price;

    private BookDao bookDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        et_name = findViewById(R.id.et_name);
        et_author = findViewById(R.id.et_author);
        et_press = findViewById(R.id.et_press);
        et_price = findViewById(R.id.et_price);

        findViewById(R.id.btn_save).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        findViewById(R.id.btn_modify).setOnClickListener(this);
        findViewById(R.id.btn_check).setOnClickListener(this);

        bookDao = MyApplication.getInstance().getBdb().getBookDao();
    }

    @Override
    public void onClick(View v) {
        String name = et_name.getText().toString();
        String author = et_author.getText().toString();
        String press = et_press.getText().toString();
        String price = et_price.getText().toString();
        BookInfo book = new BookInfo();
        switch(v.getId()){
            case R.id.btn_save:
                book.setName(name);
                book.setAuthor(author);
                book.setPress(press);
                book.setPrice(Float.parseFloat(price));

                bookDao.insert(book);
                break;
            case R.id.btn_delete:
                break;
            case R.id.btn_modify:
                break;
            case R.id.btn_check:
                List<BookInfo> books = bookDao.selectAll();
                for(BookInfo book1 : books){
                    Log.d("liu", book1.toString());
                }
                break;
        }

    }
}