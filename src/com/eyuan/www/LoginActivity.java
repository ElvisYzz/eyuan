package com.eyuan.www;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class LoginActivity extends FinalActivity {

	@ViewInject(id = R.id.login_login_button, click = "onLoginClick")
	Button loginButton;
	@ViewInject(id = R.id.login_register_button, click = "onRegisterClick")
	Button registerButton;
	@ViewInject(id = R.id.login_email_text)
	EditText emailEditText;
	@ViewInject(id = R.id.login_pwd_text)
	EditText pwdEditText;
	@ViewInject(id = R.id.login_alert_view)
	TextView alerTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.login);
		this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titleleft);
		Button backButton = (Button) findViewById(R.id.titleleft_back_button);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	public void onLoginClick(View v) {
		String nickname = emailEditText.getText().toString();
		String password = pwdEditText.getText().toString();
		// there should be a loginrequest to post login data in server and start
		// the loginrequest
	}

	public void onRegisterClick(View v) {
		Intent intent = new Intent();
		intent.setClass(LoginActivity.this, RegisterActivity.class);
		startActivity(intent);
		this.finish();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		// 这有意义么？？？
		Log.d("LoginActivity", "started");
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}

}
