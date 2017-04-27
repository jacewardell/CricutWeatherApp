package com.jacewardell.cricutweatherapp;

import com.jacewardell.cricutweatherapp.Models.Weather;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * TODO JavaDoc
 * <p/>
 * Created by Jace Wardell on 4/27/17.
 */

public interface ApiService {
	String BASE_URL ="https://query.yahooapis.com/v1/public/";

	@GET("yql?q=select%20%2a%20from%20weather.forecast%20where%20woeid%20in%20%28select%20woeid%20from%20geo.places%281%29%20where%20text%3D\"nome%2c%20ak\"%29&format=json&env=store://datatables.org/alltableswithkeys")
	Call<Weather> getWeather();
}
