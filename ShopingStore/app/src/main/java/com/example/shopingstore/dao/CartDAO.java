package com.example.shopingstore.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.shopingstore.entity.Cart;

@Dao
public interface CartDAO {

    @Query("SELECT * FROM cart WHERE goodsId = :goodsId")
    Cart selectByGoodsId(int goodsId);


    @Insert
    int insert(Cart cart);

    @Query("UPDATE cart SET count = count + 1 WHERE goodsId = :goodsId")
    int update(int goodsId);


}
