package com.example.vkrv;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

public class PostsListAdapter extends RecyclerView.Adapter<PostsListAdapter.PostsViewHolder> {

    private List<Posts> postsList;

    private @Nullable ItemClickListener listener;
    private @Nullable FragmentButtonListener fragmentButtonListener;
    private @Nullable FragmentLikeListener fragmentLikeListener;


    public PostsListAdapter(List<Posts> postsList,
                            @Nullable ItemClickListener listener,
                            @Nullable FragmentButtonListener fragmentButtonListener,
                            @Nullable FragmentLikeListener fragmentLikeListener)

    {   Posts.postsList = postsList;
        this.postsList = postsList;
        this.listener = listener;
        this.fragmentButtonListener = fragmentButtonListener;
        this.fragmentLikeListener = fragmentLikeListener;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_posts, null, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new PostsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final PostsViewHolder holder, final int position) {
        final Posts posts = Posts.postsList.get(getItemViewType(position));
        Glide.with(holder.image.getContext()).load(posts.getImage()).into(holder.image);
        Glide.with(holder.logo.getContext()).load(posts.getLogo()).into(holder.logo);
//       holder.image.setImageResource(posts.getImage());
//       holder.logo.setImageResource(posts.getLogo());

        holder.author.setText(posts.getAuthor());
        holder.time.setText(posts.getTime());
        holder.description.setText(String.valueOf(posts.getDescription()));
        holder.btnLike.setText(posts.getLike()+"");
        holder.views.setText(String.valueOf(posts.getViews()));
        holder.btnComment.setText(String.valueOf(posts.getComment()));
        holder.btnRepost.setText(String.valueOf(posts.getRepost()));
        if(posts.isLiked()==true){
            holder.btnLike.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_favorite_black_24dp, 0, 0, 0); }
        else{
            holder.btnLike.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_favorite_border_black_24dp, 0, 0, 0);
            }
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(fragmentButtonListener!=null){
                    if(posts.isLiked()){
                        holder.btnLike.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_favorite_border_black_24dp, 0, 0, 0);
                        fragmentButtonListener.myClick(posts, 2);
                        fragmentLikeListener.removeItemLike(posts);
                        posts.setLiked(false);
                        int num = Integer.parseInt(holder.btnLike.getText().toString());
                        holder.btnLike.setText(String.valueOf(num-1));
                    }
                    else
                    {
                        holder.btnLike.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_favorite_black_24dp, 0, 0, 0);
                        fragmentButtonListener.myClick(posts, 1);
                        posts.setLiked(true);
                        int num = Integer.parseInt(holder.btnLike.getText().toString());
                        holder.btnLike.setText(String.valueOf(num+1));
                    }
                }
//            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.itemClick(position, posts);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Posts.postsList.size();
    }


    public class PostsViewHolder extends RecyclerView.ViewHolder {
        ImageView logo;
        TextView author;
        ImageView image;
        TextView time;;
        TextView description;
        Button btnLike;
        Button btnComment;
        Button btnRepost;
        TextView views;


        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.logo);
            author = itemView.findViewById(R.id.author);
            image = itemView.findViewById(R.id.image);
            time = itemView.findViewById(R.id.tvPostTime);
            description = itemView.findViewById(R.id.tvDescription);
            btnLike = itemView.findViewById(R.id.btnLike);
            btnComment = itemView.findViewById(R.id.btnComment);
            btnRepost = itemView.findViewById(R.id.btnRepost);
            views = itemView.findViewById(R.id.views);
        }
    }
    public int getItemViewType(int position) {
        return position;
    }

    interface ItemClickListener {
        void itemClick(int position, Posts item);}

    public interface FragmentButtonListener{
        void myClick(Posts posts, int option);}

    public interface FragmentLikeListener{
     void removeItemLike(Posts posts);}

    public void removeLike(Posts posts) {
        int p = Posts.postsList.indexOf(posts);
        posts.setLiked(false);
//        posts.setLike(R.drawable.ic_favorite_border_black_24dp);
        Posts.postsList.set(p, posts);
        postsList.set(p, posts);
        this.notifyItemChanged(p); }

}
