package com.example.chapter04.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.chapter04.dao.BookDao;
import com.example.chapter04.entity.BookInfo;

@Database(entities = {BookInfo.class}, version = 1, exportSchema = true)
public abstract class BookDataBase extends RoomDatabase {

    public abstract BookDao getBookDao();
}
