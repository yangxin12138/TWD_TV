package com.twd.myapplication.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.twd.myapplication.R;
import com.twd.myapplication.activity.setting.SettingFragment;
import com.twd.myapplication.adpter.MainActivityAdapter;
import com.twd.myapplication.views.MyViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private MyViewPager mViewPager;
    private RadioButton localService;
    private RadioButton setting;

    private List<Fragment> fragments = new ArrayList<>();
    private View mViews[];
    private int mCurrentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
        initFragment();
    }

    private void initView() {
        //初始化自定义页面
        mViewPager = (MyViewPager) this.findViewById(R.id.main_viewpager);
        //绑定本地服务页面布局
        localService = (RadioButton) findViewById(R.id.main_title_local);
        //绑定设置页面布局
        setting = (RadioButton) findViewById(R.id.main_title_setting);
        //设置默认选中本地服务按钮
        localService.setSelected(true);
        //创建视图对象并将三个栏目添加进去
        mViews = new View[]{localService, setting};
    }

    private void setListener() {    //设置监听器
        localService.setOnClickListener(this);
        setting.setOnClickListener(this);

        //焦点在按钮上切换时切换当前显示的页面
        localService.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    mViewPager.setCurrentItem(0);
                }
            }
        });
        setting.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    mViewPager.setCurrentItem(1);
                }
            }
        });
    }

    // 初始化Fragment
    private void initFragment() {
        fragments.clear();//清空

        LocalServiceFragment interactTV = new LocalServiceFragment();
        SettingFragment setting = new SettingFragment();

        fragments.add(interactTV);
        fragments.add(setting);

        MainActivityAdapter mAdapter = new MainActivityAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                mViewPager.setCurrentItem(position);
                switch (position) {
                    case 0:
                        localService.setSelected(true);
                        MainActivity.this.setting.setSelected(false);

                        break;
                    case 1:
                        localService.setSelected(false);
                        MainActivity.this.setting.setSelected(true);
                        break;
                    case 2:
                        localService.setSelected(false);
                        MainActivity.this.setting.setSelected(false);
                        break;
                }
            }
        });
        mViewPager.setCurrentItem(0);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_title_local:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.main_title_setting:
                mViewPager.setCurrentItem(1);
                break;
        }
    }

    /**
     * 顶部焦点获取
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean focusFlag = false;
        for (View v : mViews) {
            if (v.isFocused()) {
                focusFlag = true;
            }
        }
        if (focusFlag) {
            if (KeyEvent.KEYCODE_DPAD_LEFT == keyCode) {
                if (mCurrentIndex > 0) {
                    mViews[--mCurrentIndex].requestFocus();
                }
                return true;
            } else if (KeyEvent.KEYCODE_DPAD_RIGHT == keyCode) {
                if (mCurrentIndex < 2) {
                    mViews[++mCurrentIndex].requestFocus();
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}