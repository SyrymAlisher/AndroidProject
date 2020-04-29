package com.example.vkrv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class LikedListAdapter extends RecyclerView.Adapter<LikedListAdapter.PostsViewHolder> {
    private List<Posts> postsList;
    private @Nullable ItemClickListener listener;
    private @Nullable FragmentLikeListener fragmentLikeListener;

    public LikedListAdapter(List<Posts> postsList,
                            @Nullable ItemClickListener listener,
                            @Nullable FragmentLikeListener fragmentLikeListener) {
        this.postsList = postsList;
        this.listener = listener;
        this.fragmentLikeListener = fragmentLikeListener;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext())
                .inflate(
                        R.layout.item_posts,
                        null,
                        false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        return new PostsViewHolder(view);

        }

    @Override
    public void onBindViewHolder(@NonNull final PostsViewHolder holder, final int position) {
        final Posts posts = postsList.get(getItemViewType(position));
        Glide.with(holder.image.getContext()).load(posts.getImage()).into(holder.image);
        Glide.with(holder.logo.getContext()).load(posts.getLogo()).into(holder.logo);
        holder.author.setText(posts.getAuthor());
        holder.time.setText(posts.getTime());
        holder.description.setText(String.valueOf(posts.getDescription()));
//        holder.btnLike.setText(posts.getLike()+"");
        holder.btnLike.setText(String.valueOf(Integer.valueOf(posts.getLike())+1));
        holder.views.setText(String.valueOf(posts.getViews()));
        holder.btnComment.setText(String.valueOf(posts.getComment()));
        holder.btnRepost.setText(String.valueOf(posts.getRepost()));
        holder.btnLike.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_favorite_black_24dp, 0, 0, 0);
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fragmentLikeListener != null)
                    fragmentLikeListener.removeItemLike(posts);
            }
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
        return postsList.size();
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
    interface ItemClickListener {
        void itemClick(int position, Posts item);
    }
    public int getItemViewType(int position)
    {
        return position;
    }

    public interface FragmentLikeListener {
        void removeItemLike(Posts posts);
    }
}
