package com.right.miracle;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class lista extends ListActivity {
	private ListView lv;

	private String title[] = { "Cup Cake", "Donut", "Eclair", "Froyo",
			"Ginger Bread", "Honey Comb", "Icecream Sandwich", "Jelly Bean" };

	private String desc[] = { "version: 1.5", "version: 1.6",
			"version: 2.0 & 2.1", "version: 2.2", "version: 2.3",
			"version: 3.0", "version: 4.0", "version: 4.1" };

	private int thumb[] = { R.drawable.cupcake, R.drawable.donut,
			R.drawable.eclair, R.drawable.froyo, R.drawable.gingerbread,
			R.drawable.honeycomb, R.drawable.icecreamsandwich,
			R.drawable.jellybean, };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listas);

		// initialize the variables:
		lv = (ListView) findViewById(R.id.listView);

		lv.setAdapter(new VersionAdapter(this));

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				int pos = arg2;

				LayoutInflater layoutInflator = getLayoutInflater();

				View layout = layoutInflator.inflate(R.layout.custom_toast,
						(ViewGroup) findViewById(R.id.toast_layout_root));

				ImageView iv = (ImageView) layout.findViewById(R.id.toast_iv);
				TextView tv = (TextView) layout.findViewById(R.id.toast_tv);

				iv.setBackgroundResource(thumb[pos]);
				tv.setText(title[pos]);

				Toast toast = new Toast(getApplicationContext());
				toast.setView(layout);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
			}
		});

	}

	class VersionAdapter extends BaseAdapter {

		private LayoutInflater layoutInflater;

		public VersionAdapter(lista lista) {
			// TODO Auto-generated constructor stub
			layoutInflater = (LayoutInflater) lista
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return title.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			View listItem = convertView;
			int pos = position;
			if (listItem == null) {
				listItem = layoutInflater.inflate(R.layout.list_item, null);
			}

			// Initialize the views in the layout
			ImageView iv = (ImageView) listItem.findViewById(R.id.thumb);
			TextView tvTitle = (TextView) listItem.findViewById(R.id.title);
			TextView tvDesc = (TextView) listItem.findViewById(R.id.desc);

			// set the views in the layout
			iv.setBackgroundResource(thumb[pos]);
			tvTitle.setText(title[pos]);
			tvDesc.setText(desc[pos]);

			return listItem;
		}

	}

}