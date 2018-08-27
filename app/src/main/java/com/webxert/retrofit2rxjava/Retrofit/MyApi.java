package com.webxert.retrofit2rxjava.Retrofit;

import com.webxert.retrofit2rxjava.Model.Post;
import com.webxert.retrofit2rxjava.Model.RootObject;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by hp on 8/9/2018.
 */

public interface MyApi {

    @GET("typicode/demo/db")
    Observable<RootObject> getJsonDatabase();

}
