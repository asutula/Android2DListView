package com.asutula.android2dlistview.scroll;

import android.widget.HorizontalScrollView;

public class HorizontalScrollEvent {
	
	private HorizontalScrollView scrollView;
	private int l;
	private int t;
	private int oldl;
	private int oldt;
	
	public HorizontalScrollEvent(HorizontalScrollView scrollView, int l, int t, int oldl, int oldt) {
		this.scrollView = scrollView;
		this.l = l;
		this.t = t;
		this.oldl = oldl;
		this.oldt = oldt;
	}

	public HorizontalScrollView getScrollView() {
		return scrollView;
	}

	public int getL() {
		return l;
	}

	public int getT() {
		return t;
	}

	public int getOldl() {
		return oldl;
	}

	public int getOldt() {
		return oldt;
	}
}
