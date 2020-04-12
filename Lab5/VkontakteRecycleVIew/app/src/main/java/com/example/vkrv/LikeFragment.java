package com.example.vkrv;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class LikeFragment extends Fragment {
    RecyclerView recyclerView;
    private LikedListAdapter adapter;
    private List<Posts> postsList;
    private LikedListAdapter.ItemClickListener listener ;
    private LikedListAdapter.FragmentLikeListener fragmentLikeListener ;


    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_like, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        listener = new LikedListAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, Posts item) {
                Intent intent = new Intent(getActivity(), PostDetailActivity.class);
                intent.putExtra("posts", item);
                startActivity(intent);
            }
        };
        fragmentLikeListener = new LikedListAdapter.FragmentLikeListener() {
            @Override
            public void removeItemLike(Posts posts) {
                ((MainActivity)getActivity()).removeItemLike(posts);
            }
        };
        postsList = new ArrayList<>();
        adapter = new LikedListAdapter(postsList, listener, fragmentLikeListener);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    public void savePosts(Posts posts)
    {
        postsList.add(posts);
        recyclerView.getAdapter().notifyItemInserted(postsList.size()-1);
    }

    public void removePosts(Posts posts)
    {
        if(postsList.indexOf(posts)==0){
            postsList.remove(posts);
        }
        else {
            int position = postsList.indexOf(posts);
            postsList.remove(posts);
            recyclerView.getAdapter().notifyItemRemoved(position);

        }
    }
    public void removeLike(Posts posts)
    {
        int p = postsList.indexOf(posts);
        this.removePosts(posts);
        adapter.notifyItemRemoved(p);
    }



}
