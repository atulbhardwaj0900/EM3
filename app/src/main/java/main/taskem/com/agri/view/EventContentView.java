package main.taskem.com.agri.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by atul.bhardwaj on 28/05/16.
 */
public class EventContentView extends RelativeLayout {
	private Context mContext;

	public EventContentView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		init();
	}

	public EventContentView(Context context) {
		super(context);
		mContext = context;
		init();
	}

	private void init() {
		CardView cardView = new CardView(mContext);
		LayoutParams params =
				new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.leftMargin = 20;
		params.rightMargin = 20;
		cardView.setLayoutParams(params);
		cardView.setRadius(20);
		// Set cardView content padding
		cardView.setContentPadding(15, 15, 15, 15);
		// Set a background color for CardView
		cardView.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));
		// Set the CardView maximum elevation
		cardView.setMaxCardElevation(15);
		// Set CardView elevation
		cardView.setCardElevation(20);
		addView(cardView);
		RelativeLayout relativeLayout = new RelativeLayout(mContext);
		cardView.addView(relativeLayout);
		ImageView imageView = new ImageView(mContext);
		imageView.setImageDrawable(
				mContext.getResources().getDrawable(R.drawable.ic_place_white_24dp));
		imageView.setId(R.id.app_bar);
		relativeLayout.addView(imageView);
		TextView textView = new TextView(mContext);
		textView.setText("dkjhqdjqld\n\n hsakjhs");
		cardView.addView(textView);
	}
}
