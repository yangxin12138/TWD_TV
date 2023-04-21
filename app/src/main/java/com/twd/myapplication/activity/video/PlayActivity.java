package com.twd.myapplication.activity.video;

import static android.content.ContentValues.TAG;
import static com.google.android.exoplayer2.upstream.RawResourceDataSource.RAW_RESOURCE_SCHEME;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.twd.myapplication.R;

import java.io.IOException;

public class PlayActivity extends AppCompatActivity {
    private static final String TAG = "PlayActivity";
    private  PlayerView playerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initView();
    }

    private void initView() {
        playerView = findViewById(R.id.video_view);
        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(this);
        Log.i("PlayActivity","===传过来的文件是："+getIntent().getStringExtra("uri"));

        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory (this, Util.getUserAgent(this,String.valueOf(getApplication())));
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        MediaSource videoSource = new ExtractorMediaSource(Uri.parse(getIntent().getStringExtra("uri")),
                dataSourceFactory, extractorsFactory, null, null);

        Log.i(TAG,"===z正确的uri==="+Uri.parse(RAW_RESOURCE_SCHEME +":///" + R.raw.sp1).toString());
        playerView.setPlayer(player);
        player.prepare(videoSource);
        player.setPlayWhenReady(true);

    }


}
