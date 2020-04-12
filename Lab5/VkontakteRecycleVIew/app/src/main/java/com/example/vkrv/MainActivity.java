package com.example.vkrv;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PostsListAdapter.FragmentButtonListener,
PostsListAdapter.FragmentLikeListener, LikedListAdapter.FragmentLikeListener{
    private LockableViewPager lockableViewPager;
    private PagerAdapter pagerAdapter;
    Fragment fragment1 = new MainFragment();
    Fragment fragment2 = new LikeFragment();
    List<Fragment> list = new ArrayList<>();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bn);
        list.add(fragment1);
        list.add(fragment2);
        lockableViewPager = findViewById(R.id.lvp);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), list);
        lockableViewPager.setAdapter(pagerAdapter);
        lockableViewPager.setSwipable(false);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.main:
                                lockableViewPager.setCurrentItem(0, false);
                                getSupportActionBar().setTitle("Новости");

                                break;
                            case R.id.favs:
                                lockableViewPager.setCurrentItem(1, false);
                                getSupportActionBar().setTitle("Понравившиеся");

                                break;

                        }
                        return false;
                    }
                }
        );
    }

    @Override
    public void myClick(Posts posts, int option) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.lvp);
        if (option ==1)
            ((LikeFragment)fragment).savePosts(posts);
        else
            ((LikeFragment)fragment).removePosts(posts);
    }

    @Override
    public void removeItemLike(Posts posts) {
        ((MainFragment)fragment1).removeLike(posts);
        ((LikeFragment)fragment2).removeLike(posts);

    }
}





