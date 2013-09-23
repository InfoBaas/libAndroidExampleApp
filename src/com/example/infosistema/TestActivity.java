package com.example.infosistema;

import java.io.File;
import java.util.Set;

import openbaas.Baas;

import Users.OpenbaasUser;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.openbaas.Openbaas;

public class TestActivity extends Activity implements OnClickListener {
	Openbaas openbaas = Baas.getInstance().getOpenbaas();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.test_activity);
		Button uploadBut = (Button) findViewById(R.id.uploadFileButton);
		uploadBut.setOnClickListener(this);
		
		Button testBut = (Button) findViewById(R.id.uploadStorageFileButton);
		testBut.setOnClickListener(this);
		
		Button downloadBut = (Button) findViewById(R.id.download_button);
		downloadBut.setOnClickListener(this);
		
		Button findAllStorageIds = (Button) findViewById(R.id.findAllStorageIds_testBut);
		findAllStorageIds.setOnClickListener(this);
		
		Button deleteStorageFileTestBut = (Button) findViewById(R.id.deleteStorageFileButton);
		deleteStorageFileTestBut.setOnClickListener(this);
		
		Button deleteUserTestBut = (Button) findViewById(R.id.deleteUserTestButton);
		deleteUserTestBut.setOnClickListener(this);
		
		Button uploadImageTestBut = (Button) findViewById(R.id.uploadImageTestButton);
		uploadImageTestBut.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String errorMesg = null;
		switch (v.getId()) {
		case R.id.uploadFileButton:
			String pathToFile = Environment.getExternalStorageDirectory()
					.getAbsolutePath() + File.separator + "test.jpg";
			errorMesg =  openbaas.uploadStorageFile(pathToFile);
			if(errorMesg != null)
				Toast.makeText(getApplicationContext(), errorMesg, Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(getApplicationContext(), "Upload ok", Toast.LENGTH_SHORT).show();
			break;
		case R.id.findAllStorageIds_testBut:
			Set<String> ids =  openbaas.findAllStorageIds();
			
			break;
		case R.id.download_button:
			errorMesg =  openbaas.downloadStorageFile("a89", Environment
					.getExternalStorageDirectory().getAbsolutePath());
			if(errorMesg != null)
				Toast.makeText(getApplicationContext(), errorMesg, Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(getApplicationContext(), "Download ok", Toast.LENGTH_SHORT).show();
			break;
		case R.id.uploadStorageFileButton:
			String file = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "test.jpg";
			if(new File(file).exists())
				errorMesg =  openbaas.uploadStorageFile(file);
			else
				Toast.makeText(getApplicationContext(), "Could not find the file", Toast.LENGTH_SHORT).show();
			if(errorMesg != null)
				Toast.makeText(getApplicationContext(), errorMesg, Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(getApplicationContext(), "Upload ok", Toast.LENGTH_SHORT).show();
			break;
		case R.id.deleteStorageFileButton:
			errorMesg =  openbaas.deleteStorageFile("12d");
			if(errorMesg != null)
				Toast.makeText(getApplicationContext(), errorMesg, Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(getApplicationContext(), "Delete ok", Toast.LENGTH_SHORT).show();
			break;
		case R.id.deleteUserTestButton:
			OpenbaasUser user = new OpenbaasUser();
			user.setUserId("e57");
			errorMesg =  openbaas.deleteUser(user);
			if(errorMesg != null)
				Toast.makeText(getApplicationContext(), errorMesg, Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(getApplicationContext(), "Delete User ok", Toast.LENGTH_SHORT).show();
			break;
		case R.id.uploadImageTestButton:
			errorMesg = openbaas.uploadImage(Environment.getExternalStorageDirectory().getAbsolutePath() +
					File.separator + "test.jpg");
			if(errorMesg != null)
				Toast.makeText(getApplicationContext(), errorMesg, Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(getApplicationContext(), "Upload Image ok", Toast.LENGTH_SHORT).show();
		}
	}
}
