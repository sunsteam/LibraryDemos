package com.yomii.librarydemos.rxretrofit.webservice;


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


    @GET("movie/in_theaters")
    Observable<DoubanBean<Movie>> getCurrentMovies(
            @Query("count") int count,
            @Query("start") int start);


}
