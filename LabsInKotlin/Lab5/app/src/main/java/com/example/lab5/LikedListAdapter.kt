package com.example.lab5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.lang.String


class LikedListAdapter(
    private val postsList: List<Posts>,
    private val listener: ItemClickListener?,
    private val fragmentLikeListener: FragmentLikeListener?
) :
    RecyclerView.Adapter<LikedListAdapter.PostsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostsViewHolder {
        val view = LayoutInflater.from(
            parent.context
        )
            .inflate(
                R.layout.item_posts,
                null,
                false
            )
        val params = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.layoutParams = params
        return PostsViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PostsViewHolder,
        position: Int
    ) {
        val posts = postsList[getItemViewType(position)]
        Glide.with(holder.image.context).load(posts.getImage()).into(holder.image)
        Glide.with(holder.logo.context).load(posts.getLogo()).into(holder.logo)
        holder.author.setText(posts.getAuthor())
        holder.time.setText(posts.getTime())
        holder.description.setText(String.valueOf(posts.getDescription()))
        //        holder.btnLike.setText(posts.getLike()+"");
        holder.btnLike.setText((Integer.valueOf(posts.getLike()) + 1).toString())
        holder.views.setText(String.valueOf(posts.getViews()))
        holder.btnComment.setText(String.valueOf(posts.getComment()))
        holder.btnRepost.setText(String.valueOf(posts.getRepost()))
        holder.btnLike.setCompoundDrawablesWithIntrinsicBounds(
            R.drawable.ic_favorite_black_24dp,
            0,
            0,
            0
        )
        holder.btnLike.setOnClickListener { fragmentLikeListener?.removeItemLike(posts) }
        holder.itemView.setOnClickListener { listener?.itemClick(position, posts) }
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    inner class PostsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var logo: ImageView
        var author: TextView
        var image: ImageView
        var time: TextView
        var description: TextView
        var btnLike: Button
        var btnComment: Button
        var btnRepost: Button
        var views: TextView

        init {
            logo = itemView.findViewById(R.id.logo)
            author = itemView.findViewById(R.id.author)
            image = itemView.findViewById(R.id.image)
            time = itemView.findViewById(R.id.tvPostTime)
            description = itemView.findViewById(R.id.tvDescription)
            btnLike = itemView.findViewById(R.id.btnLike)
            btnComment = itemView.findViewById(R.id.btnComment)
            btnRepost = itemView.findViewById(R.id.btnRepost)
            views = itemView.findViewById(R.id.views)
        }
    }

    interface ItemClickListener {
        fun itemClick(position: Int, item: Posts?)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface FragmentLikeListener {
        fun removeItemLike(posts: Posts?)
    }

}
