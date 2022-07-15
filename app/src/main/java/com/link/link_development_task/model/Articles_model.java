package com.link.link_development_task.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Articles_model {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("sortBy")
    @Expose
    private String sortBy;

    @SerializedName("articles")
    @Expose
    private List<ArticleData> articles;

    public String getStatus() {
        return status;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getSource() {
        return source;
    }

    public List<ArticleData> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleData> articles) {
        this.articles = articles;
    }

    public class ArticleData{


        @SerializedName("author")
        @Expose
        private String author;

        @SerializedName("title")
        @Expose
        private String title;

        @SerializedName("description")
        @Expose
        private String description;

        @SerializedName("url")
        @Expose
        private String url;

        @SerializedName("urlToImage")
        @Expose
        private String urlToImage;

        @SerializedName("publishedAt")
        @Expose
        private String publishedAt;

        public String getStatus() {
            return status;
        }

        public String getDescription() {
            return description;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public String getUrl() {
            return url;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }

}
