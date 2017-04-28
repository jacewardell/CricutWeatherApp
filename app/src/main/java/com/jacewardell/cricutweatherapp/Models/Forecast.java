package com.jacewardell.cricutweatherapp.Models;

import java.io.Serializable;

/**
 * <p/>
 * Created by Jace Wardell on 4/27/17.
 */
public class Forecast implements Serializable {
	private String text;

	private String high;

	private String day;

	private String code;

	private String low;

	private String date;

	public String getText ()
	{
		return text;
	}

	public void setText (String text)
	{
		this.text = text;
	}

	public String getHigh ()
	{
		return high;
	}

	public void setHigh (String high)
	{
		this.high = high;
	}

	public String getDay ()
	{
		switch(day) {
			case "Sun":
				return "Sunday";
			case "Mon":
				return "Monday";
			case "Tue":
				return "Tuesday";
			case "Wed":
				return "Wednesday";
			case "Thu":
				return "Thursday";
			case "Fri":
				return "Friday";
			case "Sat":
				return "Saturday";
		}

		return day;
	}

	public void setDay (String day)
	{
		this.day = day;
	}

	public String getCode ()
	{
		return code;
	}

	public void setCode (String code)
	{
		this.code = code;
	}

	public String getLow ()
	{
		return low;
	}

	public void setLow (String low)
	{
		this.low = low;
	}

	public String getDate ()
	{
		return date;
	}

	public void setDate (String date)
	{
		this.date = date;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [text = "+text+", high = "+high+", day = "+day+", code = "+code+", low = "+low+", date = "+date+"]";
	}
}