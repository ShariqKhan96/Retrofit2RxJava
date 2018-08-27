package com.webxert.retrofit2rxjava.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp on 8/9/2018.
 */

public class RetrofitBuilder {
    private static Retrofit ourInstance = null;

    public static Retrofit getInstance() {
        if (ourInstance == null)
            ourInstance = new Retrofit.Builder()
                    .baseUrl("https://my-json-server.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        return ourInstance;

    }

    private RetrofitBuilder() {
    }
}
