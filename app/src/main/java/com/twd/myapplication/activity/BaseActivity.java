package com.twd.myapplication.activity;

import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

public class BaseActivity extends FragmentActivity {

    protected void showLongToast(String pMsg) {
        Toast.makeText(this, pMsg, Toast.LENGTH_LONG).show();
    }

    protected void showShortToast(String pMsg) {
        Toast.makeText(this, pMsg, Toast.LENGTH_SHORT).show();
    }
}
