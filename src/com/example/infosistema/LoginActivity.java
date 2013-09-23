package com.example.infosistema;

import openbaas.Baas;

import com.example.infosistema.register.MainRegisterActivity;
import com.example.openbaas.Openbaas;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener {
	Openbaas openbaas;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.login_activity);
		openbaas = new Openbaas();
		openbaas.setAppId("6f2");
		Button register = (Button) findViewById(R.id.register_button);
		register.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		EditText userName = (EditText) findViewById(R.id.username_textField);
		EditText password = (EditText) findViewById(R.id.password_textField);
		
		Intent change;
		switch (v.getId()) {
		case R.id.register_button:
			change = new Intent(this, MainRegisterActivity.class);
			startActivity(change);
			break;
		case R.id.login_button:
			openbaas.createSession(userName.getText().toString(), 
					password.getText().toString());
			
			change = new Intent(this, WelcomeBack.class);
			startActivity(change);
			break;
		}
	}
}
