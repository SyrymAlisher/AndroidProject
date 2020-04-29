package com.example.vkwithkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import java.lang.String

class PostsListAdapter

 : RecyclerView.Adapter<PostsListAdapter.PostsViewHolder> {
    private var postsList: List<Posts>
    private var listener: ItemClickListener? = null

    constructor(postsList: List<Posts>, listener: ItemClickListener?){
        this.postsList = postsList
        this.listener = listener
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostsViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_posts, null, false)
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
        val posts = postsList[position]

        Glide.with(holder.image.context).load(posts.image).into(holder.image)
        Glide.with(holder.logo.context).load(posts.logo).into(holder.logo)
        holder.author.text = posts.author
        holder.time.text = posts.time
        holder.description.text = posts.description
        holder.btnLike.text = posts.like.toString()
        holder.btnComment.text = posts.comment.toString()
        holder.btnRepost.text = posts.repost.toString()
        holder.views.text = posts.views.toString()
        holder.btnLike.setOnClickListener { v ->
            Toast.makeText(v.context, "Like", Toast.LENGTH_SHORT).show()
            }


        holder.itemView.setOnClickListener { listener?.itemClick(position, posts) }
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    class PostsViewHolder(itemView: View) : ViewHolder(itemView) {
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

}
