package com.andy.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;



public class xmlDesign extends Activity {
	/** Called when the activity is first created. */
	RadioButton r1 = null;
	RadioButton r2 = null;
	RadioButton r3 = null;
	RadioButton r4 = null;
	RadioGroup radioGroup = null;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// ��õ�ѡ��ť��
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		 
		// ��õ�ѡ��ť
		r1 = (RadioButton) findViewById(R.id.a);
		r2 = (RadioButton) findViewById(R.id.b);
		r3 = (RadioButton) findViewById(R.id.c);
		r4 = (RadioButton) findViewById(R.id.d);
		r1.setClickable(true);
		// ������ѡ��ť
		//radioGroup.setOnCheckedChangeListener(mChangeRadio);
        Button  btn1_sure =(Button)findViewById(R.id.sure);
        Button  btn2_cancel =(Button)findViewById(R.id.cancel);
        btn1_sure .setOnClickListener(new  btn1_sure ());//ΪButton���ü����¼�
        btn2_cancel.setOnClickListener(new  btn2_cancel());
	}

  class btn1_sure implements OnClickListener{ //��ť�¼��������࣬ʵ��OnClickListener�ӿ�

		@Override
		public void onClick(View v) {//ʵ��OnClickListener�ӿ��е�onClick����
			
            String ans ="";
			if(r1.isChecked()){
				ans = "on";
			}
			else if (r2.isChecked()) {
				
				ans = "at";
			}
             else if (r3.isChecked()) {
				
				ans = "of";
			}
             else if (r4.isChecked()) {
 				
 				ans = "in";
 			}
			/* new һ��Intent ���󣬲�ָ��class */
			Intent intent = new Intent();
			//����Intent����Ҫ������Activity
			intent.setClass(xmlDesign.this, otherActivity.class);
			/* new һ��Bundle���󣬲���Ҫ���ݵ����ݴ��� */
			Bundle bundle = new Bundle();
			bundle.putString("ans", ans);
			/* ��Bundle ����assign ��Intent */
			intent.putExtras(bundle);
			
			//ͨ��Intent������������һ��Activity
			xmlDesign.this.startActivity(intent);
		}
    	
    }
    class  btn2_cancel implements OnClickListener{
/*
(API�в��ң�android.widget public class RadioGroup 
void clearCheck() 
Clears the selection. 

 */
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			radioGroup.clearCheck() ;
			setTitle("");
		}
    
    }

	

protected void onActivityResult(int requestCode, int resultCode,
Intent data) {
// TODO Auto-generated method stub
super.onActivityResult(requestCode, resultCode, data);
switch (resultCode) {
case RESULT_OK:
/* ȡ������Activity2 �����ݣ�����ʾ�ڻ����� */
Bundle bunde = data.getExtras();
String ans = bunde.getString("ans");

break;
default:
break;
}
}
}