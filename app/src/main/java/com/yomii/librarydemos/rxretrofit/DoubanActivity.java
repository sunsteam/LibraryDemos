package com.yomii.librarydemos.rxretrofit;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.yomii.librarydemos.R;
import com.yomii.librarydemos.base.AutoDisposeObserver;
import com.yomii.librarydemos.base.BaseActivity;
import com.yomii.librarydemos.rxretrofit.adapter.CoverAdapter;
import com.yomii.librarydemos.rxretrofit.bean.Cover;
import com.yomii.librarydemos.rxretrofit.bean.DoubanBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;

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
    private CoverObserver movieObserver;
    private CoverObserver bookObserver;

    private int movieIndex;
    private int bookIndex;

    @Override
    protected void onInitVariable() {
        super.onInitVariable();
        movieAdapter = new CoverAdapter();
        bookAdapter = new CoverAdapter();

        movieObserver = new CoverObserver("movie");
        bookObserver = new CoverObserver("book");

    }

    @Override
    protected void onInitView() {
        setContentView(R.layout.douban_activity);
        ButterKnife.bind(this);

        final LinearLayoutManager movieManager = new LinearLayoutManager(this, LinearLayoutManager
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

        loadMovie();

        loadBook();

        movieRecycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //手指向左滑动且下一个索引可用且Observer并没有在观察中
                if (dx > 0 && movieIndex > 0 && movieObserver.isDisposed()) {
                    int lastPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                    int itemCount = recyclerView.getLayoutManager().getItemCount();
                    //有内容且倒数第二个内容可见
                    if (itemCount > 0 && lastPosition == itemCount - 2)
                        loadMovie();
                }
            }
        });

        bookRecycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //手指向左滑动且下一个索引可用且Observer并没有在观察中
                if (dx > 0 && bookIndex > 0 && bookObserver.isDisposed()) {
                    int lastPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                    int itemCount = recyclerView.getLayoutManager().getItemCount();
                    //有内容且倒数第二个内容可见
                    if (itemCount > 0 && lastPosition == itemCount - 2)
                        loadBook();
                }
            }
        });
    }

    private void loadMovie() {
        ServiceHolder.getDoubanService().getCurrentMovies(10, movieIndex)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnDispose(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.w("onDispose", "movie");
                    }
                })
                .subscribe(movieObserver);
    }

    private void loadBook() {
        ServiceHolder.getDoubanService().getBooks(null, "小说", 10, bookIndex)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnDispose(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.w("onDispose", "book");
                    }
                })
                .subscribe(bookObserver);
    }

    private class CoverObserver extends AutoDisposeObserver<DoubanBean<? extends Cover>> {

        private String type;

        CoverObserver(String type) {
            this.type = type;
        }

        @Override
        public void onNext(DoubanBean<? extends Cover> value) {
            switch (type) {
                case "movie":
                    movieIndex = value.getNextStart();
                    movieAdapter.addDataFromList(value.getSubjects());
                    break;
                case "book":
                    bookIndex = value.getNextStart();
                    bookAdapter.addDataFromList(value.getSubjects());
                    break;
            }
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            Log.w(type, "error");
        }

        @Override
        public void onComplete() {
            super.onComplete();
            Log.i(type, "complete");
        }
    }

}
