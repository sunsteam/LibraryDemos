package com.yomii.librarydemos.rxretrofit;

import com.yomii.librarydemos.rxretrofit.webservice.DoubanService;

/**
 *
 * Created by Yomii on 2017/3/24.
 */

public class ServiceHolder {


    private static DoubanService doubanService;

    public static DoubanService getDoubanService() {
        if (doubanService == null) {
            synchronized (ServiceHolder.class) {
                if (doubanService == null) {
                    doubanService = RetrofitManager.getInstance()
                            .getDoubanRetro().create(DoubanService.class);
                }
            }
        }
        return doubanService;
    }

}
