package com.asutula.tdlistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VerticalListAdapter extends BaseAdapter {
	
	private Context _context;
	
	public static class HeaderAndDataRowViewHolder {
		public TextView rowHeader;
		public LinearLayout rowContentView;
		public String teamName;
	}
	
	public VerticalListAdapter(Context context) {
		_context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
