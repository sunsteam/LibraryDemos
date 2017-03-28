package com.yomii.librarydemos.rxretrofit.webservice;


import com.yomii.librarydemos.rxretrofit.bean.Book;
import com.yomii.librarydemos.rxretrofit.bean.DoubanBean;
import com.yomii.librarydemos.rxretrofit.bean.Movie;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 豆瓣电影api
 * Created by Yomii on 2017/3/22.
 */

public interface DoubanService {


    /**
     * 获取正在上映电影
     *
     * @param count 单页条数
     * @param start 初始索引
     */
    @GET("movie/in_theaters")
    Observable<DoubanBean<Movie>> getCurrentMovies(
            @Query("count") int count,
            @Query("start") int start);

    /**
     * 获取图书列表, key或tag必传其一
     *
     * @param key 通过关键字搜索
     * @param tag 通过标签搜素
     */
    @GET("book/search")
    Observable<DoubanBean<Book>> getBooks(
            @Query("q") String key,
            @Query("tag") String tag,
            @Query("count") int count,
            @Query("start") int start);


}
