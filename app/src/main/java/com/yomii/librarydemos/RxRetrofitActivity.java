package com.yomii.librarydemos;

import android.view.View;

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
