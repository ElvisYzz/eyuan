package com.eyuan.www;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class RegisterActivity extends FinalActivity {

	@ViewInject(id = R.id.register_complete_button, click = "onRegisterCompleteClick")
	Button registerCompleteButton;
	@ViewInject(id = R.id.register_email_text)
	EditText emailEditText;
	@ViewInject(id = R.id.register_pwd_text)
	EditText pwdEditText;
	@ViewInject(id = R.id.register_pwdconfirm_text)
	EditText pwdConfirmEditText;
	@ViewInject(id = R.id.register_alert_view)
	TextView alertTextView;

	// there should be a registerrequest to post data to server
	// there should be a loginrequest to post login data to server
	private String emailString;
	private String pwdString;
	private String pwdconfirmString;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.register);
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

	public void onRegisterCompleteClick(View v) {
		this.getEditTexts();
		boolean isEmailCorrectFlag = this.isEmailCorrect();
		boolean isPwdCorrectFlag = this.isPwdCorrect();

		if (isEmailCorrectFlag && isPwdCorrectFlag) {
			// there should initial the registerrequest to post register data to
			// server and add ajaxcallback and start the request
			// so does the loginrequest
		}else if(!isEmailCorrectFlag){
			alertTextView.setText("��������ȷ��ʽ�������ַ");
		}else if (!isPwdCorrectFlag){
			alertTextView.setText("�����������벻һ�£�����������");
		}
	}

	private void getEditTexts() {
		this.emailString = emailEditText.getText().toString();
		this.pwdString = pwdEditText.getText().toString();
		this.pwdconfirmString = pwdConfirmEditText.getText().toString();
	}

	private boolean isEmailCorrect() {
		// ���滹Ҫ����email��֤ģ�鰡�� ��

		boolean f = true;
		return f;
	}

	private boolean isPwdCorrect() {
		// ������֤����ô�� ��

		boolean f = true;
		f = (this.pwdString != null && !pwdString.trim().equals("")
				&& !pwdconfirmString.trim().equals("") && pwdString
				.equals(pwdconfirmString)) ? true : false;
		return f;
	}

}
