package com.eyuan.www;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class AchievedActivity extends FinalActivity {

	@ViewInject(id = R.id.achievedwish_comment_view, click = "onCommentClick")
	Button commentButton;
	@ViewInject(id = R.id.achievedwish_wishtext_view)
	TextView wishTextView;
	@ViewInject(id = R.id.achievedwish_avatar_view)
	ImageView avatarImageView;
	@ViewInject(id = R.id.achievedwish_nickname_view)
	TextView nicknameTextView;
	@ViewInject(id = R.id.achievedwish_sex_view)
	ImageView sexImageView;
	@ViewInject(id = R.id.achievedwish_location_view)
	TextView locationTextView;
	@ViewInject(id = R.id.achievedwish_wishlist_view)
	ListView wishList;

	// there should be a wish object
	// there should be a wishowner object

	private BaseAdapter achievedAdapter = null;

	// there should be a list<message> to contain lists
	// there should be a userinforequest and a getmessagerequest to comm with
	// server

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.achievedwish);
		this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titleleft);

		// there should initial mwish object
		// set wish content to mwishtext

		// there should initial userinforequest and getmessagerequest

		Button backButton = (Button) findViewById(R.id.titleleft_back_button);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		this.initAdapter();

	}

	private void initAdapter() {
		// there should init the messagelist
		this.achievedAdapter = new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				convertView = LayoutInflater.from(AchievedActivity.this)
						.inflate(R.layout.commentitem, null);
				TextView textView = (TextView) convertView
						.findViewById(R.id.commentitem_commenttext_view);
				// there should set the text form messagelist to textview
				return convertView;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				// there should return messagelist.get(position)
				return null;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				// there should return messagelist.size()
				return 0;
			}
		};
		wishList.setAdapter(achievedAdapter);
	}

	public void onCommentClick(View v) {
		Intent intent = new Intent();
		intent.setClass(AchievedActivity.this, CommentActivity.class);
		// there should put messagelist gsondata and mwish data with the intent
		startActivity(intent);
	}
}
