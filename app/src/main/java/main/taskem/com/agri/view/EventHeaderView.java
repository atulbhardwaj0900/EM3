package main.taskem.com.agri.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import main.taskem.com.agri.R;

/**
 * Created by atul.bhardwaj on 30/05/16.
 */
public class EventHeaderView  extends RelativeLayout {
    View view ;

    LayoutInflater mInflater;

    public EventHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init();


    }
    public EventHeaderView(Context context, AttributeSet attrs, int defaultStyle){
        super(context, attrs, defaultStyle);
        mInflater = LayoutInflater.from(context);
        init();
    }

 public  void setHeading(String heading){
        TextView headingView = (TextView) view.findViewById(R.id.eventHeading);
        headingView.setText(heading);
    }
    public  void setStartDate(String heading){
        TextView headingView = (TextView) view.findViewById(R.id.startDate);
        headingView.setText(heading);
    }
    public  void setEndDate(String heading){
        TextView headingView = (TextView) view.findViewById(R.id.endDate);
        headingView.setText(heading);
    }
    public  void setAttendingStatus(String status){
        TextView textView= null;
        switch (status){
            case "y":
            case "Y": textView= (TextView) view.findViewById(R.id.yes);
                break;
            case "n":
            case "N": textView= (TextView) view.findViewById(R.id.no);
                break;
            case "m":
            case "M": textView= (TextView) view.findViewById(R.id.maybe);
                break;
        }
        if(textView!=null){
            textView.setTextColor(Color.BLUE);
        }
    }
    public void init()
    {
        view =  mInflater.inflate(R.layout.event_header_view, this, true);
    }
}
