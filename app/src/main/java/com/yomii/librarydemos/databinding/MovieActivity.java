package com.yomii.librarydemos.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;

import com.yomii.librarydemos.R;
import com.yomii.librarydemos.base.BaseActivity;
import com.yomii.librarydemos.rxretrofit.adapter.StaffAdapter;
import com.yomii.librarydemos.rxretrofit.bean.Movie;

/**
 * 豆瓣电影详情页
 * Created by Yomii on 2017/3/27.
 */

public class MovieActivity extends BaseActivity {


    private com.yomii.librarydemos.databinding.MovieDetailActivityBinding binding;

    @Override
    protected void onInitView() {
        binding = DataBindingUtil.setContentView(this, R.layout.movie_detail_activity);
        binding.setCastManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.setDirectorManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

    @Override
    protected void onInitData() {
        Movie data = getIntent().getParcelableExtra("data");
        binding.setMovie(data);

        StaffAdapter castAdapter = new StaffAdapter();
        castAdapter.setDataList(data.getCasts());
        binding.setCastAdapter(castAdapter);

        StaffAdapter directorAdapter = new StaffAdapter();
        directorAdapter.setDataList(data.getDirectors());
        binding.setDirectorAdapter(directorAdapter);
    }
}
