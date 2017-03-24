package com.yomii.librarydemos.rxretrofit;

import com.yomii.librarydemos.rxretrofit.webservice.DoubanBookService;
import com.yomii.librarydemos.rxretrofit.webservice.DoubanMovieService;

/**
 *
 * Created by Yomii on 2017/3/24.
 */

public class ServiceHolder {


    private static DoubanMovieService movieService;
    private static DoubanBookService bookService;

    public static DoubanMovieService getMovieService() {
        if (movieService == null) {
            synchronized (ServiceHolder.class) {
                if (movieService == null) {
                    movieService = RetrofitManager.getInstance()
                            .getDoubanRetro().create(DoubanMovieService.class);
                }
            }
        }
        return movieService;
    }

    public static DoubanBookService getBookService() {
        if (bookService == null) {
            synchronized (ServiceHolder.class) {
                if (bookService == null) {
                    bookService = RetrofitManager.getInstance()
                            .getDoubanRetro().create(DoubanBookService.class);
                }
            }
        }
        return bookService;
    }
}
