package com.eyuan.www;

import java.io.ByteArrayOutputStream;
import java.io.File;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.R.integer;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

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

	private enum GenderType {
		male, female;
	}

	private GenderType gender;

	// there should be a user object to contain userinfo of me
	// there should be a list contains provinces
	// there should be a list contains provinces names
	// there should be a list contains university names
	// there should be a finaldb object to save the userinfo data

	public static final int NONE = 0;
	public static final int TAKEPHOTO = 1;
	public static final int SELECTPHOTO = 2;
	public static final int RESULTPHOTO = 3;
	public static final String IMAGE_UNSPECIFIED = "image/*";
	public static final String IMAGETAKENAME = "cleantha.jpg";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.registerinfo);
		this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titleleft);

		this.gender = GenderType.male;
		// there should init the user object to contain the userinfo
		// there should init the tokenjson from the intent via getstringextra
		// method

		Button backButton = (Button) findViewById(R.id.titleleft_back_button);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		this.initProvinceList();
		this.initAdapter();

	}

	private void initProvinceList() {
		// there should init finaldb object from ewish.db and init provincenames
		// list for the province autocompletetextview

	}

	private void initAdapter() {
		// init arrayadapter for the autocompletetextview from provincenames and
		// also the schoolnames and the schoolautocompletenames

	}

	public void onAvatarClick(View v) {
		createDialog().show();
	}

	private Dialog createDialog() {
		Dialog dialog = null;
		Builder builder = new Builder(RegisterInfoActivity.this);
		builder.setIcon(R.drawable.ic_launcher);

		builder.setItems(R.array.choice,
				new android.content.DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intent = null;

						switch (which) {
						case 0:
							intent = new Intent(Intent.ACTION_GET_CONTENT, null);
							intent.setDataAndType(
									MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
									IMAGE_UNSPECIFIED);
							startActivityForResult(intent, SELECTPHOTO);
							break;

						case 1:
							intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
							intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri
									.fromFile(new File(Environment
											.getExternalStorageDirectory(),
											IMAGETAKENAME)));

							startActivityForResult(intent, TAKEPHOTO);
							break;

						default:
							break;
						}
					}
				});

		dialog = builder.create();
		return dialog;
	}

	public void onSexClick(View v) {
		switch (v.getId()) {
		case R.id.registerinfo_malesex_view:
			maleImageView
					.setBackgroundResource(R.drawable.registerinfo_sexchoicemale_down);
			femaleImageView
					.setBackgroundResource(R.drawable.registerinfo_sexchoicefemale_up);
			gender = GenderType.male;
			break;

		case R.id.registerinfo_femalesex_view:
			maleImageView
					.setBackgroundResource(R.drawable.registerinfo_sexchoicemale_up);
			femaleImageView
					.setBackgroundResource(R.drawable.registerinfo_sexchoicefemale_down);
			gender = GenderType.female;
			break;

		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == NONE) {
			return;
		}

		if (requestCode == TAKEPHOTO) {
			File photo = new File(Environment.getExternalStorageDirectory()
					+ File.separator + IMAGETAKENAME);
			startPhotoZoom(Uri.fromFile(photo));
		}

		if (data == null) {
			return;
		}

		if (requestCode == SELECTPHOTO) {
			// The URI of the data this intent is targeting or null.
			startPhotoZoom(data.getData());
		}

		if (requestCode == RESULTPHOTO) {
			Bundle extraData = data.getExtras();
			if (extraData != null) {
				// getSerializable getParcelable都是直接获取一个对象方法
				// 传递方法要继承serilizable借口
				Bitmap photo = extraData.getParcelable("data");
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				photo.compress(Bitmap.CompressFormat.JPEG, 75, outputStream);

				avatarImageView.setImageBitmap(photo);

				// and there should set stream to user object with base64 encode
				// post to server to save
			}
		}
	}

	public void startPhotoZoom(Uri uri) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, IMAGE_UNSPECIFIED);
		intent.putExtra("crop", "true");
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX outputY 是裁剪图片宽高
		intent.putExtra("outputX", 64);
		intent.putExtra("outputY", 64);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, RESULTPHOTO);
	}

}
