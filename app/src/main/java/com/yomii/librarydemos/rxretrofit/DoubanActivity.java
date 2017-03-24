package com.yomii.librarydemos.rxretrofit;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.yomii.librarydemos.BaseActivity;
import com.yomii.librarydemos.R;
import com.yomii.librarydemos.rxretrofit.bean.DoubanBean;
import com.yomii.librarydemos.rxretrofit.bean.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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

    @Override
    protected void onInitView() {
        setContentView(R.layout.douban_activity);
        ButterKnife.bind(this);

        LinearLayoutManager movieManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        LinearLayoutManager bookManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        movieRecycle.setLayoutManager(movieManager);
        bookRecycle.setLayoutManager(bookManager);
    }

    @Override
    protected void onInitData() {
        ServiceHolder.getMovieService().getCurrentMovies()
                .subscribe(new DefaultObserver<DoubanBean<Movie>>() {
                    @Override
                    public void onNext(DoubanBean<Movie> value) {
                        List<Movie> subjects = value.getSubjects();
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
