package com.example.administrator.myfirstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Calendar;


/**
 * Created by Administrator on 2017/4/27.
 */

public class SecondActivity extends Activity{
    static int money;
    static int arr1=0;
    static int myleagth=2;
    static int youleagth=2;
    EditText txt;
    EditText txt2;
    Chronometer timer;
    SQLiteDatabase db;

    ImageButton remind=null;
    ImageButton sure=null;
    @Override
    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondxml);
        //计时器
        timer = (Chronometer) findViewById(R.id.timer);
        timer.setBase(SystemClock.elapsedRealtime());//计时器清零
        timer.start();
        //查找根目录下的数据库文件
        db=SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/my_s1.db3",null);
        checkSql();
        Cursor cs = db.rawQuery("select new_money from new_money where _id=1",null);
        int mon = cs.getColumnIndex("new_money");
        cs.moveToFirst();
        //String title=cs.getString(mon);
        money=cs.getInt(mon);
        txt2=(EditText)findViewById(R.id.txt2);
        txt2.setText(money+"");
        ImageButton arrive=(ImageButton)findViewById(R.id.arrive);

        ImageButton back1=(ImageButton)findViewById(R.id.back1);
        ImageButton remind=(ImageButton)findViewById(R.id.remind);
        sure=(ImageButton)findViewById(R.id.sure);
        //点击事件绑定一个事件监听器
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从数据库中查找到符合语句的数据
 try {
     //取出数据库的答案进行比较
     Cursor cursor = db.rawQuery("select * from news_inf where _id = " + (myleagth - 1), null);
     int our = cursor.getColumnIndex("news_content");
     cursor.moveToFirst();
     String title = cursor.getString(our);
     //取出编辑框的id
     EditText enter = (EditText) findViewById(R.id.enter);
     String enter1 = enter.getText().toString() + "";
     System.out.println("我是title：" + title + "我是enter1：" + enter1);
     if (enter1.equals(title) == true) {
         AlertDialog.Builder dialog = new AlertDialog.Builder(SecondActivity.this);
         dialog.setTitle("回答正确！！");
         dialog.setMessage("金币加10，请继续努力哦！");
         dialog.setPositiveButton("下一题", null);
         dialog.create().show();
         checkSql();
         enter.setText("");
         money+=10;
         txt2.setText(adda()+"");
     } else {
         //弹出一个提示框
         AlertDialog.Builder dialog = new AlertDialog.Builder(SecondActivity.this);
         dialog.setTitle("错误！！");
         dialog.setMessage("您的答案有误，请继续努力哦！");
         dialog.setPositiveButton("确定", null);
         dialog.create().show();
     }
 }
 catch(SQLException se){
     db.execSQL("create table news_inf(_id integer primary key autoincrement,news_title varchar(50)," +
             "news_content varchar(225),new_remind varchar(150),news_point varchar(20))");
     System.out.println("没有数据库！！");
 }
            }
        });

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(SecondActivity.this,MainActivity.class);
                //startActivity(intent);//如果使用这部分代码会多次打开MainActivity
                System.exit(0);
            }
        });
        /*remind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=db.rawQuery("select * from news_inf where _id = "+(youleagth-1),null);
                int our = cursor.getColumnIndex("news_remind");
                cursor.moveToFirst();
                String title=cursor.getString(our);
                AlertDialog.Builder dialog=new AlertDialog.Builder(SecondActivity.this);
                dialog.setTitle("提示：");
                dialog.setMessage(title);
                dialog.setPositiveButton("确定" ,  null );
                dialog.create().show();
            }
        });*/
        remind.setOnClickListener(new View.OnClickListener() {
            private android.support.v7.app.AlertDialog.Builder setPositiveButton(android.support.v7.app.AlertDialog.Builder builder) {
                return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //show.setText("OK!");
                        //调用浏览器打开更多游戏的下载网站
                        money-=5;
                        txt2.setText(adda()+"");
                        Cursor cursor=db.rawQuery("select * from news_inf where _id = "+(youleagth-1),null);
                        int our = cursor.getColumnIndex("news_remind");
                        cursor.moveToFirst();
                        String title=cursor.getString(our);
                        AlertDialog.Builder dia=new AlertDialog.Builder(SecondActivity.this);
                        dia.setTitle("提示：");
                        dia.setMessage(title);
                        dia.setPositiveButton("确定" ,  null );
                        dia.create().show();

                    }
                });
            }
            private android.support.v7.app.AlertDialog.Builder setNegativeButton(android.support.v7.app.AlertDialog.Builder builder) {
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
                android.support.v7.app.AlertDialog.Builder build = new android.support.v7.app.AlertDialog.Builder(SecondActivity.this).setTitle("温馨提示：").setMessage("是否花费5个金币查看提示？");
                setPositiveButton(build);
                setNegativeButton(build).create().show();
            }
        });
        arrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                //int mYear = c.get(Calendar.YEAR); // 获取当前年份
                int mMonth = c.get(Calendar.MONTH) + 1;// 获取当前月份
                int mDay = c.get(Calendar.DAY_OF_MONTH);// 获取当日期
                int Dat=mMonth+mDay;
                Cursor csr = db.rawQuery("select date from new_date where _id=1",null);
                int mon = csr.getColumnIndex("date");
                csr.moveToFirst();
                //String title=cs.getString(mon);
                int title=csr.getInt(mon);
                //System.out.println("月："+mMonth+"日："+mDay);
                System.out.println("date_sum:"+title);
                if(title!=Dat){
                    //弹出一个提示框
                    AlertDialog.Builder dialog = new AlertDialog.Builder(SecondActivity.this);
                    dialog.setTitle("签到信息");
                    dialog.setMessage("恭喜您签到成功，金币加10");
                    dialog.setPositiveButton("是", null);
                    dialog.create().show();
                    arr1++;
                    money+=10;
                    txt2.setText(adda()+"");
                    ContentValues values=new ContentValues();
                    values.put("date",Dat);
                    db.update("new_date",values,"_id=1",null);
                    // db.execSQL("update new_money set money=100 where _id=1");
                    //Cursor cs = db.rawQuery("select data from new_money where _id=1",null);
                }
               /* if(arr1==0){
                    //弹出一个提示框
                    AlertDialog.Builder dialog = new AlertDialog.Builder(SecondActivity.this);
                    dialog.setTitle("签到信息");
                    dialog.setMessage("恭喜您签到成功，金币加10");
                    dialog.setPositiveButton("是", null);
                    dialog.create().show();
                    arr1++;
                    money+=10;
                    /*ContentValues values=new ContentValues();
                    values.put("new_money",money);
                   db.update("new_money",values,"_id=1",null);
                   // db.execSQL("update new_money set money=100 where _id=1");
                    Cursor cs = db.rawQuery("select new_money from new_money where _id=1",null);
                    int mon = cs.getColumnIndex("new_money");
                    cs.moveToFirst();
                    //String title=cs.getString(mon);
                    int title=cs.getInt(mon);
                    //System.out.println("我是："+title+"\n");
                    txt2.setText(title+"");*/
                /*    txt2.setText(adda()+"");

                   /* ContentValues values=new ContentValues();
                    values.put("new_date",Date);
                    db.update("new_date",values,"_id=1",null);
                    // db.execSQL("update new_money set money=100 where _id=1");
                    Cursor csr1 = db.rawQuery("select date from new_date where _id=1",null);
                    int mon1 = csr.getColumnIndex("data");
                    csr.moveToFirst();
                    //String title=cs.getString(mon);
                    int title1=csr.getInt(mon1);
                    System.out.println("date_sum:"+title1);
                }*/
               else{
                    //弹出一个提示框
                    AlertDialog.Builder dialog = new AlertDialog.Builder(SecondActivity.this);
                    dialog.setTitle("温馨提示");
                    dialog.setMessage("您今天已经签到过了，请明天再来吧！");
                    dialog.setPositiveButton("是", null);
                    dialog.create().show();
                }
            }
        });
    }
    private int adda(){
        ContentValues values=new ContentValues();
        values.put("new_money",money);
        db.update("new_money",values,"_id=1",null);
        // db.execSQL("update new_money set money=100 where _id=1");
        Cursor cs = db.rawQuery("select new_money from new_money where _id=1",null);
        int mon = cs.getColumnIndex("new_money");
        cs.moveToFirst();
        //String title=cs.getString(mon);
        int title=cs.getInt(mon);
        return title;
        //System.out.println("我是："+title+"\n");
    }

    private int checkSql(){
        txt=(EditText)findViewById(R.id.txt1);
        txt.setText("第"+(myleagth-1)+"题");
        Cursor cursor=db.rawQuery("select * from news_inf where _id = "+myleagth,null);
        int your=cursor.getColumnIndex("news_point");
        int our = cursor.getColumnIndex("news_title");
        cursor.moveToFirst();
        String point1= cursor.getString(your);
        String title=cursor.getString(our);
        EditText riddle=(EditText)findViewById(R.id.riddle);
        EditText point=(EditText)findViewById(R.id.point);
        riddle.setText(title);
        point.setText(point1);
        ++myleagth;
        ++youleagth;
        return youleagth;
    }
    private void insertData(SQLiteDatabase db,String title,String content,String remind,String point){
        db.execSQL("insert into news_inf values(null,?,?,?,?)",new String[]{title,content,remind,point});
    }
}
