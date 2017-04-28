package com.jacewardell.cricutweatherapp.Models;

import java.util.List;

/**
 * Contains all the Yahoo weather data and provides accessors to get that information more easily
 * <p/>
 * Created by Jace Wardell on 4/27/17.
 */
public class Weather
{
	private Query query;

	public Query getQuery ()
	{
		return query;
	}

	public void setQuery (Query query)
	{
		this.query = query;
	}

	/**
	 * Accessor that provides the 10 day weather forecast
	 *
	 * @return 10 day forecast
	 */
	public List<Forecast> getForecast() {
		return query.getResults().getChannel().getItem().getForecast();
	}

	@Override
	public String toString()
	{
		return "ClassPojo [query = "+query+"]";
	}

	public String getLocationString() {
		Location location = query.getResults().getChannel().getLocation();
		return location.getCity() + ", " + location.getRegion() + ", " + location.getCountry();
	}
}
