package com.zhbitzwz.cn.jsondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private DataBean myData;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tw);
        //初始化数据
        initData();

    }

    /**
     * 初始化数据
     */
    private void initData() {
        praseJson();
    }

    /**
     * 解析json数据
     */
    private void praseJson() {
        String json = getResources().getString(R.string.myjson);
        Gson gson = new Gson();
        myData = gson.fromJson(json ,DataBean.class);
        Log.i("zhouweizhi",":" + myData.toString());
        tv.setText("Course_address=" + myData.getCourse_address() + ";"+ "Course_name=" + myData.getCourse_name());
    }
}
