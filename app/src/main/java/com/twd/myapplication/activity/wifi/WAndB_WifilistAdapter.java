package com.twd.myapplication.activity.wifi;

import android.app.Activity;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.BaseAdapter;

import com.twd.myapplication.R;

import java.util.List;

public class WAndB_WifilistAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<ScanResult> scanResults;
    private Viewholder viewholder;
    private Activity context;
    public WAndB_WifilistAdapter(Activity context,List<ScanResult> scanResults){
        inflater=LayoutInflater.from(context);
        this.scanResults=scanResults;
        this.context=context;
    }

    @Override
    public int getCount() {
        if(scanResults.size()==0){
            return 0;
        }
        return scanResults.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            viewholder=new Viewholder();
            convertView=inflater.inflate(R.layout.wandb_wifilist_item, null);
            viewholder.WifiName=(TextView)convertView.findViewById(R.id.wannb_wifilist_item_wifiname);
            convertView.setTag(viewholder);
        }else{
            viewholder=(Viewholder)convertView.getTag();
        }
        viewholder.WifiName.setText(scanResults.get(position).SSID);
        viewholder.ArrowTop=(ImageView)context.findViewById(R.id.wifi_arrowtop);
        viewholder.ArrowBottom=(ImageView)context.findViewById(R.id.wifi_arrowbottom);
        if(position==scanResults.size()-1){
            viewholder.ArrowBottom.setVisibility(View.INVISIBLE);
        }else{
            viewholder.ArrowBottom.setVisibility(View.VISIBLE);
        }
        return convertView;
    }

    class Viewholder{
        public TextView WifiName;
        public ImageView ArrowTop;
        public ImageView ArrowBottom;
    }
}
