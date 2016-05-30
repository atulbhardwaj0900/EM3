package main.taskem.com.agri.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import main.taskem.com.agri.R;
import main.taskem.com.agri.adapter.JsonArrayAdapter.OnRecyclerItemClick;
import main.taskem.com.agri.adapter.MainHorizontalAdapter;
import main.taskem.com.agri.controller.Controller;
import main.taskem.com.agri.models.HeadContent;
import main.taskem.com.agri.view.EventHeaderView;
import main.taskem.com.agri.view.EventImageView;

/**
 * Created by atul.bhardwaj on 30/05/16.
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends BaseFragment implements OnRecyclerItemClick<JSONObject> {
	public static final String TAG_DETAIL_VIEW = "tag_detail_view";
	private final static String TAG_HEADER_VIEW = "tag_header_view";
	private MainHorizontalAdapter mNoteListAdapter;
	private LinearLayout mFragmentView;
	Controller controller ;

	public MainFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mFragmentView =
				(LinearLayout) inflater.inflate(R.layout.main_fragment_layout, container, false);

		return mFragmentView;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		controller  = new Controller(getContext());
		controller.loadContent();
		HeadContent headContent = controller.getHead();
		setBackgroundImg();
		addHeadView(headContent);
	}

	private void parseJson(String jsonString) {
		if (!TextUtils.isEmpty(jsonString)) {
			try {
				JSONObject jsonObject = new JSONObject(jsonString);
				if (jsonObject.has("name")) {
					setToolBar(jsonObject.optString("name"));
				}
				JSONObject list = jsonObject.optJSONObject("list");
				if(list != null) {
					addEventDetailsView(list);
				}
				setBackgroundImg();
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}

	}
	private void addEventDetailsView(JSONObject list) {
			View view = LayoutInflater.from(mBaseActivity).inflate(R.layout.event_details_view, null);
			mFragmentView.addView(view);
		String name = list.optString("name");
		String id = list.optString("_id");
		String picUrl = list.optString("picture_url");
		TextView address = (TextView) view.findViewById(R.id.address_txt);
		address.setText(name);
		EventImageView eventImageView = (EventImageView) view.findViewById(R.id.address_img_view);
		eventImageView.setImage(picUrl);
	}
	private void setToolBar(String title) {
		Toolbar toolbar = (Toolbar) mBaseActivity.findViewById(R.id.toolbar);
		toolbar.setTitle(title);
	}

	private void setBackgroundImg() {
		EventImageView eventImageView =
				(EventImageView) mBaseActivity.findViewById(R.id.backgroundImageView);
		eventImageView.setImage(
				"https://involvio-staging.s3.amazonaws.com/uploads/user/profile_image/57394330d04f908a1f000519/C501DD69-AC37-4F73-9909-BBB6911BCB97-40038-00004F36DED7FF20.png");
	}


	private void addHeaderView() {
		mFragmentView.addView(
				LayoutInflater.from(mBaseActivity).inflate(R.layout.event_details_view, null));
	}
	private void addHeadView(HeadContent headContent){
		EventHeaderView eventHeaderView = (EventHeaderView)mFragmentView.findViewById(R.id.headerView);
		eventHeaderView.setHeading(headContent.getHeading());
		eventHeaderView.setStartDate(headContent.getStartDate());
		eventHeaderView.setEndDate(headContent.getEndDate());
		eventHeaderView.setAttendingStatus(headContent.getAttending_status());
	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public void onRecyclerItemClick(int position, JSONObject object) {

	}

	public String loadJSONFromAsset() {
		String json = null;
		try {
			InputStream is = getActivity().getAssets().open("event.json");
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			json = new String(buffer, "UTF-8");
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return json;
	}
}
