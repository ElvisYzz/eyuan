package com.eyuan.www;

import android.app.Dialog;
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

public class AchievingActivity extends FinalActivity {

	@ViewInject(id = R.id.achievingwish_confirm_button, click = "onConfirmClick")
	Button confirmButton;
	@ViewInject(id = R.id.achievingwish_cancel_button, click = "onCancelClick")
	Button cancelButton;
	@ViewInject(id = R.id.achievingwish_comment_view, click = "onCommentClick")
	Button commentButton;
	@ViewInject(id = R.id.achievingwish_wishtext_view)
	TextView wishTextView;
	@ViewInject(id = R.id.achievingwish_avatar_view)
	ImageView avatarImageView;
	@ViewInject(id = R.id.achievingwish_nickname_view)
	TextView nicknameTextView;
	@ViewInject(id = R.id.achievingwish_sex_view)
	ImageView sexImageView;
	@ViewInject(id = R.id.achievingwish_location_view)
	TextView locationTextView;
	@ViewInject(id = R.id.achievingwish_wishlist_view)
	ListView wishList;

	// there should be a wish obejct
	// there should be a user object
	private BaseAdapter achievingAdapter = null;
	// there should be a list<message> to contain messages
	// there should be a userinforequest and getmessagerequest to comm with
	// server
	private boolean isCancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.achievingwish);
		this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titleleft);

		// there should initial the wish object
		// there should set the wishtext from wish object
		// there should initial userinforequest and getmessagerequest

		Button backButton = (Button) findViewById(R.id.titleleft_back_button);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	private void initAdapter() {
		// there should initial the messagelist
		achievingAdapter = new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				convertView = LayoutInflater.from(AchievingActivity.this)
						.inflate(R.layout.commentitem, null);
				TextView textView = (TextView) convertView
						.findViewById(R.id.commentitem_commenttext_view);

				// there should set the textview from messagelist.get(position)

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
				// there should return messagelist.size
				return 0;
			}
		};

		this.wishList.setAdapter(achievingAdapter);
	}

	public void onConfirmClick(View v) {
		String string1 = new String("谢谢你！");
		String string2 = new String("下面就等对方确认你成功帮TA实现愿望了哦～");
		this.openDialog(string1, string2, false);
	}

	public void onCancelClick(View v) {
		String string = new String("取消帮TA实现这个愿望吗？");
		this.openDialog(null, string, true);
	}

	public void onCommentClick(View v) {
		Intent intent = new Intent();
		intent.setClass(AchievingActivity.this, CommentActivity.class);
		// there should put messagelist json data and wish object data with the
		// intent
		startActivity(intent);
	}

	private void openDialog(String string1, String string2, boolean iscancel) {
		View dialogView = View.inflate(AchievingActivity.this, R.layout.dialog,
				null);
		final Dialog showDialog = new Dialog(AchievingActivity.this,
				R.style.dialog);
		this.isCancel = iscancel;
		TextView textView1 = (TextView) dialogView
				.findViewById(R.id.dialog_msgtext1_view);
		textView1.setText(string1);
		TextView textview2 = (TextView) dialogView
				.findViewById(R.id.dialog_msgtext2_view);
		textview2.setText(string2);
		Button iknowButton = (Button) dialogView
				.findViewById(R.id.dialog_iknow_button);
		iknowButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (isCancel) {
					// do nothing just go away
				} else {
					// there should be a afirmwishrequest to post afirm message
					// to server and set ajaxcallback and start the request

				}

				showDialog.dismiss();
			}
		});

		showDialog.setContentView(dialogView);
		showDialog.show();
	}

}
