package com.webxert.retrofit2rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.webxert.retrofit2rxjava.Adapter.PostAdapter;
import com.webxert.retrofit2rxjava.Model.Post;
import com.webxert.retrofit2rxjava.Model.RootObject;
import com.webxert.retrofit2rxjava.Retrofit.MyApi;
import com.webxert.retrofit2rxjava.Retrofit.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    CompositeDisposable compositeDisposable = new CompositeDisposable();
    RecyclerView recyclerView;
    MyApi myApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.postRecylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        Retrofit retrofit = RetrofitBuilder.getInstance();
        myApi = retrofit.create(MyApi.class);

        try {
            getData();
        } catch (Exception e) {
            Log.e("Exception", e.getLocalizedMessage());
        }


    }

    private void getData() {

        compositeDisposable.add(myApi.getJsonDatabase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RootObject>() {
                    @Override
                    public void accept(RootObject rootObject) throws Exception {
                        Log.e("postsListSize", String.valueOf(rootObject.getPosts().size()));
                        Log.e("commentsListSize", String.valueOf(rootObject.getComments().size()));
                        Log.e("profileObject", rootObject.getProfile().getName());
                    }
                }));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();

    }
}
