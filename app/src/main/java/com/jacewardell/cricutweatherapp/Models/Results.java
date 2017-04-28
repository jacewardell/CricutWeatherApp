package com.jacewardell.cricutweatherapp.Models;

/**
 * <p/>
 * Created by Jace Wardell on 4/27/17.
 */
public class Results
{
	private Channel channel;

	public Channel getChannel ()
	{
		return channel;
	}

	public void setChannel (Channel channel)
	{
		this.channel = channel;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [channel = "+channel+"]";
	}
}