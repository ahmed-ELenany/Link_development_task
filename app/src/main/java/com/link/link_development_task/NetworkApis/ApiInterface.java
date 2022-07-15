package com.link.link_development_task.NetworkApis;

//___________________________________Referance____________________________________
// https://kmangutov.wordpress.com/2015/03/28/android-mvp-consuming-restful-apis/
//___________________________________Referance____________________________________


import com.link.link_development_task.model.Articles_model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiInterface {

    @GET("articles")
    Call<Articles_model> articlesApi(@Query("source") String source, @Query("apiKey") String apiKey);

    @GET("articles")
    Observable<Articles_model> GetAMFeedBack(@Query("source") String source, @Query("apiKey") String apiKey);
}