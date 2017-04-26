package com.zhuimeng.memorycompute;

import android.app.ActivityManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        compute();
    }

    private void findView() {
        info = (TextView) findViewById(R.id.tv_info);
    }

    private void compute() {
        StringBuilder stringBuilder = new StringBuilder();

        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        int memClass = activityManager.getMemoryClass();//以M为单位
        int largeMemClass = activityManager.getLargeMemoryClass();//以M为单位
        stringBuilder.append("memClass:" + memClass + "\n");
        stringBuilder.append("largeMemClass:" + largeMemClass + "\n");
//        info.setText(memClass +"          "  + largeMemClass);
        info.setText(stringBuilder.toString());
        Log.e("zhuimeng", stringBuilder.toString());
    }
}
