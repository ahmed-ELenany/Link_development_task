package com.link.link_development_task.NetworkApis;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.link.link_development_task.Utilities.NetworkUtil;
import com.link.link_development_task.model.Articles_model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    Context context;
    RecyclerView recyclerView;

    public Repository(Context context){
        this.context=context;

    }
    public MutableLiveData<Articles_model> getArticle(String source){
        final  MutableLiveData<Articles_model> data =new MutableLiveData<>();

            ApiInterface apiService = Main_ApiClient.createService(ApiInterface.class, "", "");
            Call<Articles_model> call = apiService.articlesApi(source, Main_ApiClient.apiKey);
            call.enqueue(new Callback<Articles_model>() {

                @Override
                public void onResponse(@NonNull Call<Articles_model> call, @NonNull Response<Articles_model> response) {
                    data.setValue(response.body());
                }

                @Override
                public void onFailure(@NonNull Call<Articles_model> call, Throwable t) {
                    data.setValue(null);
                }
            });

        return data;
    }
}
