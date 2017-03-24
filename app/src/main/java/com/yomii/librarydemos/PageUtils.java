package com.yomii.librarydemos;

import android.content.Context;
import android.content.Intent;

import com.yomii.librarydemos.rxretrofit.GithubActivity;
import com.yomii.librarydemos.rxretrofit.DoubanActivity;

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

    public static void doubanActivity(Context context){
        context.startActivity(new Intent(context, DoubanActivity.class));
    }

    public static void githubActivity(Context context){
        context.startActivity(new Intent(context, GithubActivity.class));
    }
}
