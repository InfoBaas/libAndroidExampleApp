package com.example.infosistema;

import java.util.ArrayList;
import java.util.List;

import plumbers.RowItem;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class SeeAllPlumbersActivity extends Activity implements OnItemClickListener  {
	public static final String[] titles = new String[] { "Miguel",
			"João", "Tiago", "Tânia" };

	public static final String[] descriptions = new String[] {
			"Trabalho barato e material barato",
			"Trabalho rápido e de qualidade", "Qualidade acima de tudo",
			"Vários anos de experiência" };

	public static final Integer[] images = { R.drawable.miguel,
			R.drawable.joao, R.drawable.person4, R.drawable.person_female };

	ListView listView;
	List<RowItem> rowItems;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.see_all_plumbers_activity);

		rowItems = new ArrayList<RowItem>();
		for (int i = 0; i < titles.length; i++) {
			RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
			rowItems.add(item);
		}

		listView = (ListView) findViewById(R.id.plumbersList);
		CustomListViewAdapter adapter = new CustomListViewAdapter(this,
				R.layout.list_plumber, rowItems);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast toast = Toast.makeText(getApplicationContext(), "Item "
				+ (position + 1) + ": " + rowItems.get(position),
				Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.show();
	}

}
