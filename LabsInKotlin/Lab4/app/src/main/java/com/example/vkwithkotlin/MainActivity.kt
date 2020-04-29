package com.example.vkwithkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: PostsListAdapter? = null
    private var listener: PostsListAdapter.ItemClickListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listener = object : PostsListAdapter.ItemClickListener {
            override fun itemClick(position: Int, item: Posts?) {
                val intent = Intent(this@MainActivity, PostDetailActivity::class.java)
                intent.putExtra("posts", item)
                startActivity(intent)
            }
        }
        val layoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = layoutManager
        adapter = PostsListAdapter(postsGenerator(), listener)
        recyclerView?.adapter = adapter
    }

    private fun postsGenerator(): List<Posts> {
        val items: MutableList<Posts> = ArrayList()
        val logo = ArrayList<Int>()
        val author = ArrayList<String>()
        val image = ArrayList<Int>()
        val time = ArrayList<String>()
        val description = ArrayList<String>()
        val like = ArrayList<Int>()
        val comment = ArrayList<String>()
        val repost = ArrayList<String>()
        val views = ArrayList<Int>()

        //1---------------------------------------------------------------
        logo.add(R.drawable.ztb_logo)
        author.add("ZTB| QAZAQSTAN")
        image.add(R.drawable.img1)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post1))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)
        //2---------------------------------------------------------------
        logo.add(R.drawable.ztb_logo)
        author.add("ZTB| QAZAQSTAN")
        image.add(R.drawable.img2)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post2))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)
        //3---------------------------------------------------------------
        logo.add(R.drawable.hell_logo)
        author.add("Hell's Kitchen")
        image.add(R.drawable.img10)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post10))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)

        //4---------------------------------------------------------------
        logo.add(R.drawable.art_logo)
        author.add("Factura-блог")
        image.add(R.drawable.img4)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post4))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)
        //5--------------------------------------------------------------
        logo.add(R.drawable.ztb_logo)
        author.add("ZTB| QAZAQSTAN")
        image.add(R.drawable.img3)
        description.add(getString(R.string.post3))
        time.add("Вчера в 16:00")
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)
        //---------------------------------------------------------------
        logo.add(R.drawable.art_logo)
        author.add("Factura-блог")
        image.add(R.drawable.img5)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post5))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)
        //---------------------------------------------------------------
        logo.add(R.drawable.marvel_logo)
        author.add("Marvel/DC")
        image.add(R.drawable.img7)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post7))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)
        //---------------------------------------------------------------
        logo.add(R.drawable.goal_logo)
        author.add("Goal Europe")
        image.add(R.drawable.img9)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post9))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)
        //---------------------------------------------------------------
        logo.add(R.drawable.art_logo)
        author.add("Factura-блог")
        image.add(R.drawable.img6)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post6))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)
        //---------------------------------------------------------------
        logo.add(R.drawable.almaty_logo)
        author.add("Adruino")
        image.add(R.drawable.img8)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post8))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)
        //---------------------------------------------------------------
        for (i in logo.indices) {
            val posts = Posts(
                logo[i],
                author[i],
                image[i],
                time[i],
                description[i],
                like[i],
                comment[i],
                repost[i],
                views[i]
            )
            items.add(posts)
        }
        return items
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
        }
        super.onRestoreInstanceState(savedInstanceState)
    }
}


