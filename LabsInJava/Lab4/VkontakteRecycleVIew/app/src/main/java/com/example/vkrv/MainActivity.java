package com.example.vkrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PostsListAdapter adapter;
    private PostsListAdapter.ItemClickListener listener = new PostsListAdapter.ItemClickListener() {
        @Override
        public void itemClick(int position, Posts item) {
            Intent intent = new Intent(MainActivity.this, PostDetailActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("posts", item);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.scrollToPosition(getIntent().getIntExtra("index", 0));

        adapter = new PostsListAdapter(postsGenerator(), listener, this);
        recyclerView.setAdapter(adapter);
    }




    private List<Posts> postsGenerator() {
        List<Posts> items = new ArrayList<>();
        ArrayList<Integer> logo = new ArrayList<>();
        ArrayList<String> author = new ArrayList<>();
        ArrayList<Integer> image = new ArrayList<>();
        ArrayList<String> time = new ArrayList<>();
        ArrayList<String> description = new ArrayList<>();
        ArrayList<Integer> like = new ArrayList<>();
        ArrayList<String> comment = new ArrayList<>();
        ArrayList<String> repost = new ArrayList<>();
        ArrayList<Integer> views = new ArrayList<>();

        //1---------------------------------------------------------------
        logo.add(R.drawable.ztb_logo);
        author.add("ZTB| QAZAQSTAN");
        image.add(R.drawable.img1);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post1));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);
        //2---------------------------------------------------------------
        logo.add(R.drawable.ztb_logo);
        author.add("ZTB| QAZAQSTAN");
        image.add(R.drawable.img2);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post2));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);
        //3---------------------------------------------------------------

        logo.add(R.drawable.hell_logo);
        author.add("Hell's Kitchen");
        image.add(R.drawable.img10);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post10));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);

        //4---------------------------------------------------------------

        logo.add(R.drawable.art_logo);
        author.add("Factura-блог");
        image.add(R.drawable.img4);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post4));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);
        //5--------------------------------------------------------------

        logo.add(R.drawable.ztb_logo);
        author.add("ZTB| QAZAQSTAN");
        image.add(R.drawable.img3);
        description.add(getString(R.string.post3));
        time.add("Вчера в 16:00");
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);
        //---------------------------------------------------------------

        logo.add(R.drawable.art_logo);
        author.add("Factura-блог");
        image.add(R.drawable.img5);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post5));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);
        //---------------------------------------------------------------

        logo.add(R.drawable.marvel_logo);
        author.add("Marvel/DC");
        image.add(R.drawable.img7);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post7));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);
        //---------------------------------------------------------------

        logo.add(R.drawable.goal_logo);
        author.add("Goal Europe");
        image.add(R.drawable.img9);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post9));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);
        //---------------------------------------------------------------

        logo.add(R.drawable.art_logo);
        author.add("Factura-блог");
        image.add(R.drawable.img6);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post6));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);
        //---------------------------------------------------------------

        logo.add(R.drawable.almaty_logo);
        author.add("Adruino");
        image.add(R.drawable.img8);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post8));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);
        //---------------------------------------------------------------
        for (int i = 0; i < logo.size(); i++) {
            Posts posts = new Posts(
                    logo.get(i),
                    author.get(i),
                    image.get(i),
                    time.get(i),
                    description.get(i),
                    like.get(i),
                    comment.get(i),
                    repost.get(i),
                    views.get(i)
            );
            items.add(posts);

        }
        return items;
    }
}





