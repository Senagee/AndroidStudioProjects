package com.example.shopingstore.util;

import android.graphics.Bitmap;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    //path   为需要保存到的路径
    //bitmap 为图片的资源
    public static void saveImage(String path, Bitmap bitmap)  {
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(fos != null)
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
