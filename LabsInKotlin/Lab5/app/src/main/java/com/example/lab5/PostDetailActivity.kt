package com.example.lab5

import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import java.lang.String


class PostDetailActivity : AppCompatActivity() {
    private var logo: ImageView? = null
    private var image: ImageView? = null
    private var author: TextView? = null
    private var time: TextView? = null
    private var description: TextView? = null
    private var btnLike: Button? = null
    private var btnRepost: Button? = null
    private var views: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)
        image = findViewById(R.id.image)
        logo = findViewById(R.id.logo)
        author = findViewById(R.id.author)
        time = findViewById(R.id.tvPostTime)
        description = findViewById(R.id.tvDescription)
        btnLike = findViewById(R.id.btnLike)
        btnRepost = findViewById(R.id.btnRepost)
        views = findViewById(R.id.views)
        val posts = intent.getParcelableExtra<Parcelable>("posts") as Posts
        Glide.with(logo.getContext()).load(posts.getLogo()).into(logo)
        image.setImageResource(posts.getImage())
        description.setText(posts.getDescription())
        author.setText(posts.getAuthor())
        time.setText(posts.getTime())
        btnLike.setText(String.valueOf(posts.getLike()))
        btnRepost.setText(posts.getRepost())
        views.setText(String.valueOf(posts.getViews()))
    }
}

