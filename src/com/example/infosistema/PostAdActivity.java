package com.example.infosistema;

import org.json.simple.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.openbaas.Openbaas;

public class PostAdActivity extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.post_ad_activity);
		Button publishButton = (Button) findViewById(R.id.ad_publishButton);
		publishButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent change;
		switch (v.getId()) {
		case R.id.ad_publishButton:
			ConnectivityManager manager = (ConnectivityManager) getSystemService(MainActivity.CONNECTIVITY_SERVICE);
			Boolean is3g = manager.getNetworkInfo(
					ConnectivityManager.TYPE_MOBILE).isConnected();
			/*
			 * wifi confirm
			 */
			Boolean isWifi = manager.getNetworkInfo(
					ConnectivityManager.TYPE_WIFI).isConnected();
			if (!is3g || isWifi) {
				Toast.makeText(this, "You are not connected to a Network",
						Toast.LENGTH_SHORT).show();
			} else {
				EditText address = (EditText) findViewById(R.id.ad_address);
				EditText adTitle = (EditText) findViewById(R.id.ad_titleTextField);
				EditText price = (EditText) findViewById(R.id.ad_priceTextField);
				EditText contactNumber = (EditText) findViewById(R.id.ad_contactNumberTextField);
				EditText description = (EditText) findViewById(R.id.ad_descriptionTextField);
				if (address.getText().toString().matches(""))
					Toast.makeText(this, "You did not enter an address",
							Toast.LENGTH_SHORT).show();
				else if (adTitle.getText().toString().matches(""))
					Toast.makeText(this, "You did not enter an Ad Title",
							Toast.LENGTH_SHORT).show();
				else if (contactNumber.getText().toString().matches(""))
					Toast.makeText(this, "You did not enter a contact Number",
							Toast.LENGTH_SHORT).show();
				else if (description.getText().toString().matches(""))
					Toast.makeText(this, "You did not enter a description",
							Toast.LENGTH_SHORT).show();
				else {
					JSONObject json = new JSONObject();
					json.put("address", address.getText().toString());
					json.put("adTitle", adTitle.getText().toString());
					json.put("contactNumber", contactNumber.getText()
							.toString());
					json.put("price", price.getText().toString());
					json.put("descrition", description.getText().toString());
//					String userId = ApplicationData.getUserId(userName
//							.getText().toString());
					JSONObject jsonFinal = new JSONObject();
					jsonFinal.put("ads", json);
//					String errorMesg = Openbaas.createAppData(json,ApplicationData.appId, userId);
//					Openbaas.createUserDataWithUserId(json,
//							ApplicationData.appId, userId);
				}
			}
			break;
		}
	}

}