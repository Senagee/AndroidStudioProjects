package com.example.shopingstore.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.shopingstore.dao.GoodsDAO;
import com.example.shopingstore.entity.Goods;

@Database(entities = {Goods.class}, version = 1)
public abstract class StoreDataBase extends RoomDatabase {
    public abstract GoodsDAO getGoodsDAO();

}
