package com.yomii.librarydemos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.yomii.librarydemos.databinding.MovieActivity;
import com.yomii.librarydemos.imagepicker.ImageFuncActivity;
import com.yomii.librarydemos.qrcode.ScanCodeActivity;
import com.yomii.librarydemos.rxretrofit.DoubanActivity;
import com.yomii.librarydemos.rxretrofit.GithubActivity;
import com.yomii.librarydemos.rxretrofit.RxRetrofitActivity;
import com.yomii.librarydemos.rxretrofit.bean.Cover;
import com.yomii.librarydemos.transition.LargeImageActivity;

/**
 * 页面跳转辅助类
 * Created by Yomii on 2017/3/17.
 */

public class PageUtils {


    public static void imageFuncActivity(Context context){
        context.startActivity(new Intent(context, ImageFuncActivity.class));
    }

    public static void rxRetrofitActivity(Context context){
        context.startActivity(new Intent(context, RxRetrofitActivity.class));
    }

    public static void scanCodeActivity(Context context){
        context.startActivity(new Intent(context, ScanCodeActivity.class));
    }

    public static void doubanActivity(Context context){
        context.startActivity(new Intent(context, DoubanActivity.class));
    }

    public static void githubActivity(Context context){
        context.startActivity(new Intent(context, GithubActivity.class));
    }

    public static void movieDetailActivity(Context context, Cover data){
        Intent intent = new Intent(context, MovieActivity.class);
        intent.putExtra("data", data);
        context.startActivity(intent);
    }

    public static void largeImageActivity(String imageUrl, Activity from, View imageView){
        LargeImageActivity.shareImageToHere(imageUrl,from,imageView);
    }
}
