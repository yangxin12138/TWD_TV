package com.twd.myapplication.activity.setting;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.twd.myapplication.R;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;


public class AboutMachine extends Activity {

    private final static String TAG = "About";

    private TextView deviceName;    //设备名称
    private TextView version;   //版本号
    private TextView securityPatch;     //安全补丁
    private TextView kernel;    //内核版本
    private TextView runtime;   //运行时间

    private Context context;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        init();
    }

    private void init(){
        deviceName = (TextView) findViewById(R.id.device_name_content);
        deviceName.setText(getDeviceName());
        version = (TextView) findViewById(R.id.version_content);
        version.setText(getVersion());
        securityPatch = (TextView) findViewById(R.id.security_patch_content);
        securityPatch.setText(getSecurityPatch());
        kernel = (TextView) findViewById(R.id.kernel_content);
        kernel.setText(getKernel());
        runtime = (TextView) findViewById(R.id.runtime_content);
        runtime.setText(getBootTime());
    }
    private String getDeviceName(){
        String name = Settings.Global.getString(getContentResolver(),Settings.Global.DEVICE_NAME);
        Log.i(TAG,"======device==="+name);
        return name;
    }

    private String getVersion(){
        String version =Build.VERSION.RELEASE;
        Log.i(TAG,"======version==="+version);
        return version;
    }

    private String getSecurityPatch(){
        String patch = Build.VERSION.SECURITY_PATCH;
        Log.i(TAG,"=======patch====="+patch);
        return patch;
    }

    private String getKernel() {
        String kernel = System.getProperty("os.version");
        Log.i(TAG,"======kernel======"+kernel);
        return kernel;
    }

    private String getBootTime(){
        Long time = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        Log.i(TAG,"========bootTime======"+format.format(date));
        return format.format(date);
    }
}
