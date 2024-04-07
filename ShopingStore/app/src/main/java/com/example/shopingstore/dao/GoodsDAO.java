package com.example.shopingstore.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.shopingstore.entity.Goods;

import java.util.List;

@Dao
public interface GoodsDAO {

    @Insert
    void insert(Goods... good);

    @Query("SELECT * FROM goods")
    List<Goods> selectAll();
}
