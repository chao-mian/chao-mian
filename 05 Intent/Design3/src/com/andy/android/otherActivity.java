package com.andy.android;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class otherActivity extends Activity{
	private Intent intent;
	private Bundle bunde;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		/* ȡ��Intent �е�Bundle ���� */
		Bundle bunde = this.getIntent().getExtras();
		/* ȡ��Bundle �����е����� */
		String ans = bunde.getString("ans");
		/* �ж���ѡ��*/
		String sexText = "";
		if (ans.equals("in")) {
			sexText = "��ȷ";
			} else {
			sexText = "����";
			}
		TextView tv1 = (TextView) findViewById(R.id.text1);
		tv1.setText("��ѡ��Ĵ��ǣ�" + sexText);
		
		/* ��findViewById()ȡ��Button ���󣬲����onClickListener */
		Button btn3_back = (Button) findViewById(R.id.button_back);
		btn3_back.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
			/* ����result ����һ��activity */
			otherActivity.this.setResult(RESULT_OK, intent);
			/* �������activity */
		otherActivity.this.finish();
			}
			});
	}
		
}
		



