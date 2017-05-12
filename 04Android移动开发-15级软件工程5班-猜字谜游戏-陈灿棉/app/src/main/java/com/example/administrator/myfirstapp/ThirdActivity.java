package com.example.administrator.myfirstapp;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2017/5/1.
 */

public class ThirdActivity extends Activity{
    @Override
    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdxml);
        ImageButton rule=(ImageButton)findViewById(R.id.rule2);
        rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(ThirdActivity.this,MainActivity.class);
                //startActivity(intent);
                System.exit(0);
            }
        });
    }
}
