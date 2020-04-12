package com.example.vkrv;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {
    RecyclerView recyclerView;
    private PostsListAdapter adapter;
    private PostsListAdapter.ItemClickListener listener;
    private PostsListAdapter.FragmentButtonListener fragmentButtonListener = null;
    private PostsListAdapter.FragmentLikeListener fragmentLikeListener = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_main, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listener = new PostsListAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, Posts item) {
                Intent intent = new Intent(getActivity(), PostDetailActivity.class);
                intent.putExtra("posts", item);
                startActivity(intent);
            }
        };
        fragmentButtonListener = new PostsListAdapter.FragmentButtonListener() {
            @Override
            public void myClick(Posts posts, int option) {
                ((MainActivity) getActivity()).myClick(posts, option);
            }
        };
        fragmentLikeListener = new PostsListAdapter.FragmentLikeListener() {
            @Override
            public void removeItemLike(Posts posts) {
                ((MainActivity)getActivity()).removeItemLike(posts);
            }
        };
        adapter = new PostsListAdapter(postsGenerator(), listener, fragmentButtonListener, fragmentLikeListener);
        recyclerView.setAdapter(adapter);
        return rootView;
    }
    public void removeLike(Posts posts){
        adapter.removeLike(posts);
    }

    public List<Posts> postsGenerator() {
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
        author.add("Алматы сегодня");
        image.add(R.drawable.img8);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post8));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);
        //---------------------------------------------------------------

        logo.add(R.drawable.ztb_logo);
        author.add("ZTB| QAZAQSTAN");
        image.add(R.drawable.img11);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post11));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);

        //---------------------------------------------------------------

        logo.add(R.drawable.ztb_logo);
        author.add("ZTB| QAZAQSTAN");
        image.add(R.drawable.img12);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post12));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);

        //---------------------------------------------------------------

        logo.add(R.drawable.ztb_logo);
        author.add("ZTB| QAZAQSTAN");
        image.add(R.drawable.img13);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post13));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);

        //---------------------------------------------------------------

        logo.add(R.drawable.ztb_logo);
        author.add("ZTB| QAZAQSTAN");
        image.add(R.drawable.img14);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post14));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);


        //---------------------------------------------------------------

        logo.add(R.drawable.ztb_logo);
        author.add("ZTB| QAZAQSTAN");
        image.add(R.drawable.img15);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post15));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);

        //---------------------------------------------------------------

        logo.add(R.drawable.ztb_logo);
        author.add("ZTB| QAZAQSTAN");
        image.add(R.drawable.img16);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post16));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);

        //---------------------------------------------------------------

        logo.add(R.drawable.ztb_logo);
        author.add("ZTB| QAZAQSTAN");
        image.add(R.drawable.img17);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post17));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);

        //---------------------------------------------------------------

        logo.add(R.drawable.champions_logo);
        author.add("Champions Cup");
        image.add(R.drawable.img18);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post18));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);

        //---------------------------------------------------------------

        logo.add(R.drawable.champions_logo);
        author.add("Champions Cup");
        image.add(R.drawable.img19);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post19));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);

        //---------------------------------------------------------------

        logo.add(R.drawable.hell_logo);
        author.add("Hell's Kitchen");
        image.add(R.drawable.img20);
        time.add("Вчера в 16:00");
        description.add(getString(R.string.post20));
        comment.add("45");
        like.add(123);
        repost.add("23");
        views.add(123);
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







