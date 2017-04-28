package com.jacewardell.cricutweatherapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jacewardell.cricutweatherapp.ImageResUtil;
import com.jacewardell.cricutweatherapp.Models.Forecast;
import com.jacewardell.cricutweatherapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForecastDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForecastDetailFragment extends AppCompatDialogFragment {
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";

	private Forecast forecast;

	public ForecastDetailFragment() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @return A new instance of fragment ForecastDetailFragment.
	 */
	public static ForecastDetailFragment newInstance(Forecast forecast) {
		ForecastDetailFragment fragment = new ForecastDetailFragment();
		Bundle args = new Bundle();
		args.putSerializable(ARG_PARAM1, forecast);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			forecast = (Forecast) getArguments().getSerializable(ARG_PARAM1);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_forecast_detail, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		TextView forecastDetailDay = (TextView) view.findViewById(R.id.forecast_detail_day);
		TextView forecastDetailDate = (TextView) view.findViewById(R.id.forecast_detail_date);
		TextView forecastDetailHigh = (TextView) view.findViewById(R.id.forecast_detail_high);
		TextView forecastDetailLow = (TextView) view.findViewById(R.id.forecast_detail_low);
		ImageView forecastDetailCondition =
				(ImageView) view.findViewById(R.id.forecast_detail_condition);

		if(forecast != null) {
			forecastDetailDay.setText(forecast.getDay());
			forecastDetailDate.setText(forecast.getDate());
			forecastDetailHigh.setText(forecast.getHigh());
			forecastDetailLow.setText(forecast.getLow());
			forecastDetailCondition.setImageResource(ImageResUtil.getConditionResource(forecast.getCode()));
		}

	}
}
