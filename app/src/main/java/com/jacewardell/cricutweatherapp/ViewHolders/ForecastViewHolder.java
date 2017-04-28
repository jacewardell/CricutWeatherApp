package com.jacewardell.cricutweatherapp.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jacewardell.cricutweatherapp.ImageResUtil;
import com.jacewardell.cricutweatherapp.Models.Forecast;
import com.jacewardell.cricutweatherapp.R;

/**
 * ViewHolder for displaying the 10 day forcast in a RecyclerView
 * <p/>
 * Created by Jace Wardell on 4/27/17.
 */

public class ForecastViewHolder extends RecyclerView.ViewHolder {
	private TextView forecastDay;
	private TextView forecastDate;
	private TextView forecastHigh;
	private TextView forecastLow;
	private ImageView forecastCondition;
	private Forecast data;

	public ForecastViewHolder(View itemView) {
		super(itemView);

		forecastDay = (TextView) itemView.findViewById(R.id.forecast_day);
		forecastDate = (TextView) itemView.findViewById(R.id.forecast_date);
		forecastHigh = (TextView) itemView.findViewById(R.id.forecast_high);
		forecastLow = (TextView) itemView.findViewById(R.id.forecast_low);
		forecastCondition = (ImageView) itemView.findViewById(R.id.forecast_condition);
	}

	public void setData(Forecast data) {
		this.data = data;

		forecastDay.setText(data.getDay());
		forecastDate.setText(data.getDate());
		forecastHigh.setText(data.getHigh());
		forecastLow.setText(data.getLow());

		int conditionResource = ImageResUtil.getConditionResource(data.getCode());
		forecastCondition.setVisibility(conditionResource == -1 ? View.INVISIBLE : View.VISIBLE);
		if(conditionResource != -1) {
			forecastCondition.setImageResource(conditionResource);
		}
	}
}
