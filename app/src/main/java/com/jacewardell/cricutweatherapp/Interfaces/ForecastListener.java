package com.jacewardell.cricutweatherapp.Interfaces;

import com.jacewardell.cricutweatherapp.MainActivity;
import com.jacewardell.cricutweatherapp.Models.Forecast;
import com.jacewardell.cricutweatherapp.ViewHolders.ForecastViewHolder;

/**
 * Listener for passing the touch even from {@linkplain ForecastViewHolder} to {@linkplain
 * MainActivity}
 * <p/>
 * Created by Jace Wardell on 4/27/17.
 */

public interface ForecastListener {
	void onForecastClicked(Forecast forecast);
}
