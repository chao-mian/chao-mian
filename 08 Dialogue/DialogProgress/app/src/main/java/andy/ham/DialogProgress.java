package andy.ham;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class DialogProgress extends Activity {
	/** Called when the activity is first created. */
	private ProgressBar firstBar = null;
	private ProgressBar secondBar = null;
	private Button myButton = null;
	private int i = 0;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		firstBar = (ProgressBar) findViewById(R.id.firstBar);
		secondBar = (ProgressBar) findViewById(R.id.secondBar);
		myButton = (Button) findViewById(R.id.myButton);
		myButton.setOnClickListener(new ButtonListener());
	}

	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (i == 0) {
				// 设置进度条处于可见的状态
				firstBar.setVisibility(View.VISIBLE);
				secondBar.setVisibility(View.VISIBLE);
				firstBar.setMax(150);
			} else if (i < firstBar.getMax()) {
				// 设置主进度条的当前值
				firstBar.setProgress(i);
				// 设置第二进度条的当前值
				firstBar.setSecondaryProgress(i + 10);
			} else {
				// 设置进度条处于不可见状态
				firstBar.setVisibility(View.GONE);
				secondBar.setVisibility(View.GONE);
			}
			i = i + 10;
		}
	}
}