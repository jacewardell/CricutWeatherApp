package com.jacewardell.cricutweatherapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;

import com.jacewardell.cricutweatherapp.Fragments.ForecastDetailFragment;
import com.jacewardell.cricutweatherapp.Fragments.ForecastFragment;
import com.jacewardell.cricutweatherapp.Interfaces.ForecastListener;
import com.jacewardell.cricutweatherapp.Models.Forecast;
import com.jacewardell.cricutweatherapp.Models.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ForecastListener {
	private static final String TAG = "MainActivity";

	private Weather weather;

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link FragmentPagerAdapter} derivative, which will keep every
	 * loaded fragment in memory. If this becomes too memory intensive, it
	 * may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	private SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	private ViewPager mViewPager;

	private ForecastFragment forecastFragment;

	private Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiService.BASE_URL)
			.addConverterFactory(GsonConverterFactory.create()).build();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.container);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
		tabLayout.setupWithViewPager(mViewPager);
	}

	@Override
	protected void onResume() {
		super.onResume();

		forecastFragment = ForecastFragment.newInstance(0);

		ApiService service = retrofit.create(ApiService.class);
		Call<Weather> weatherCall = service.getWeather();
		weatherCall.enqueue(new Callback<Weather>() {
			@Override
			public void onResponse(Call<Weather> call, Response<Weather> response) {
				weather = response.body();
				forecastFragment.setForecast(weather.getForecast());

				String locationString = weather.getLocationString();
				if(locationString != null && !locationString.isEmpty()) {
					getSupportActionBar().setTitle(locationString);
				}
				Log.d(TAG, "Weather: " + weather);
			}

			@Override
			public void onFailure(Call<Weather> call, Throwable t) {
				Log.d(TAG, "Failure!");
			}
		});
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	}

	@Override
	public void onForecastClicked(Forecast forecast) {
		ForecastDetailFragment forecastDetailFragment = ForecastDetailFragment.newInstance
				(forecast);
		forecastDetailFragment.show(getSupportFragmentManager(), "detail_fragment");
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return forecastFragment;
		}

		@Override
		public int getCount() {
			// Show 2 total pages.
			return 1;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
				case 0:
					return "FORECAST";
//				case 1:
//					return "CURRENT";
			}
			return null;
		}
	}
}
