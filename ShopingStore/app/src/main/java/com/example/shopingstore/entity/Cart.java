package com.example.shopingstore.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "cart",
        foreignKeys = @ForeignKey(
                entity = Goods.class,
                parentColumns = "id",
                childColumns = "goodsId",
                onDelete = ForeignKey.CASCADE)
)
public class Cart {
    @PrimaryKey
    private int id;

    private int goodsId;
    @ColumnInfo(defaultValue = "1")
    private int count;

    public Cart(int id, int goodsId, int count) {
        this.id = id;
        this.goodsId = goodsId;
        this.count = count;
    }

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", count=" + count +
                '}';
    }
}
