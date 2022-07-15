package com.link.link_development_task.view;

 import android.content.Intent;
 import android.net.Uri;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.View;
 import android.widget.Button;
 import android.widget.ImageView;
 import android.widget.LinearLayout;
 import android.widget.TextView;

 import androidx.appcompat.app.AppCompatActivity;

 import com.link.link_development_task.R;
 import com.squareup.picasso.Picasso;

 import java.text.ParseException;
 import java.text.SimpleDateFormat;

public class ArticleDetailsActivity extends AppCompatActivity {
    public TextView tvTitle, tvAuthor, tvPublishedAt,tvDescription;
     ImageView ivArticleImage;
     Button btnOpenUrl;
    SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    SimpleDateFormat myFormat = new SimpleDateFormat("LLL dd, yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvTitle = findViewById(R.id.tvTitle);
        tvAuthor = findViewById(R.id.tvAuthor);
        tvPublishedAt = findViewById(R.id.tvPublishedAt);
        ivArticleImage = findViewById(R.id.ivArticleImage);
        tvDescription = findViewById(R.id.tvDescription);
        ivArticleImage = findViewById(R.id.ivArticleImage);
        btnOpenUrl= findViewById(R.id.btnOpenUrl);
         Intent i =getIntent();
        String author = i.getStringExtra("author");
        String title = i.getStringExtra("title");
        String description = i.getStringExtra("description");
        String url = i.getStringExtra("url");
        String urlToImage = i.getStringExtra("urlToImage");
        String publishedAt = i.getStringExtra("publishedAt");

        tvTitle.setText(title);
        tvAuthor.setText(author);
        try {
            tvPublishedAt.setText(myFormat.format(fromUser.parse(publishedAt)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tvDescription.setText(description);
        Picasso.with(getApplication()).load(urlToImage).error(R.drawable.placeholder).fit().into( ivArticleImage);


        btnOpenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}