package com.right.miracle;

import android.os.Bundle;
import android.view.Window;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);
		Thread logoTimer = new Thread(){
			public void run(){
				try {
					sleep(5000);
					Intent menuIntent = new Intent("com.right.miracle.MENU");
					startActivity(menuIntent);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				finally{
					finish();
				}
			}
		};
		logoTimer.start();
	}
	

}
