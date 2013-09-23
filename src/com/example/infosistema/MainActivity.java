package com.example.infosistema;

import java.io.File;

import openbaas.Baas;

import org.apache.http.HttpResponse;

import com.example.openbaas.Openbaas;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_main);
		
		Openbaas openbaas = Baas.getInstance().getOpenbaas();
		openbaas.setAppId("6f2");
		Button usersBut = (Button) findViewById(R.id.usersButton);
		Button plumbersBut = (Button) findViewById(R.id.plumbersButton);
		
		Button launchTest = (Button) findViewById(R.id.launch_testActivity);
		launchTest.setOnClickListener(this);
		usersBut.setOnClickListener(this);
		plumbersBut.setOnClickListener(this);
		
	}
	private void showDialog(String message){
		AlertDialog ad = new AlertDialog.Builder(this).create();
		ad.setCancelable(false); // This blocks the 'BACK' button
		ad.setMessage(message);
		ad.show();

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onClick(View v) {
		Intent change;
		switch(v.getId()){
		case R.id.plumbersButton:
			change = new Intent(this, PlumbersActivity.class);
			startActivity(change);
			break;
		case R.id.usersButton:
			change = new Intent(this, UsersActivity.class);
			startActivity(change);
			break;
		case R.id.launch_testActivity:
			change = new Intent(this, TestActivity.class);
			startActivity(change);
			break;
		}
	}
}
