package com.twd.myapplication.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class MyViewPager extends ViewPager {

    private static final String TAG = "MyViewPager";

    private boolean d = true;
    public MyViewPager( Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        super.setOnFocusChangeListener(l);
        if (d) {
            Log.i(TAG, "============focused change ========");
        }
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        if (d) {
            Log.i(TAG, "============on touch dispach ========");
        }
    }
}
