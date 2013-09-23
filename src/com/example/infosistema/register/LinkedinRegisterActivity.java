package com.example.infosistema.register;

import com.example.infosistema.R;
import com.example.infosistema.R.layout;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class LinkedinRegisterActivity extends Activity implements OnClickListener {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.linkedin_register_activity);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
