package com.akihirot.counter;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Counter countNum;
	TextView countText;
	Button resetButton;
	Button decButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		countText = (TextView)findViewById(R.id.counttext_id);
		resetButton = (Button)findViewById(R.id.resetButton_id);
		decButton = (Button)findViewById(R.id.decButton_id);
		
		countNum = new Counter("mainCounter" );
		countNum.setNum(getNum(countNum));
		setText(countText, countNum.getNum());
		
		countText.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				countNum.inc();
				setText(countText, countNum.getNum());
				saveNum(countNum);
			}
		});
		
		resetButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				countNum.reset();
				setText(countText, countNum.getNum());
				saveNum(countNum);
			}

		});
		
		decButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				countNum.dec();
				setText(countText, countNum.getNum());
				saveNum(countNum);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	 
	 // set TextView with int 
	 public void setText(TextView textView, int num){
		 String textNum = String.valueOf(num);
		 textView.setText(textNum);
	 }
	 
	 // get count number from Preference
	 public int getNum(Counter counter) {
			SharedPreferences pref =getPreferences(MODE_PRIVATE);
		return pref.getInt(counter.getName(),0);
	 }
	 
	 // save count number for Preference
	 public void saveNum(Counter counter) {
		 SharedPreferences pref =getPreferences(MODE_PRIVATE);
		 Editor e = pref.edit();
		 e.putInt(counter.getName(), counter.getNum());
		 e.commit();
	 }
	 

}
