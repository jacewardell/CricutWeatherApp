package com.jacewardell.cricutweatherapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jacewardell.cricutweatherapp.Interfaces.ForecastListener;
import com.jacewardell.cricutweatherapp.MainActivity;
import com.jacewardell.cricutweatherapp.Models.Forecast;
import com.jacewardell.cricutweatherapp.R;
import com.jacewardell.cricutweatherapp.ViewHolders.ForecastViewHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";
	private RecyclerView recyclerView;
	private ForecastAdapter adapter;

	/**
	 * Returns a new instance of this fragment for the given section
	 * number.
	 */
	public static ForecastFragment newInstance(int sectionNumber) {
		ForecastFragment fragment = new ForecastFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		recyclerView = (RecyclerView) rootView.findViewById(R.id.forecast_recycler_view);
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		return rootView;
	}

	@Override
	public void onResume() {
		super.onResume();
		adapter = new ForecastAdapter((MainActivity) getActivity(), new ArrayList());
		recyclerView.setAdapter(adapter);
	}

	@Override
	public void onPause() {
		super.onPause();

	}

	public void setForecast(List<Forecast> forecast) {
		adapter.setForecast(forecast);
	}

	private class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder> {
		private final List<Forecast> forcast;
		private final ForecastListener listener;

		public ForecastAdapter(ForecastListener activity, List<Forecast> forecast) {
			this.listener = activity;
			this.forcast = forecast;
		}

		@Override
		public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View view = LayoutInflater.from(parent.getContext())
					.inflate(R.layout.viewholder_forecast_day, parent, false);
			return new ForecastViewHolder(view);
		}

		@Override
		public void onBindViewHolder(ForecastViewHolder holder, final int position) {
			holder.setData(forcast.get(position));
			holder.itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					listener.onForecastClicked(forcast.get(position));
				}
			});
		}

		@Override
		public int getItemCount() {
			return forcast.size();
		}

		public void setForecast(List<Forecast> forecast) {
			this.forcast.clear();
			this.forcast.addAll(forecast);
			notifyDataSetChanged();
		}
	}
}