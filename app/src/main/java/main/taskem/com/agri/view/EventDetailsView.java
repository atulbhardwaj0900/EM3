package main.taskem.com.agri.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

import org.json.JSONObject;

import main.taskem.com.agri.adapter.JsonArrayAdapter.OnRecyclerItemClick;


/**
 * Created by atul.bhardwaj on 30/05/16.
 */
public class EventDetailsView extends CardView implements OnRecyclerItemClick<JSONObject> {
	private Context mContext;

	public EventDetailsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		init();
	}

	public EventDetailsView(Context context) {
		super(context);
		mContext = context;
		init();
	}

	public void updateView(JSONObject jsonObject) {
		if (jsonObject == null) {
			this.setVisibility(GONE);
		}

	}

	private void init() {
//		RecyclerView recycleView = (RecyclerView) findViewById(R.id.recycleView);
//		LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
//		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//		recycleView.setLayoutManager(layoutManager);
		//MainHorizontalAdapter mNoteListAdapter = new MainHorizontalAdapter(this);
		//recycleView.setAdapter(mNoteListAdapter);
	}

	@Override
	public void onRecyclerItemClick(int position, JSONObject object) {

	}
}
