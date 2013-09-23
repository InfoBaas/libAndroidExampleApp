package com.example.infosistema;

import java.io.File;
import java.util.List;

import openbaas.Baas;

import com.example.openbaas.Openbaas;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class AskForHelpActivity extends Activity implements OnClickListener {
	ImageView imgView;
	File destination;
	private Bitmap bitmap;
	private static int TAKE_PICTURE = 1;    
	private Uri imageUri;
	private Openbaas openbaas;
	private static final String NO_CAMERA_ERROR = "Smartphone does not have a camera";

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		openbaas = Baas.getInstance().getOpenbaas();
		openbaas.setAppId("6f2");
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.ask_for_help);
		Button cameraButton = (Button) findViewById(R.id.camera_button);
		imgView = (ImageView) findViewById(R.id.imageView1);
		
		Button sendImage = (Button) findViewById(R.id.send_button);
		sendImage.setOnClickListener(this);
		
		cameraButton.setOnClickListener(this);
	}

	public static boolean isIntentAvailable(Context context, String action) {
		final PackageManager packageManager = context.getPackageManager();
		final Intent intent = new Intent(action);
		List<ResolveInfo> list = packageManager.queryIntentActivities(intent,
				PackageManager.MATCH_DEFAULT_ONLY);
		return list.size() > 0;
	}

	private void dispatchTakePictureIntent(int actionCode) {
		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(takePictureIntent, actionCode);
	}

	private void handleSmallCameraPhoto(Intent intent) {
		Bundle extras = intent.getExtras();
		Bitmap mImageBitmap = (Bitmap) extras.get("data");
		imgView.setImageBitmap(mImageBitmap);
	}

	@Override
	public void onClick(View v) {
		Context context = this;
		switch(v.getId()){
		case R.id.camera_button:
			PackageManager packageManager = context.getPackageManager();
			if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)
					&& isIntentAvailable(context, MediaStore.ACTION_IMAGE_CAPTURE)) {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
			    intent.putExtra(MediaStore.EXTRA_OUTPUT,
			            Uri.fromFile(photo));
			    imageUri = Uri.fromFile(photo);
			    startActivityForResult(intent, TAKE_PICTURE);

				// handleSmallCameraPhoto(cameraIntent);
			} else {
				Toast.makeText(getApplicationContext(), NO_CAMERA_ERROR,
						Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.send_button:
			openbaas.uploadImage(Environment.getExternalStorageDirectory() + File.separator + "Pic.jpg");
			break;
		}
		

	}

	// Bundle extras = data.getExtras();
	// // Check if the result includes a thumbnail Bitmap
	// Toast.makeText(getApplicationContext(), "thumbnail",
	// Toast.LENGTH_LONG).show();
	// img.setImageBitmap((Bitmap) extras.get("data"));
	// do something with full img
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	    switch (requestCode) {
	    case 1:
	        if (resultCode == Activity.RESULT_OK) {
	            Uri selectedImage = imageUri;
	            getContentResolver().notifyChange(selectedImage, null);
	            ImageView imageView = (ImageView) findViewById(R.id.imageView1);
	            ContentResolver cr = getContentResolver();
	            Bitmap bitmap;
	            try {
	                 bitmap = android.provider.MediaStore.Images.Media
	                 .getBitmap(cr, selectedImage);

	                imageView.setImageBitmap(bitmap);
	                Toast.makeText(this, selectedImage.toString(),
	                        Toast.LENGTH_LONG).show();
	            } catch (Exception e) {
	                Toast.makeText(this, "Failed to load", Toast.LENGTH_SHORT)
	                        .show();
	                Log.e("Camera", e.toString());
	            }
	        }
	    }
		
	}
}
