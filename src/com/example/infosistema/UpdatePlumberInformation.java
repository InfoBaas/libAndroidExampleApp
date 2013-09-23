package com.example.infosistema;

import openbaas.Baas;
import Users.OpenbaasUser;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.openbaas.Openbaas;

public class UpdatePlumberInformation extends Activity implements
		OnClickListener {
	Openbaas openbaas = Baas.getInstance().getOpenbaas();
	private Button update;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.update_user_activity);
		update = (Button) findViewById(R.id.update_button);
		update.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.update_button:
			EditText email   = (EditText)findViewById(R.id.update_emailTextField);
			EditText password = (EditText)findViewById(R.id.update_passwordTextField);
			CheckBox alive = (CheckBox)findViewById(R.id.update_aliveCheckBox);
			
			OpenbaasUser user = new OpenbaasUser();
			if(!password.getText().toString().matches(""))
				user.setPassword(password.getText().toString());
			if(!email.getText().toString().matches("")){
				user.setEmail(email.getText().toString());
				user.setAlive(!alive.isChecked());
				user.setUserId(openbaas.getAppId());
				String errorMesg = openbaas.updateUser(user);
				if(errorMesg != null){
					//treat error
				}
				else{
					Toast.makeText(this, "Updated User sucessfully",
							Toast.LENGTH_SHORT).show();
				}
			}
			break;
		}
	}
}
