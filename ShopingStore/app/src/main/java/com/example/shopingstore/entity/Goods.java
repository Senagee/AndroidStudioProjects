package com.example.shopingstore.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.shopingstore.R;

import java.util.ArrayList;

@Entity
public class Goods {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    private float price;
    private String picPath;
    private int pic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", picPath='" + picPath + '\'' +
                ", pic=" + pic +
                '}';
    }

    private static String[] gNameArray = {
            "iPhone11", "Mate30", "小米10", "OPPO Reno3", "vivo X30", "荣耀30S"
    };

    private static String[] gDescArray = {
            "Apple iPhone11 256GB 绿色 4G全网通手机",
            "华为 HUIWEI Mate30 8GB+256GB 丹霞橙 5G全网通 全面屏手机",
            "小米 MI10 8GB+256GB 钛银黑 5G手机 游戏拍照手机",
            "OPPO Reno3 8GB+128GB 蓝色星夜 双模5G 拍照游戏智能手机",
            "vivo X30 8GB+128GB 绯云 5G全网通 美颜拍照手机",
            "荣耀30S 8GB+256GB 蝶羽红 5G芯片 自拍全面屏手机"
    };

    private static float[] gPriceArray = {
            3999,5999,1999,1688,2999,5888
    } ;

    private static int[] gPicArray = {
            R.drawable.apple, R.drawable.huawei, R.drawable.xiaomi,
            R.drawable.oppo, R.drawable.vivo, R.drawable.rongyao
    };

    //构建默认的手机信息列表
    public static ArrayList<Goods> getDefaultList(){
        ArrayList<Goods> goodsList = new ArrayList<>();
        for(int i = 0; i < gNameArray.length; i++){
            Goods good = new Goods();
            good.setId(i);
            good.setName(gNameArray[i]);
            good.setDescription(gDescArray[i]);
            good.setPrice(gPicArray[i]);
            good.setPic(gPicArray[i]);
            goodsList.add(good);
        }
        return goodsList;
    }
}
