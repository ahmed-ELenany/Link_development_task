package com.link.link_development_task.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.link.link_development_task.MainActivity;
import com.link.link_development_task.R;
import com.link.link_development_task.Utilities.NetworkUtil;
import com.link.link_development_task.Utilities.UtilsClass;
import com.link.link_development_task.adapters.ArticleAdapter;
import com.link.link_development_task.model.Articles_model;
import com.link.link_development_task.viewModel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
     ArticleAdapter articleAdapter;
    RecyclerView recyclerView;
    List<Articles_model.ArticleData>  articlesList =new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView =view.findViewById(R.id.recyclerView);

        setupViewModel();
        return view;
    }
    private void setupViewModel() {
         if(NetworkUtil.isNetworkAvaliable(getContext())) {
            UtilsClass.init_Progress_Dialog(getContext());
            UtilsClass.Show_Progress_Dialog();
            homeViewModel.getArticle(getActivity(), "associated-press").observe(getViewLifecycleOwner(), new Observer<Articles_model>() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onChanged(Articles_model data) {
                    articlesList.addAll(data.getArticles()) ;
                    articleAdapter = new ArticleAdapter(getContext(), articlesList);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    ((LinearLayoutManager) mLayoutManager).setOrientation(RecyclerView.VERTICAL);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(articleAdapter);
                }
            });
            homeViewModel.getArticle(getActivity(), "the-next-web").observe(getViewLifecycleOwner(), new Observer<Articles_model>() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onChanged(Articles_model data) {
                    articlesList.addAll(data.getArticles()) ;
                    articleAdapter = new ArticleAdapter(getContext(), articlesList);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    ((LinearLayoutManager) mLayoutManager).setOrientation(RecyclerView.VERTICAL);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(articleAdapter);
                    UtilsClass.Hide_Progress_Dialog();

                }
            });


        }




    }

     @Override
    public void onDestroyView() {
        super.onDestroyView();
     }
}