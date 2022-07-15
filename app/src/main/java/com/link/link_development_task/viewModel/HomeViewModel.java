package com.link.link_development_task.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.link.link_development_task.NetworkApis.Repository;
import com.link.link_development_task.model.Articles_model;

public class HomeViewModel extends ViewModel {


    public HomeViewModel() {
    }
    public MutableLiveData<Articles_model> getArticle(Context context,String source) {
        Repository repository =new Repository(context);
        return repository.getArticle(source);
    }

}