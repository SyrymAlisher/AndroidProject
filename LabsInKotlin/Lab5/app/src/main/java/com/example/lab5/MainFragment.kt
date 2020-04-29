package com.example.lab5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainFragment : Fragment() {
    var recyclerView: RecyclerView? = null
    private var adapter: PostsListAdapter? = null
    private var listener: ItemClickListener? = null
    private var fragmentButtonListener: PostsListAdapter.FragmentButtonListener? = null
    private var fragmentLikeListener: FragmentLikeListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater
            .inflate(R.layout.fragment_main, container, false) as ViewGroup
        recyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(LinearLayoutManager(activity))
        listener = object : ItemClickListener() {
            fun itemClick(position: Int, item: Posts?) {
                val intent = Intent(activity, PostDetailActivity::class.java)
                intent.putExtra("posts", item)
                startActivity(intent)
            }
        }
        fragmentButtonListener = object : FragmentButtonListener() {
            fun myClick(posts: Posts?, option: Int) {
                (activity as MainActivity?)!!.myClick(posts, option)
            }
        }
        fragmentLikeListener = object : FragmentLikeListener() {
            fun removeItemLike(posts: Posts?) {
                (activity as MainActivity?)!!.removeItemLike(posts)
            }
        }
        adapter = PostsListAdapter(
            postsGenerator(),
            listener,
            fragmentButtonListener,
            fragmentLikeListener
        )
        recyclerView.setAdapter(adapter)
        return rootView
    }

    fun removeLike(posts: Posts?) {
        adapter.removeLike(posts)
    }

    fun postsGenerator(): List<Posts> {
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
        author.add("Алматы сегодня")
        image.add(R.drawable.img8)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post8))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)
        //---------------------------------------------------------------
        logo.add(R.drawable.ztb_logo)
        author.add("ZTB| QAZAQSTAN")
        image.add(R.drawable.img11)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post11))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)

        //---------------------------------------------------------------
        logo.add(R.drawable.ztb_logo)
        author.add("ZTB| QAZAQSTAN")
        image.add(R.drawable.img12)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post12))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)

        //---------------------------------------------------------------
        logo.add(R.drawable.ztb_logo)
        author.add("ZTB| QAZAQSTAN")
        image.add(R.drawable.img13)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post13))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)

        //---------------------------------------------------------------
        logo.add(R.drawable.ztb_logo)
        author.add("ZTB| QAZAQSTAN")
        image.add(R.drawable.img14)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post14))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)


        //---------------------------------------------------------------
        logo.add(R.drawable.ztb_logo)
        author.add("ZTB| QAZAQSTAN")
        image.add(R.drawable.img15)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post15))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)

        //---------------------------------------------------------------
        logo.add(R.drawable.ztb_logo)
        author.add("ZTB| QAZAQSTAN")
        image.add(R.drawable.img16)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post16))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)

        //---------------------------------------------------------------
        logo.add(R.drawable.ztb_logo)
        author.add("ZTB| QAZAQSTAN")
        image.add(R.drawable.img17)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post17))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)

        //---------------------------------------------------------------
        logo.add(R.drawable.champions_logo)
        author.add("Champions Cup")
        image.add(R.drawable.img18)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post18))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)

        //---------------------------------------------------------------
        logo.add(R.drawable.champions_logo)
        author.add("Champions Cup")
        image.add(R.drawable.img19)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post19))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)

        //---------------------------------------------------------------
        logo.add(R.drawable.hell_logo)
        author.add("Hell's Kitchen")
        image.add(R.drawable.img20)
        time.add("Вчера в 16:00")
        description.add(getString(R.string.post20))
        comment.add("45")
        like.add(123)
        repost.add("23")
        views.add(123)
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
}




