package com.eyuan.www;

import java.util.LinkedList;

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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MyWishActivity extends FinalActivity {
	@ViewInject(id = R.id.mywish_achieving_button, click = "onAchieving")
	Button achievingButton;
	@ViewInject(id = R.id.mywish_achieved_button, click = "onAchieved")
	Button achievedButton;
	@ViewInject(id = R.id.mywish_unadopted_button, click = "onUnadopted")
	Button onUnadoptedButton;

	@ViewInject(id = R.id.mywish_wishlist_view, itemClick = "onWishListItemClick")
	ListView mWishListView;
	@ViewInject(id = R.id.mywish_bg_layout)
	LinearLayout mWishBackgroundLayout;

	// there should be three linkedlist<Wish> to trans the achieving achieved
	// unadopted wish datas

	private BaseAdapter achievingAdapter = null;
	private BaseAdapter achievedAdapter = null;
	private BaseAdapter unadoptedAdapter = null;

	// there should be a wishlistrequest object for request data from server

	private enum ListState {
		achieving, achieved, unadopted;
	}

	private ListState mywishListState;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.mywish);
		this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titleleft);

		// there should initialize the wishlistrequest and set callbackhandler
		// for wishlistrequest
		// start the wishlistrequest

		// initlistadapter and init wishlist
		this.initListAdapter();
		this.initWishList();

		Button backButton = (Button) findViewById(R.id.titleleft_back_button);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyWishActivity.this.finish();
			}
		});

	}

	public void onAchieving(View v) {
		this.mywishListState = ListState.achieving;
		this.mWishBackgroundLayout
				.setBackgroundResource(R.drawable.mywish_achievingtime_bg);
		this.mWishListView.setAdapter(achievingAdapter);
	}

	public void onAchieved(View v) {
		this.mywishListState = ListState.achieved;
		this.mWishBackgroundLayout
				.setBackgroundResource(R.drawable.mywish_achievedtime_bg);
		this.mWishListView.setAdapter(achievedAdapter);
	}

	public void onUnadopted(View v) {
		this.mywishListState = ListState.unadopted;
		this.mWishBackgroundLayout
				.setBackgroundResource(R.drawable.mywish_unadoptedtime_bg);
		this.mWishListView.setAdapter(unadoptedAdapter);
	}

	public void onWishListItemClick(AdapterView<?> adapter, View v, int i,
			long l) {
		// TODO Auto-generated method stub
		if (this.mywishListState.equals(ListState.achieving)) {
			Intent intent = new Intent();
			intent.setClass(MyWishActivity.this, CommentActivity.class);
			// there should put achieving wish data with intent to
			// commentactivity
			startActivity(intent);
			// 这里为什么销毁当前activity
			finish();
		} else if (this.mywishListState.equals(ListState.achieved)) {
			Intent intent = new Intent();
			intent.setClass(MyWishActivity.this, CommentActivity.class);
			// there should put achieved wish data with intent to
			// commentactivity
			startActivity(intent);
			finish();
		}
	}

	private void initListAdapter() {
		// there should initialize the three linkedlist<Wish> to contain wish
		// data
		achievingAdapter = new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				convertView = LayoutInflater.from(MyWishActivity.this).inflate(
						R.layout.mywishachievingitem, null);
				TextView textView = (TextView) convertView
						.findViewById(R.id.mywishachievingitem_wishcontent_view);
				// there should set the wishcontent from linkedlist<Wish>
				Button confirmButton = (Button) convertView
						.findViewById(R.id.mywishachievingitem_confirm_button);
				confirmButton.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// there should be a afirmwishrequest to push http data
						// to server
					}
				});

				Button cancleButton = (Button) convertView
						.findViewById(R.id.mywishachievingitem_cancel_button);
				cancleButton.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// there should be a afirmwishrequest to push http data
						// to server
					}
				});
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
				// there should return linkedlist.get(positon)
				return null;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				// there should return linkedlist.size()
				return 0;
			}
		};

		achievedAdapter = new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				convertView = LayoutInflater.from(MyWishActivity.this).inflate(
						R.layout.mywishachieveditem, null);
				TextView textView = (TextView)convertView.findViewById(R.id.mywishachieveditem_wishcontent_view);
				//there should set textview from linkedlist<Wish>
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
				//there should return linkedlist.get(position)
				return null;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				//there should return linkedlist.size()
				return 0;
			}
		};
		
		unadoptedAdapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				convertView = LayoutInflater.from(MyWishActivity.this).inflate(R.layout.mywishunadopteditem, null);
				TextView textView = (TextView)convertView.findViewById(R.id.mywishunadopteditem_wishcontent_view);
				//there should set textview content from linkedlist<Wish>
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
				//there should return linkedlist<Wish>.get(position)
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				//there should return linkedlist<Wish>.size()
				return 0;
			}
		};
	}

	private void initWishList() {
		this.mywishListState = ListState.achieving;
		mWishListView.setAdapter(achievingAdapter);
	}

}
