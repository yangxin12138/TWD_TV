package com.twd.myapplication.activity.video;

import static com.google.android.exoplayer2.upstream.RawResourceDataSource.RAW_RESOURCE_SCHEME;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.twd.myapplication.R;
import com.twd.myapplication.adpter.VideoAdapter;
import com.twd.myapplication.bean.Video;

import java.util.ArrayList;
import java.util.List;

public class MyVideo extends AppCompatActivity {
    private static final String TAG = "MyVideo";
    //定义对象
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
        initData();
    }
    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);
    }

    private void initData() {
        List<Video> videolist=new ArrayList<>();

        Video firstvideo = new Video("xiaohaizi01",Uri.parse(RAW_RESOURCE_SCHEME +":///" + R.raw.sp1).toString());
        videolist.add(firstvideo);
        Video secondvideo = new Video("yisuerde",Uri.parse(RAW_RESOURCE_SCHEME +":///" + R.raw.sp2).toString());
        videolist.add(secondvideo);
        Video thirdvideo = new Video("tianye",Uri.parse(RAW_RESOURCE_SCHEME +":///" + R.raw.sp3).toString());
        videolist.add(thirdvideo);
        Video fourthvideo = new Video("youxi",Uri.parse(RAW_RESOURCE_SCHEME +":///" + R.raw.sp4).toString());
        videolist.add(fourthvideo);
        Video fifthvideo = new Video("jiedao",Uri.parse(RAW_RESOURCE_SCHEME +":///" + R.raw.sp5).toString());
        videolist.add(fifthvideo);
        VideoAdapter adapter = new VideoAdapter(videolist);

        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
