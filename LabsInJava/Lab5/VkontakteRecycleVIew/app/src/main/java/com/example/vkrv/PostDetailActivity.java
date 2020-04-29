package com.example.vkrv;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;


public class PostDetailActivity extends AppCompatActivity {
    private ImageView logo;
    private ImageView image;
    private TextView author;
    private TextView time;
    private TextView description;
    private Button btnLike;
    private Button btnRepost;
    private TextView views;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        image = findViewById(R.id.image);
        logo = findViewById(R.id.logo);
        author = findViewById(R.id.author);
        time= findViewById(R.id.tvPostTime);
        description= findViewById(R.id.tvDescription);
        btnLike = findViewById(R.id.btnLike);
        btnRepost = findViewById(R.id.btnRepost);
        views = findViewById(R.id.views);
        final Posts posts = (Posts) getIntent().getParcelableExtra("posts");
        Glide.with(logo.getContext()).load(posts.getLogo()).into(logo);

        image.setImageResource(posts.getImage());
        description.setText(posts.getDescription());
        author.setText(posts.getAuthor());
        time.setText(posts.getTime());
        btnLike.setText(String.valueOf(posts.getLike()));
        btnRepost.setText(posts.getRepost());
        views.setText(String.valueOf(posts.getViews()));

    }
}
