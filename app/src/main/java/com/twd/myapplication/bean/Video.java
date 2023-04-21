package com.twd.myapplication.bean;

import android.net.Uri;

public class Video {
    private String videoName;

    private String uri;
    public String getVideoName(){
        return videoName;
    }

    public String getUri() {
        return uri;
    }
    public Video(String videoName,String uri) {
        this.videoName = videoName;
        this.uri = uri;
    }
}
