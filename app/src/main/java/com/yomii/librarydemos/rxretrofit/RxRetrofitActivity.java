package com.yomii.librarydemos.rxretrofit;

import android.view.View;

import com.yomii.librarydemos.PageUtils;
import com.yomii.librarydemos.R;
import com.yomii.librarydemos.base.BaseActivity;

/**
 * RxRetrofit Entry
 * Created by Yomii on 2017/3/21.
 */

public class RxRetrofitActivity extends BaseActivity {


    @Override
    protected void onInitView() {
        setContentView(R.layout.rx_retrofit_activity);
    }

    @Override
    protected void onInitData() {

    }

    public void toDouban(View v){
        PageUtils.doubanActivity(this);
    }

    public void toGithub(View v){
        PageUtils.githubActivity(this);
    }

}
