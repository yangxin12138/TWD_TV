package com.twd.myapplication.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.twd.myapplication.R;
import com.twd.myapplication.activity.WoDouGameBaseFragment;
import com.twd.myapplication.activity.app.AppAutoRun;
import com.twd.myapplication.activity.app.AppUninstall;
import com.twd.myapplication.activity.eliminateprocess.EliminateMainActivity;
import com.twd.myapplication.activity.garbageclear.GarbageClear;
import com.twd.myapplication.activity.speedtest.SpeedTestActivity;

public class SettingFragment extends WoDouGameBaseFragment implements View.OnClickListener{

    private ImageButton Setting_Clean;// 垃圾清理
    private ImageButton Setting_Accelerate;// 一键加速
    private ImageButton appUninstall;   //应用卸载
    private ImageButton setNet; //网络设置
    private ImageButton setMore;    //更多设置
    private ImageButton netSpeed;   //网络测速
    private ImageButton sysUpdate;  //系统更新
    private ImageButton fileManage; //文件管理
    private ImageButton about;  //关于
    private ImageButton autoRun;    //自启动管理

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_setting, container, false);
        initView(view);
        setListener();
        return view;
    }

    private void initView(View view) {
        appUninstall = (ImageButton) view.findViewById(R.id.setting_uninstall);
        setNet = (ImageButton) view.findViewById(R.id.setting_net);
        setMore = (ImageButton) view.findViewById(R.id.setting_more);
        netSpeed = (ImageButton) view.findViewById(R.id.setting_net_speed);
        sysUpdate = (ImageButton) view.findViewById(R.id.setting_update);
        fileManage = (ImageButton) view.findViewById(R.id.setting_file);
        about = (ImageButton) view.findViewById(R.id.setting_about);
        Setting_Clean = (ImageButton) view.findViewById(R.id.setting_clean);
        Setting_Accelerate = (ImageButton) view.findViewById(R.id.setting_accelerate);
        autoRun = (ImageButton) view.findViewById(R.id.setting_autorun);

        appUninstall.setOnFocusChangeListener(mFocusChangeListener);
        setNet.setOnFocusChangeListener(mFocusChangeListener);
        setMore.setOnFocusChangeListener(mFocusChangeListener);
        netSpeed.setOnFocusChangeListener(mFocusChangeListener);
        sysUpdate.setOnFocusChangeListener(mFocusChangeListener);
        fileManage.setOnFocusChangeListener(mFocusChangeListener);
        about.setOnFocusChangeListener(mFocusChangeListener);
        Setting_Clean.setOnFocusChangeListener(mFocusChangeListener);
        Setting_Accelerate.setOnFocusChangeListener(mFocusChangeListener);
        autoRun.setOnFocusChangeListener(mFocusChangeListener);

    }

    private void setListener() {
        Setting_Clean.setOnClickListener(this);
        Setting_Accelerate.setOnClickListener(this);
        about.setOnClickListener(this);
        setMore.setOnClickListener(this);
        appUninstall.setOnClickListener(this);
        setNet.setOnClickListener(this);
        fileManage.setOnClickListener(this);
        netSpeed.setOnClickListener(this);
        sysUpdate.setOnClickListener(this);
        autoRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent jumpIntent;
        switch (view.getId()) {
            case R.id.setting_clean:
                //跳转到垃圾清理功能
                jumpIntent = new Intent(context, GarbageClear.class);
                startActivity(jumpIntent);
                break;
            case R.id.setting_accelerate:
                //跳转到一键清理功能
                jumpIntent = new Intent(context, EliminateMainActivity.class);
                startActivity(jumpIntent);
                break;
            case R.id.setting_about:
                jumpIntent = new Intent(context,AboutMachine.class);
                startActivity(jumpIntent);
                break;
            case R.id.setting_more:
                //跳转到更多设置
                jumpIntent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(jumpIntent);
                break;
            case R.id.setting_file:
                showShortToast("File");
                break;
            case R.id.setting_update:
                showShortToast("Update");
                break;
            case R.id.setting_net:
                //跳转到网络设置
                jumpIntent = new Intent(context, SettingCustom.class);
                startActivity(jumpIntent);
                break;
            case R.id.setting_uninstall:
                //跳转到应用卸载
                jumpIntent = new Intent(context, AppUninstall.class);
                startActivity(jumpIntent);
                break;
            case R.id.setting_autorun:
                //跳转到自启动管理
                jumpIntent = new Intent(context, AppAutoRun.class);
                startActivity(jumpIntent);
                break;
            case R.id.setting_net_speed:
                //跳转到网速测试
                jumpIntent = new Intent(context, SpeedTestActivity.class);
                startActivity(jumpIntent);
                break;
        }
    }
}
