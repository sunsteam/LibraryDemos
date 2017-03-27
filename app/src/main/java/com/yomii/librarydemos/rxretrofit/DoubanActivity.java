package com.yomii.librarydemos.rxretrofit;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.yomii.librarydemos.BaseActivity;
import com.yomii.librarydemos.R;
import com.yomii.librarydemos.rxretrofit.adapter.CoverAdapter;
import com.yomii.librarydemos.rxretrofit.bean.DoubanBean;
import com.yomii.librarydemos.rxretrofit.bean.Movie;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;

/**
 * 豆瓣电影/图书
 * Created by Yomii on 2017/3/23.
 */

public class DoubanActivity extends BaseActivity {


    @BindView(R.id.movie_recycle)
    RecyclerView movieRecycle;
    @BindView(R.id.book_recycle)
    RecyclerView bookRecycle;


    private CoverAdapter movieAdapter;
    private CoverAdapter bookAdapter;

    @Override
    protected void onInitVariable() {
        super.onInitVariable();
        movieAdapter = new CoverAdapter();
        bookAdapter = new CoverAdapter();
    }

    @Override
    protected void onInitView() {
        setContentView(R.layout.douban_activity);
        ButterKnife.bind(this);

        LinearLayoutManager movieManager = new LinearLayoutManager(this, LinearLayoutManager
                .HORIZONTAL, false);
        movieRecycle.setLayoutManager(movieManager);
        movieRecycle.setAdapter(movieAdapter);
        LinearLayoutManager bookManager = new LinearLayoutManager(this, LinearLayoutManager
                .HORIZONTAL, false);
        bookRecycle.setLayoutManager(bookManager);
        bookRecycle.setAdapter(bookAdapter);
    }

    @Override
    protected void onInitData() {
        ServiceHolder.getDoubanService().getCurrentMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultObserver<DoubanBean<Movie>>() {
                    @Override
                    public void onNext(DoubanBean<Movie> value) {
                        movieAdapter.setDataList(value.getSubjects());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.w("movie: ", "error");
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.i("movie: ", "complete");
                    }
                });
    }
}
