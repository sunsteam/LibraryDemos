package com.yomii.librarydemos.rxretrofit;

import android.os.Parcelable;

import com.yomii.librarydemos.base.BaseActivity;
import com.yomii.librarydemos.rxretrofit.bean.Movie;

/**
 * 豆瓣电影/图书详情页
 * Created by Yomii on 2017/3/27.
 */

public class DoubanDetailActivity extends BaseActivity {


    @Override
    protected void onInitView() {
        Parcelable data = getIntent().getParcelableExtra("data");
        if (data instanceof Movie){

        }
    }

    @Override
    protected void onInitData() {

    }
}
