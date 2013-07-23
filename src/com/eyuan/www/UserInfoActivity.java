package com.eyuan.www;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserInfoActivity extends FinalActivity{
	@ViewInject(id = R.id.mywish, click = "onMywish") Button mbtn_mywish;
	@ViewInject(id = R.id.otherwish, click = "onOtherwish") Button mbtn_otherwish;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.about);
	}
	
	public void onMywish(View v){
		System.out.println("onmywish");
		mbtn_mywish.setBackgroundResource(R.drawable.mywish_btn_down);
		mbtn_otherwish.setBackgroundResource(R.drawable.otherwish_btn_up);
		Intent i = new Intent(UserInfoActivity.this, MyWishActivity.class);
		startActivity(i);
	}
	
	public void onOtherwish(View v){
		System.out.println("onotherwish");
		mbtn_otherwish.setBackgroundResource(R.drawable.otherwish_btn_down);
		mbtn_mywish.setBackgroundResource(R.drawable.mywish_btn_up);
		Intent i = new Intent(UserInfoActivity.this, OtherWishActivity.class);
		startActivity(i);
	}
}
