package main.taskem.com.agri.view;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class EventImageView extends ImageView{
    private Context context;
    public EventImageView(Context context) {
        super(context);
        this.context = context;
    }

    public EventImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public EventImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public EventImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }
    public void setImage(String url){
        Picasso.with(context).load(url).into(this);
    }
}
