package com.eyuan.www;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class SubmitActivity extends FinalActivity implements OnClickListener{

	@ViewInject(id = R.id.submit_edit_wish)
	EditText submitWishEditText;

	// these two buttons is on the custom title
	private Button backButton;
	private Button commitButton;
	private String submitWishContent;

	// there should be a releasewishrequest to post wish data to server

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.submit);
		this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titlesubmit);
		
		backButton = (Button)findViewById(R.id.titlesubmit_back_button);
		commitButton = (Button)findViewById(R.id.titlesubmit_commit_button);
		
		backButton.setOnClickListener(this);
		commitButton.setOnClickListener(this);
		
		//there should initial the releaserequest to post releasewish data to server
		this.submitWishContent = null;
	}

	public void onCommit(){
		submitWishContent = submitWishEditText.getText().toString();
		if(submitWishContent != null && !submitWishContent.equals("")){
			//there should set submitwishcontent to releasewishrequest and start the releasewishrequest
		}
	}
	
	public void onBack(){
		finish();
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.titlesubmit_back_button:
			this.onBack();
			break;
		
		case R.id.titlesubmit_commit_button:
			this.onCommit();
			break;
		default:
			break;
		}
		
	}
}
