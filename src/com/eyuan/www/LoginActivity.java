package com.eyuan.www;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class LoginActivity extends FinalActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.login);
	}
	
}
