package com.link.link_development_task.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.link.link_development_task.R;
import com.link.link_development_task.model.Articles_model;
import com.link.link_development_task.view.ArticleDetailsActivity;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.viewHolder> {

    private final Context context;
    List<Articles_model.ArticleData> dataList;
    SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    SimpleDateFormat myFormat = new SimpleDateFormat("LLL dd, yyyy");
    public ArticleAdapter(Context c, List<Articles_model.ArticleData> dataList) {
        this.context = c;
        this.dataList = dataList;

    }


    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_row, parent, false);
        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, final int position) {
        holder.tvTitle.setText(dataList.get(position).getTitle());
        holder.tvAuthor.setText("By "+dataList.get(position).getAuthor());
        try {
             holder.tvPublishedAt.setText(myFormat.format(fromUser.parse(dataList.get(position).getPublishedAt())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Picasso.with(context).load(dataList.get(position).getUrlToImage()).error(R.drawable.placeholder).fit().into(holder.ivArticleImage);

        holder.LLcontainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              context.startActivity(new Intent(context, ArticleDetailsActivity.class)
                      .putExtra("author", dataList.get(position).getAuthor())
                      .putExtra("title", dataList.get(position).getTitle())
                      .putExtra("description", dataList.get(position).getDescription())
                      .putExtra("url", dataList.get(position).getUrl())
                      .putExtra("urlToImage", dataList.get(position).getUrlToImage())
                      .putExtra("publishedAt", dataList.get(position).getPublishedAt()));

            }
        });


    }


    //**********************************************************************************************************
    @Override
    public int getItemCount() {

        return dataList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle, tvAuthor, tvPublishedAt;
        LinearLayout LLcontainer;
        ImageView ivArticleImage;
        public viewHolder(View itemView) {
            super(itemView);
            ivArticleImage = itemView.findViewById(R.id.ivArticleImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvPublishedAt = itemView.findViewById(R.id.tvPublishedAt);
            LLcontainer = itemView.findViewById(R.id.LLcontainer);

        }
    }
}
