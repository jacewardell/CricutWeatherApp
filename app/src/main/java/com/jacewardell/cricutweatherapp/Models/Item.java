package com.jacewardell.cricutweatherapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * <p/>
 * Created by Jace Wardell on 4/27/17.
 */
public class Item {
	private String pubDate;

	private String title;

	private List<Forecast> forecast;

	private Condition condition;

	private String description;

	private String link;

	@SerializedName("long")
	private String longNum;

	private String lat;

	public String getPubDate ()
	{
		return pubDate;
	}

	public void setPubDate (String pubDate)
	{
		this.pubDate = pubDate;
	}

	public String getTitle ()
	{
		return title;
	}

	public void setTitle (String title)
	{
		this.title = title;
	}

	public List<Forecast> getForecast ()
	{
		return forecast;
	}

	public void setForecast (List<Forecast> forecast)
	{
		this.forecast = forecast;
	}

	public Condition getCondition ()
	{
		return condition;
	}

	public void setCondition (Condition condition)
	{
		this.condition = condition;
	}

	public String getDescription ()
	{
		return description;
	}

	public void setDescription (String description)
	{
		this.description = description;
	}

	public String getLink ()
	{
		return link;
	}

	public void setLink (String link)
	{
		this.link = link;
	}

	public String getLong ()
	{
		return longNum;
	}

	public void setLong (String longNum)
	{
		this.longNum = longNum;
	}

	public String getLat ()
	{
		return lat;
	}

	public void setLat (String lat)
	{
		this.lat = lat;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [pubDate = "+pubDate+", title = "+title+", forecast = "+forecast+", condition = "+condition+", description = "+description+", link = "+link+", longNum = "+longNum+", lat = "+lat+"]";
	}
}