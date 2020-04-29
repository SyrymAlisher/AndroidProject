package com.example.vkrv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class LockableViewPager extends ViewPager {
    private boolean swipable;

    public LockableViewPager(Context context) {
        super(context);
    }

    public LockableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.swipable = true;
    }

    public boolean isSwipable() {
        return swipable;
    }

    public void setSwipable(boolean swipable) {
        this.swipable = swipable;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(this.swipable)
        {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(this.swipable){
            return super.onTouchEvent(ev);
        }
        return false;
    }
}
