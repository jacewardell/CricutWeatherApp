package com.jacewardell.cricutweatherapp;

/**
 * Determines what image resource to get based on the Yahoo weather code
 * <p/>
 * Created by Jace Wardell on 4/27/17.
 */

public class ImageResUtil {
	public static int getConditionResource(String code) {
		try {
			int codeNum = Integer.parseInt(code);
			switch (codeNum) {
				case 3:
					return R.drawable.ic_weather_lightning;
				case 4:
					return R.drawable.ic_weather_lightning;
				case 5:
					return R.drawable.ic_weather_snowy_rainy;
				case 6:
				case 7:
					return R.drawable.ic_weather_rainy;
				case 10:
					return R.drawable.ic_weather_snowy_rainy;
				case 11:
				case 12:
					return R.drawable.ic_weather_rainy;
				case 13:
				case 14:
				case 15:
				case 16:
					return R.drawable.ic_weather_snowy;
				case 17:
					return R.drawable.ic_weather_hail;
				case 20:
					return R.drawable.ic_weather_fog;
				case 24:
					return R.drawable.ic_weather_windy;
				case 26:
				case 27:
				case 28:
					return R.drawable.ic_weather_cloudy;
				case 29:
				case 30:
					return R.drawable.ic_weather_partlycloudy;
				case 32:
				case 33:
				case 34:
					return R.drawable.ic_weather_sunny;
				case 35:
					return R.drawable.ic_weather_hail;
				case 37:
				case 38:
				case 39:
					return R.drawable.ic_weather_lightning;
				case 40:
				case 41:
				case 42:
				case 43:
					return R.drawable.ic_weather_snowy;
				case 44:
					return R.drawable.ic_weather_partlycloudy;
				case 45:
					return R.drawable.ic_weather_lightning_rainy;
				case 46:
					return R.drawable.ic_weather_rainy;
				case 47:
					return R.drawable.ic_weather_lightning_rainy;
				case 3200:
				case 0:
					// tornado
				case 1:
					// tropical storm
				case 2:
					// hurricane
				case 8:
					// freezing drizzle
				case 9:
					// drizzle
				case 18:
					// sleet
				case 19:
					// dust
				case 21:
					// haze
				case 22:
					// smoky
				case 23:
					// blustery
				case 25:
					// cold
				case 31:
				case 36:
					// hot
				default:
					return -1;
			}
		} catch (NumberFormatException e) {
			return -1;
		}
	}
}
