package com.yomii.librarydemos.rxretrofit;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

import com.yomii.librarydemos.BR;
import com.yomii.librarydemos.R;
import com.yomii.librarydemos.base.BaseActivity;

/**
 * 豆瓣电影详情页
 * Created by Yomii on 2017/3/27.
 */

public class MovieActivity extends BaseActivity {


    private ViewDataBinding binding;

    @Override
    protected void onInitView() {
        binding = DataBindingUtil.setContentView(this, R.layout.movie_detail_activity);
    }

    @Override
    protected void onInitData() {
        binding.setVariable(BR.movie, getIntent().getParcelableExtra("data"));
    }
}
