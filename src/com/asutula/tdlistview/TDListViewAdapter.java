package com.asutula.tdlistview;

import android.view.View;

public interface TDListViewAdapter {
	
	public int numberOfRows();
	
	public int numberOfColumns();
	
	// TODO: Make this take a convert view and parent view
	public View viewForRowAndColumn(int row, int column);

    public int heightForRow(int row);

}
