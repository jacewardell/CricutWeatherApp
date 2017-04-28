package com.jacewardell.cricutweatherapp.Models;

/**
 * <p/>
 * Created by Jace Wardell on 4/27/17.
 */
public class Astronomy
{
	private String sunset;

	private String sunrise;

	public String getSunset ()
	{
		return sunset;
	}

	public void setSunset (String sunset)
	{
		this.sunset = sunset;
	}

	public String getSunrise ()
	{
		return sunrise;
	}

	public void setSunrise (String sunrise)
	{
		this.sunrise = sunrise;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [sunset = "+sunset+", sunrise = "+sunrise+"]";
	}
}