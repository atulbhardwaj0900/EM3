package main.taskem.com.agri.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import main.taskem.com.agri.R;
import main.taskem.com.agri.adapter.JsonArrayAdapter.OnRecyclerItemClick;
import main.taskem.com.agri.adapter.MainHorizontalAdapter;
import main.taskem.com.agri.view.EventImageView;

/**
 * Created by atul.bhardwaj on 30/05/16.
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends BaseFragment implements OnRecyclerItemClick<JSONObject> {
	private MainHorizontalAdapter mNoteListAdapter;
	private LinearLayout mFragmentView;

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

		parseJson(loadJSONFromAsset());
	}

	private void parseJson(String jsonString) {
		if (!TextUtils.isEmpty(jsonString)) {
			try {
				JSONObject jsonObject = new JSONObject(jsonString);
				if (jsonObject.has("name")) {
					setToolBar(jsonObject.optString("name"));
				}
				addHeaderView();
				setBackgroundImg();
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}

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
