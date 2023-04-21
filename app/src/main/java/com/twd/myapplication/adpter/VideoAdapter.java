package com.twd.myapplication.adpter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twd.myapplication.R;
import com.twd.myapplication.activity.video.PlayActivity;
import com.twd.myapplication.bean.Video;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private List<Video> videoList;

    public VideoAdapter(List<Video> videoList) {
        this.videoList = videoList;
    }
    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.videoview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Video video =videoList.get(position);
                String myvideoname=video.getVideoName();
                String myuri = video.getUri();
                Intent intent=new Intent(view.getContext(), PlayActivity.class);
                intent.putExtra("videoname",myvideoname);
                intent.putExtra("uri",myuri);
                view.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Video video = videoList.get(position);
        holder.video_name.setText(video.getVideoName());
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView video_name;
        View videoview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            video_name=itemView.findViewById(R.id.video_name);
            videoview=itemView;
        }
    }
}
