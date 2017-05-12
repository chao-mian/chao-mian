package com.example.administrator.myfirstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton star=null;
    ImageButton rule=null;
    ImageButton more=null;
    ImageButton exit=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//不是继承activity所以无效
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        star=(ImageButton)findViewById(R.id.title1);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        rule=(ImageButton)findViewById(R.id.rule);
        rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
        //更多游戏
        more=(ImageButton)findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {
            private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder) {
                return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //show.setText("OK!");
                        //调用浏览器打开更多游戏的下载网站
                        Intent bs = new Intent();
                        bs.setAction("android.intent.action.VIEW");
                        Uri u = Uri.parse("http://game.91.com/");
                        bs.setData(u);
                        startActivity(bs);
                    }
                });
            }
            private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder) {
                return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //show.setText("NO!");//测试代码
                        //NO按钮返回游戏主界面
                    }
                });
            }
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this).setTitle("更多游戏：").setMessage("是否跳转至浏览器查看更多？");
                setPositiveButton(build);
                setNegativeButton(build).create().show();
            }
        });

        /***    没有确定框，直接打开浏览器   ***/
        /*more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用默认浏览器打开更多游戏的URL
                Intent bs = new Intent();
                bs.setAction("android.intent.action.VIEW");
                Uri u = Uri.parse("http://wap.97973.com/");
                bs.setData(u);
                startActivity(bs);
            }
        });*/
        //退出游戏
        exit=(ImageButton)findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
