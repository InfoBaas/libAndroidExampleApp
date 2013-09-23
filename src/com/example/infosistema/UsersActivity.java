package com.example.infosistema;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class UsersActivity extends Activity implements OnClickListener{

	protected void onCreate(Bundle icicle){
		super.onCreate(icicle);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.users_activity);
		Button viewAll = (Button) findViewById(R.id.seePlumbersButton);
		Button askHelp = (Button) findViewById(R.id.ask_for_help_button);
		Button searchPlumbers = (Button) findViewById(R.id.searchPlumbersButton);
		Button seeAllAds = (Button) findViewById(R.id.seeAllAdsButton);
		viewAll.setOnClickListener(this);
		askHelp.setOnClickListener(this);
		searchPlumbers.setOnClickListener(this);
		seeAllAds.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent change;
		switch(v.getId()){
		case R.id.seePlumbersButton:
			change = new Intent(this, SeeAllPlumbersActivity.class);
			startActivity(change);
			break;
		case R.id.ask_for_help_button:
			change = new Intent(this, AskForHelpActivity.class);
			startActivity(change);
			break;
		case R.id.searchPlumbersButton:
			change = new Intent(this, SearchPlumbersActivity.class);
			startActivity(change);
			break;
		case R.id.seeAllAdsButton:
			change = new Intent(this, AdsActivity.class);
			startActivity(change);
			break;
		}
	}
}
