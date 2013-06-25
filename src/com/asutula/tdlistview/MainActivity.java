package com.asutula.tdlistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TDListView _listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		_listView = (TDListView)findViewById(R.id.list);
        _listView.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
		_listView.setTdTdapter(new TDListViewAdapter() {
			
			String[][] data = {
                    {"one", "two", "three", "four", "five", "six", "seven", "eight"},
                    {"one", "two", "three", "four", "five", "six", "seven", "eight"},
                    {"one", "two", "three", "four", "five", "six", "seven", "eight"},
                    {"one", "two", "three", "four", "five", "six", "seven", "eight"},
                    {"one", "two", "three", "four", "five", "six", "seven", "eight"},
                    {"one", "two", "three", "four", "five", "six", "seven", "eight"},
                    {"one", "two", "three", "four", "five", "six", "seven", "eight"}
			};
			
			@Override
			public View viewForRowAndColumn(int row, int column) {
				TextView view = new TextView(getBaseContext());
				view.setLayoutParams(new AbsListView.LayoutParams(200, 100));
                view.setMinimumWidth(200);
				view.setText(data[row][column]);
				return view;
			}

			@Override
			public int numberOfRows() {
				// TODO Auto-generated method stub
				return data.length;
			}

			@Override
			public int numberOfColumns() {
				// TODO Auto-generated method stub
				return data[0].length;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
