package main.taskem.com.agri.view;

/**
 * Created by atul.bhardwaj on 30/05/16.
 */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class AspectRatioImageView extends EventImageView {

	public AspectRatioImageView(Context context) {
		super(context);
	}

	public AspectRatioImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AspectRatioImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		Drawable drawable = getDrawable();
		if (drawable != null) {
			int width = MeasureSpec.getSize(widthMeasureSpec);
			int diw = drawable.getIntrinsicWidth();
			if (diw > 0) {
				int height = width * drawable.getIntrinsicHeight() / diw;
				setMeasuredDimension(width, height);
			} else {
				super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			}
		} else {
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}
	}
}

