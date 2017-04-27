package com.jacewardell.cricutweatherapp.Models;

/**
 * TODO JavaDoc
 * <p/>
 * Created by Jace Wardell on 4/27/17.
 */
public class Atmosphere
{
	private String rising;

	private String humidity;

	private String pressure;

	private String visibility;

	public String getRising ()
	{
		return rising;
	}

	public void setRising (String rising)
	{
		this.rising = rising;
	}

	public String getHumidity ()
	{
		return humidity;
	}

	public void setHumidity (String humidity)
	{
		this.humidity = humidity;
	}

	public String getPressure ()
	{
		return pressure;
	}

	public void setPressure (String pressure)
	{
		this.pressure = pressure;
	}

	public String getVisibility ()
	{
		return visibility;
	}

	public void setVisibility (String visibility)
	{
		this.visibility = visibility;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [rising = "+rising+", humidity = "+humidity+", pressure = "+pressure+", visibility = "+visibility+"]";
	}
}