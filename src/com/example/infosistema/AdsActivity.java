package com.example.infosistema;

import java.util.ArrayList;
import java.util.List;

import plumbers.RowItem;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AdsActivity extends Activity implements OnItemClickListener{
	public static final String[] titles = new String[] { "Trabalho rápido e bom",
		"50 Anos de serviço!", "Resolva Já!", "Orçamentos gratuitos!" };

public static final String[] descriptions = new String[] {
		"Trabalho barato e material barato",
		"Não perca tempo ligue-nos", "Qualidade acima de tudo",
		"No ramo desde 1950" };

public static final Integer[] images = { R.drawable.plumberpenguin,
		R.drawable.plumber, R.drawable.the_red_plumber, R.drawable.whites_logo_guy_only };

	ListView listView;
	List<RowItem> rowItems;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.see_all_ads_activity);

		rowItems = new ArrayList<RowItem>();
		for (int i = 0; i < titles.length; i++) {
			RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
			rowItems.add(item);
		}

		listView = (ListView) findViewById(R.id.adsList);
		CustomListViewAdapter adapter = new CustomListViewAdapter(this,
				R.layout.list_ad, rowItems);
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
