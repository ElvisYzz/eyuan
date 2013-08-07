package com.eyuan.www;

import android.content.Intent;
import android.os.Bundle;
import net.tsz.afinal.FinalActivity;

public class SplashScreen extends FinalActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.splashscreen);
		
		try {
			Thread.sleep(9);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	Intent intent = new Intent();
		intent.setClass(SplashScreen.this, RegisterInfoActivity.class);
		startActivity(intent);
	}

}
