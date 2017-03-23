package com.yomii.librarydemos;

import android.content.Context;
import android.content.Intent;

import com.yomii.librarydemos.rxretrofit.DoubanBookActivity;
import com.yomii.librarydemos.rxretrofit.DoubanMovieActivity;

/**
 * 页面跳转辅助类
 * Created by Yomii on 2017/3/17.
 */

public class PageUtils {

    public static void imageFuncActivity(Context context){
        context.startActivity(new Intent(context, ImageFuncActivity.class));
    }

    public static void RxRetrofitActivity(Context context){
        context.startActivity(new Intent(context, RxRetrofitActivity.class));
    }

    public static void DoubanMovieActivity(Context context){
        context.startActivity(new Intent(context, DoubanMovieActivity.class));
    }

    public static void DoubanBookActivity(Context context){
        context.startActivity(new Intent(context, DoubanBookActivity.class));
    }
}
