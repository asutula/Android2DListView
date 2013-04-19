package com.asutula.android2dlistview.scroll;

import android.view.View;

public class TouchEvent {
	
	private View view;

	public TouchEvent(View view) {
		this.view = view;
	}

	public View getView() {
		return view;
	}
}
