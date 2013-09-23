package com.example.infosistema;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class WelcomeBack extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.welcome_back_activity);
		
	}
}
