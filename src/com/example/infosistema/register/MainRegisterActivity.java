package com.example.infosistema.register;

import com.example.infosistema.R;
import com.example.infosistema.mainFacebookActivity;
import com.example.infosistema.R.id;
import com.example.infosistema.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainRegisterActivity extends Activity implements OnClickListener  {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.main_register_activity);
		Button defaultRegisterBut = (Button) findViewById(R.id.default_registerBut);
		Button facebookRegisterBut = (Button) findViewById(R.id.facebook_registerBut);
		Button linkedinRegisterBut = (Button) findViewById(R.id.linkedin_registerBut);
		defaultRegisterBut.setOnClickListener(this);
		facebookRegisterBut.setOnClickListener(this);
		linkedinRegisterBut.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		Intent change;
		switch(v.getId()){		
		case R.id.default_registerBut:
			change = new Intent(this, DefaultRegisterActivity.class);
			startActivity(change);
			break;
		case R.id.facebook_registerBut:
			change = new Intent(this, mainFacebookActivity.class);
			startActivity(change);
			break;
		case R.id.linkedin_registerBut:
			change = new Intent(this, LinkedinRegisterActivity.class);
			startActivity(change);
			break;
		}
		
	}
}
