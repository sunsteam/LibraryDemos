package com.yomii.librarydemos.rxretrofit.webservice;


import com.yomii.librarydemos.rxretrofit.bean.DoubanBean;
import com.yomii.librarydemos.rxretrofit.bean.Movie;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 豆瓣电影api
 * Created by Yomii on 2017/3/22.
 */

public interface DoubanMovieService {


    @GET("movie/in_theaters")
    Observable<DoubanBean<Movie>> getCurrentMovies();
}
