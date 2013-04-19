package com.asutula.tdlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class TDListView extends ViewGroup {
	
	private ListView _listView;
	private TDListViewAdapter _tdTdapter;

	public TDListView(Context context) {
		super(context);
		initListView(context, null, null);
	}

	public TDListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initListView(context, attrs, defStyle);
	}
	
	public TDListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initListView(context, attrs, null);
	}

	private void initListView(Context context, AttributeSet attrs, Integer defStyle) {
		_listView = new ListView(context, attrs);
		
		// TODO: These are fine for now, but we need a good way to
		// provide defaults and allow the user to override from XML
		_listView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		this.addView(_listView);
	}

	public TDListViewAdapter getTdTdapter() {
		return _tdTdapter;
	}

	public void setTdTdapter(TDListViewAdapter tdTdapter) {
		_tdTdapter = tdTdapter;
		_listView.setAdapter(new MyAdapter());
		this.requestLayout();
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		
	}
	
	private class MyAdapter extends BaseAdapter implements ListAdapter {

		@Override
		public int getCount() {
			return _tdTdapter.numberOfRows();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}
		
		@Override
		public int getViewTypeCount() {
			return 1;
		}
		
		@Override
		public int getItemViewType(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO: Make it recycle
			ListView horizontalListView = new ListView(getContext());
			horizontalListView.setAdapter(new MyHorizontalListAdapter(position));
			horizontalListView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			return horizontalListView;
		}

		private class MyHorizontalListAdapter extends BaseAdapter implements ListAdapter {

			private int _row;
			
			public MyHorizontalListAdapter(int row) {
				_row = row;
			}
			
			@Override
			public int getCount() {
				return _tdTdapter.numberOfColumns();
			}

			@Override
			public Object getItem(int arg0) {
				return null;
			}

			@Override
			public long getItemId(int arg0) {
				return arg0;
			}
			
			@Override
			public int getViewTypeCount() {
				return 1;
			}
			
			@Override
			public int getItemViewType(int position) {
				return 0;
			}

			@Override
			public View getView(int column, View convertView, ViewGroup parent) {
				return _tdTdapter.viewForRowAndColumn(_row, column);
			}
			
		}
	}
}
