package com.example.infosistema;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PlumbersActivity extends Activity implements OnClickListener {

	protected void onCreate(Bundle icicle){
		super.onCreate(icicle);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.plumbers_activity);
		Button postAd = (Button) findViewById(R.id.postAdButton);
		Button login = (Button) findViewById(R.id.loginButton);
		Button updateInfo = (Button) findViewById(R.id.update_information_button);
		postAd.setOnClickListener(this);
		login.setOnClickListener(this);
		updateInfo.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent change;
		switch(v.getId()){
		case R.id.loginButton:
			change = new Intent(this, LoginActivity.class);
			startActivity(change);
			break;
		case R.id.postAdButton:
			change = new Intent(this, PostAdActivity.class);
			startActivity(change);
			break;
		case R.id.update_information_button:
			change = new Intent(this, UpdatePlumberInformation.class);
			startActivity(change);
			break;
		}
	}
}
