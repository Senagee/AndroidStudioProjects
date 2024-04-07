package com.example.shopingstore;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shopingstore.dao.CartDAO;
import com.example.shopingstore.dao.GoodsDAO;
import com.example.shopingstore.entity.Cart;
import com.example.shopingstore.entity.Goods;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GoodsDAO goodsDAO;
    private CartDAO cartDAO;
    private GridLayout gl_goods;
    private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goodsDAO = MyApplication.getInstance().getSDB().getGoodsDAO();
        cartDAO = MyApplication.getInstance().getSDB().getCartDAO();

        gl_goods = findViewById(R.id.gl_goods);


        tv_title = findViewById(R.id.tv_title);
        tv_title.setText("手机商城");

        showGoods();

    }
    private void showGoods(){
        //获取屏幕的宽度
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(screenWidth / 2, LinearLayout.LayoutParams.WRAP_CONTENT);
        //查询所有商品
        List<Goods> goods = goodsDAO.selectAll();


        for(Goods good : goods){
            Log.d("liu", good.toString());
            //获取item_goods根视图
            View view = LayoutInflater.from(this).inflate(R.layout.item_goods, null);
            TextView tv_name = view.findViewById(R.id.tv_name);
            ImageView iv_img = view.findViewById(R.id.iv_img);
            TextView tv_price = view.findViewById(R.id.tv_price);

            tv_name.setText(good.getName());
            iv_img.setImageURI(Uri.parse(good.getPicPath()));
            tv_price.setText(String.valueOf(good.getPrice()));
            findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //加入购物车，并且购物车图标+1
                    /*
                    先找出货物的id， 再去cart表中selsect()是否已有对应商品
                    有- -> 执行upDate（）， 没有--> 执行insert()

                    */
                    //addCart(goodsId, name);
                }
            });
            //添加进网格布局
            gl_goods.addView(view, params);
        }

    }


    //可用关联查询的DAO操作
    private void addCart(int goodsId, String name){

            Cart cart = cartDAO.selectByGoodsId(goodsId);
            Cart newCart = null;
            if(cart == null) {
                newCart = new Cart();
                newCart.setGoodsId(goodsId);
                cartDAO.insert(newCart);
            }
            else
                cartDAO.update(goodsId);
        }
    }

}