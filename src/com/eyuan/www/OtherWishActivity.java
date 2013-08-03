package com.eyuan.www;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class OtherWishActivity extends FinalActivity {

	@ViewInject(id = R.id.otherwish_achieving_button, click = "onAchieving")
	Button achievingButton;
	@ViewInject(id = R.id.otherwish_achieved_button, click = "onAchieved")
	Button achievedButton;
	@ViewInject(id = R.id.otherwish_wishlist, itemClick = "onWishListItemClick")
	ListView otherWishListView;
	@ViewInject(id = R.id.otherwish_bg_layout)
	LinearLayout otherWishBackground;

	// there should be two linkedlist<Wish> to contain achieving and achieved
	// wish data

	private BaseAdapter achievingAdapter;
	private BaseAdapter achievedAdapter;

	// there should be a wishlistrequest to request data from server

	private enum ListState {
		achieving, achieved;
	}

	private ListState otherWishListState;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.otherwish);
		this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titleleft);

		// there should init the wishlistrequest to get data from server
		
		this.initListAdapter();
		this.initWishList();
		
		Button backButton = (Button) findViewById(R.id.titleleft_back_button);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	public void onAchieving(View v) {
		this.otherWishListState = ListState.achieving;
		this.otherWishBackground
				.setBackgroundResource(R.drawable.otherwish_achievingtime_bg);
		this.otherWishListView.setAdapter(achievingAdapter);
	}

	public void onAchieved(View v) {
		this.otherWishListState = ListState.achieved;
		this.otherWishBackground
				.setBackgroundResource(R.drawable.otherwish_achievedtime_bg);
		this.otherWishListView.setAdapter(achievedAdapter);
	}

	public void onWishListItemClick(AdapterView<?> adapter, View v, int i,
			long l) {
		if (otherWishListState.equals(ListState.achieving)) {
			Intent intent = new Intent();
			intent.setClass(OtherWishActivity.this, AchievingActivity.class);
			// there should put wish data from linkedlist with intent
			startActivity(intent);
			finish();
		} else if (otherWishListState.equals(ListState.achieved)) {
			Intent intent = new Intent();
			intent.setClass(OtherWishActivity.this, AchievedActivity.class);
			// ther should put wish data from linkedlist with intent
			startActivity(intent);
			finish();
		}
	}

	private void initListAdapter() {
		//there should init the two linkedlist<wish> to 
		achievingAdapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				convertView = LayoutInflater.from(OtherWishActivity.this).inflate(R.layout.otherwishachievingitem, null);
				TextView textView = (TextView)convertView.findViewById(R.id.otherwishachievingitem_wishcontent_view);
				//there should set content to textview from linkedlist<Wish>
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
				//there should return the linkedlist<wish>.get(position)
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				//there should return the linkedlist<wish>.size()
				return 0;
			}
		};
		
		achievedAdapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				convertView = LayoutInflater.from(OtherWishActivity.this).inflate(R.layout.otherwishachieveditem, null);
				TextView textView = (TextView)convertView.findViewById(R.id.otherwishachieveditem_wishcontent_view);
				//there should set content to textview form linkedlist<wish>
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
				//there should return linkedlist<wish>.get(position)
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				//there should return linkedlist<wish>.size()
				return 0;
			}
		};
	}

	private void initWishList() {
		this.otherWishListState = ListState.achieving;
		this.otherWishListView.setAdapter(achievingAdapter);
	}
}
