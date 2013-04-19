package com.asutula.android2dlistview.scroll;

import com.squareup.otto.Subscribe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class EventDrivenScrollView extends HorizontalScrollView {
	
	private Boolean isBeingTouched = false;

	public EventDrivenScrollView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public EventDrivenScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public EventDrivenScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (ev.getAction() == MotionEvent.ACTION_DOWN || ev.getAction() == MotionEvent.ACTION_MOVE) {
			this.isBeingTouched = true;
			BusProvider.getInstance().post(new TouchEvent(this));
		}
		return super.onTouchEvent(ev);
	}
	
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		if (this.isBeingTouched) {
			BusProvider.getInstance().post(new HorizontalScrollEvent(this, l, t, oldl, oldt));
		}
		super.onScrollChanged(l, t, oldl, oldt);
	}
	
	@Subscribe
	public void handleTouchEvent(TouchEvent event) {
		if (event.getView() != this) {
			this.isBeingTouched = false;
		}
	}
	
	@Subscribe
	public void handleHorizontalScrollEvent(HorizontalScrollEvent event) {
		if (event.getScrollView() != this && !this.isBeingTouched) {
			//Log.d("BetterScrollView", "Someone else scrolled");
			this.scrollTo(event.getL(), event.getT());
		}
	}

}
