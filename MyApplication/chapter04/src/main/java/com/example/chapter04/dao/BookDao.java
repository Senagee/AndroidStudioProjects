package com.example.chapter04.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.chapter04.entity.BookInfo;

import java.util.List;

@Dao
public interface BookDao {

    @Insert
    void insert(BookInfo... book);

    @Query("DELETE FROM BookInfo WHERE name = :name")
    void deleteByName(String name);

    @Query("DELETE FROM BookInfo")
    void deleteAll();

    @Update
    void update(BookInfo... book);

    @Query("SELECT * FROM BookInfo WHERE name = :name ORDER BY id DESC LIMIT 1")
    BookInfo selectByName(String name);

    @Query("SELECT * FROM BookInfo")
    List<BookInfo> selectAll();
}
