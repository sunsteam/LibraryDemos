package com.yomii.librarydemos.rxretrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.BuildConfig;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yomii on 2017/3/21.
 */

public class RetrofitManager {

    private static final String URL_DOUBAN = "https://api.douban.com/v2/";
    private static final String URL_GITHUB = "https://api.github.com/";

    private static class SingletonHolder{
        private static final RetrofitManager INSTANCE = new RetrofitManager();
    }

    public static RetrofitManager getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private RetrofitManager(){
        generateRetrofit();
    }



    private Retrofit doubanRetro;
    private Retrofit githubRetro;

    private Retrofit.Builder generateCommonRetrofitBuilder() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        builder.connectTimeout(20, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();

        return new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson));
    }

    public void generateRetrofit(){
        Retrofit.Builder builder = generateCommonRetrofitBuilder();
        doubanRetro = builder.baseUrl(URL_DOUBAN).build();
        githubRetro = builder.baseUrl(URL_GITHUB).build();
    }




}
