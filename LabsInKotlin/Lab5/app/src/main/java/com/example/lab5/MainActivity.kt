package com.example.lab5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*


class MainActivity : AppCompatActivity(), PostsListAdapter.FragmentButtonListener,
    LikedListAdapter.FragmentLikeListener {
    var fragment1: Fragment = MainFragment()
    var fragment2: Fragment = LikeFragment()
    private lateinit var pager: ViewPager
    private lateinit var pagerAdapter:PagerAdapter
    var list: MutableList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.add(fragment1)
        list.add(fragment2)
        pager = findViewById(R.id.pager)
        pagerAdapter = Pager(supportFragmentManager, list)
        pager.adapter = pagerAdapter
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bn)
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationListener)
    }
    private val navigationListener =
            BottomNavigationView.OnNavigationItemSelectedListener {  item ->
                when (item.itemId) {
                    R.id.main -> {
                        pager.setCurrentItem(0, false)
                        supportActionBar!!.title = "Новости"
                        return@OnNavigationItemSelectedListener true

                    }
                    R.id.favs -> {
                        pager.setCurrentItem(1, false)
                        supportActionBar!!.title = "Закладки"
                        return@OnNavigationItemSelectedListener true
                    }
                }
                return@OnNavigationItemSelectedListener false

            }
    override fun removeItemLike(posts: Posts?) {
        (fragment1 as MainFragment).removeLike(posts)
        (fragment2 as LikeFragment).removeLike(posts)
    }


    override fun myClick(posts: Posts?, option: Int) {
        val fragment = supportFragmentManager.findFragmentById(R.id.pager)
        if(option == 1) posts?.let { (fragment as LikeFragment?)?.savePosts(it) }
        else (fragment as LikeFragment?)?.removePosts(Posts)
    }


}



