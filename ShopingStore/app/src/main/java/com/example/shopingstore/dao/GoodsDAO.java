package com.example.shopingstore.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.shopingstore.entity.Goods;

@Dao
public interface GoodsDAO {
    @Insert
    void insert(Goods good);
}
