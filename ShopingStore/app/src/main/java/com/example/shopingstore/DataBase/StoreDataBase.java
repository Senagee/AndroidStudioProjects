package com.example.shopingstore.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.shopingstore.dao.CartDAO;
import com.example.shopingstore.dao.GoodsDAO;
import com.example.shopingstore.entity.Cart;
import com.example.shopingstore.entity.Goods;

@Database(entities = {Goods.class, Cart.class}, version = 1, exportSchema = true)
public abstract class StoreDataBase extends RoomDatabase {

    public abstract GoodsDAO getGoodsDAO();
    public abstract CartDAO getCartDAO();

}
