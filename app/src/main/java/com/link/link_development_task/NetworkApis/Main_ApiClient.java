package com.link.link_development_task.NetworkApis;


import android.view.View;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

public class Main_ApiClient {

    public static final String API_BASE_URL ="https://newsapi.org/v1/";
    public static final String apiKey ="351d64e506a54777b93c4a7563ee4697";
    private static Retrofit retrofit = null;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

    public static <S> S createService(Class<S> serviceClass, String username, String password) {
        //  String authToken = Credentials.basic(username, password);
        //   return createService(serviceClass, authToken);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(interceptor);
        return createService(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass) {
        retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient.connectTimeout(1200000, TimeUnit.SECONDS)
                        .readTimeout(1200000,
                                TimeUnit.SECONDS).build())
                .build();
        return retrofit.create(serviceClass);
    }



}
