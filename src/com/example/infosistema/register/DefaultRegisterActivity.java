package com.example.infosistema.register;

import openbaas.Baas;
import Users.OpenbaasUser;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.infosistema.R;
import com.example.infosistema.R.id;
import com.example.infosistema.R.layout;
import com.example.openbaas.Openbaas;

public class DefaultRegisterActivity extends Activity implements OnClickListener {
	Openbaas openbaas = Baas.getInstance().getOpenbaas();
	public static final String SUCESS_MESSAGE = "User created, please login";
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.register_activity);
		Button send = (Button) findViewById(R.id.register_send_data);
		send.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent change;
		EditText userName   = (EditText)findViewById(R.id.username_textField);
		EditText email = (EditText)findViewById(R.id.email_textField);
		EditText password = (EditText)findViewById(R.id.password_textField);
		Log.d("userName", userName.getText().toString());
		Log.d("email", email.getText().toString());
		Log.d("password", password.getText().toString());
		switch (v.getId()) {
		case R.id.register_send_data:
			OpenbaasUser user = new OpenbaasUser();
			user.setUserName(userName.getText().toString());
			user.setEmail(email.getText().toString());
			user.setPassword(password.getText().toString());
			user.setAppId(openbaas.getAppId());
			String errorMessage = openbaas.createUser(user);
			if(errorMessage != null)
				Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(this, SUCESS_MESSAGE, Toast.LENGTH_SHORT).show();
			
		}
	}

}
