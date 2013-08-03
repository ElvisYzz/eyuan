package com.eyuan.www;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class CommentActivity extends FinalActivity {
	@ViewInject(id = R.id.comment_commit_btn, click = "onCommentCommit")
	Button commitButton;
	@ViewInject(id = R.id.comment_commentlist_view)
	ListView commentListView;

	private BaseAdapter commentAdapter;
	// there should be a list<message> or linkedlist<message> to contain message
	// there should be a wish object to be mywish
	private String mLeaveMessageContent;

	// there should be a leavemessagerequest and a getmessagerequest

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.comment);
		this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titleleft);

		// there should init mwish object and list<message> or
		// linkedlist<message> or arraylist<message>

		Button backButton = (Button) findViewById(R.id.titleleft_back_button);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		// there should init leavemessagerequest and getmessagerequest and start
		// getmessagerequest

		this.initAdapter();
	}

	public void onCommentCommit(View v) {
		EditText editText = (EditText) findViewById(R.id.comment_editcomment_text);
		this.mLeaveMessageContent = editText.getText().toString();
		editText.setText("");
		// there should be set mleavemessagecontent in mleavemessagerequest and
		// start mleavemessagerequest post to server

	}

	private void initAdapter() {
		this.commentAdapter = new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				convertView = LayoutInflater.from(CommentActivity.this)
						.inflate(R.layout.commentitem, null);
				TextView textView = (TextView) convertView
						.findViewById(R.id.commentitem_commenttext_view);
				// there should set content from messagelist to textview

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
				//there should return messagelist.get(position)
				return null;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				//there should return messagelist.size()
				return 0;
			}
		};
	}

	private void updateCommentList(String message) {
		// add message to messagelist after mleavemessagerequest post the new
		// message to server

		this.commentAdapter.notifyDataSetChanged();

	}

}
