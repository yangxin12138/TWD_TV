package com.twd.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.twd.myapplication.R;
import com.twd.myapplication.activity.video.MyVideo;


public class LocalServiceFragment extends WoDouGameBaseFragment implements View.OnClickListener{

    //旅游
    ImageButton tour;
    //电视
    ImageButton tv;
    //美食
    ImageButton cate;
    //天气
    ImageButton weather;
    //资讯
    ImageButton news;
    //应用商店
    ImageButton appStore;
    //本地视频
    ImageButton video;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_local_service, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tv = (ImageButton) view.findViewById(R.id.local_tv);
        tour = (ImageButton) view.findViewById(R.id.local_tour);
        cate = (ImageButton) view.findViewById(R.id.local_cate);
        weather = (ImageButton) view.findViewById(R.id.local_weather);
        news = (ImageButton) view.findViewById(R.id.local_news);
        appStore = (ImageButton) view.findViewById(R.id.local_app_store);
        video = (ImageButton) view.findViewById(R.id.local_video);

        tv.setOnFocusChangeListener(mFocusChangeListener);
        tour.setOnFocusChangeListener(mFocusChangeListener);
        cate.setOnFocusChangeListener(mFocusChangeListener);
        weather.setOnFocusChangeListener(mFocusChangeListener);
        news.setOnFocusChangeListener(mFocusChangeListener);
        appStore.setOnFocusChangeListener(mFocusChangeListener);
        video.setOnFocusChangeListener(mFocusChangeListener);

        tv.setOnClickListener(this);
        video.setOnClickListener(this);
        tour.setOnClickListener(this);
        cate.setOnClickListener(this);
        weather.setOnClickListener(this);
        news.setOnClickListener(this);
        appStore.setOnClickListener(this);


        tv.setFocusable(true);
        tv.setFocusableInTouchMode(true);
        tv.requestFocus();
        tv.requestFocusFromTouch();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.local_tv:
                Toast.makeText(getActivity(), "进入TV", Toast.LENGTH_SHORT).show();
                break;
            case R.id.local_weather:
                Toast.makeText(getActivity(), "进入天气", Toast.LENGTH_SHORT).show();
                break;
            case R.id.local_app_store:
                Toast.makeText(getActivity(), "进入商店", Toast.LENGTH_SHORT).show();
                break;
            case R.id.local_cate:
                Toast.makeText(getActivity(), "进入美食", Toast.LENGTH_SHORT).show();
                break;
            case R.id.local_news:
                Toast.makeText(getActivity(), "进入新闻", Toast.LENGTH_SHORT).show();
                break;
            case R.id.local_tour:
                Toast.makeText(getActivity(), "进入旅游", Toast.LENGTH_SHORT).show();
                break;
            case R.id.local_video:
                Toast.makeText(getActivity(), "进入本地", Toast.LENGTH_SHORT).show();
                intent.setClass(getContext(),MyVideo.class);
                startActivity(intent);
                break;
        }
    }
}
