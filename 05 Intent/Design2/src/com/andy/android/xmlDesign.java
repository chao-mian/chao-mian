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
	RadioButton currentRadioButton=null;
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
		radioGroup.setOnCheckedChangeListener(mChangeRadio);
        Button btn1_sure =(Button)findViewById(R.id.sure);
        Button btn2_cancel =(Button)findViewById(R.id.cancel);
        btn1_sure.setOnClickListener(new btn1_sure());
        btn2_cancel.setOnClickListener(new btn2_cancel());
	}

    class btn1_sure implements OnClickListener{

		@Override
		public void onClick(View v) {

			if(currentRadioButton.getText().equals("in")){
				setTitle("��ѡ��Ĵ��ǣ�����ȷ�ģ�");
			}
			else{
				setTitle("��ѡ��Ĵ���:�Ǵ���ģ�");
			}
			
		}
    	
    }
    class btn2_cancel implements OnClickListener{
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

	
	private RadioGroup.OnCheckedChangeListener mChangeRadio = new RadioGroup.OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			if (checkedId == r1.getId()) {
				// ��ð�ť������
				currentRadioButton=r1;
			} else if (checkedId == r2.getId()) {
				currentRadioButton=r2;
			} else if (checkedId == r3.getId()) {
				currentRadioButton=r3;
			} else if (checkedId == r4.getId()) {
				currentRadioButton=r4;
			}
		}
	};
}