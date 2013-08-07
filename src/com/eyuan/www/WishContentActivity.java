package com.eyuan.www;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class WishContentActivity extends FinalActivity {

	@ViewInject(id = R.id.wishcontent_achievebutton, click = "onAchieveClick")
	Button achieveButton;
	@ViewInject(id = R.id.wishcontent_top2_layout)
	RelativeLayout topRelativeLayout;
	@ViewInject(id = R.id.wishcontent_avatar_view)
	ImageView avatarImageView;
	@ViewInject(id = R.id.wishcontent_nickname_view)
	TextView nicknameTextView;
	@ViewInject(id = R.id.wishcontent_sex_view)
	ImageView sexImageView;
	@ViewInject(id = R.id.wishcontent_location_view)
	TextView locationTextView;
	@ViewInject(id = R.id.wishcontent_wishtext)
	TextView wishTextView;

	// there should be a wish object
	// there should be a user object
	// there should be a userinforequest object
	// there should be a adoptwishrequest object

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.wishcontent);
		this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titleleft);

		// there should init the wish object
		// 0-255 0 totally transparent and 255 is opaque
		topRelativeLayout.getBackground().setAlpha(100);
		// set the wish content on wishtextview via wish object
		// initial the userinforequest and add ajaxcallback on it
		// initial the adoptwishrequest and add ajaxcallback on it

		Button backButton = (Button) findViewById(R.id.titleleft_back_button);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	// there should be a function to updateuserinfo via userinforequest

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		// start the userinforequest to get userinfo data from server
	}

	public void onAchieveClick(View v) {
		// there should start the adoptwishrequest
	}

}
