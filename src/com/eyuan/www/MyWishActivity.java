package com.eyuan.www;

import net.tsz.afinal.annotation.view.ViewInject;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class MyWishActivity extends Activity{
	@ViewInject(id = R.id.achieving, click = "onAchieving") Button mbtn_achieving;
	@ViewInject(id = R.id.achieved, click = "onAchieved") Button mbtn_achieved;
	@ViewInject(id = R.id.unachieve, click = "onUnachieve") Button mbtn_unachieveButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.mywish);
	}

}
