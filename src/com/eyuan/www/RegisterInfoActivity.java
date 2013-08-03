package com.eyuan.www;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.os.Bundle;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterInfoActivity extends FinalActivity {

	@ViewInject(id = R.id.registerinfo_avatar_view, click = "onAvatarClick")
	// 是不是只要是view就都能点击啊＝ ＝
	ImageView avatarImageView;
	@ViewInject(id = R.id.registerinfo_nickname_text)
	EditText nicknameEditText;
	@ViewInject(id = R.id.registerinfo_malesex_view, click = "onSexClick")
	ImageView maleImageView;
	@ViewInject(id = R.id.registerinfo_femalesex_view, click = "onSexClick")
	ImageView femaleImageView;
	@ViewInject(id = R.id.registerinfo_province_autoview)
	AutoCompleteTextView provinceAutoCompleteTextView;
	@ViewInject(id = R.id.registerinfo_school_autoview)
	AutoCompleteTextView schoolAutoCompleteTextView;
	@ViewInject(id = R.id.registerinfo_complete_button, click = "onCompleteClick")
	Button completeButton;
	
	private String tokenJson;
	//there should be a user object to contain userinfo of me
	//there should be a list contains provinces
	//there should be a list contains provinces names
	//there should be a list contains university names
	//there should be a finaldb object to save the userinfo data

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.registerinfo);
		this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titleleft);
		
		
	}

}
