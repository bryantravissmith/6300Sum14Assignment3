package edu.gatech.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.app.ActionBar;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void sendMessage(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, DistanceActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.distanceTab:
	        	Intent distanceIntent = new Intent(this, DistanceActivity.class);
	    		startActivity(distanceIntent);
	            return true;
	        case R.id.temperatureTab:
	        	Intent temperatureIntent = new Intent(this, TemperatureActivity.class);
	    		startActivity(temperatureIntent);
	            return true;
	        case R.id.weightTab:
	        	Intent weightIntent = new Intent(this, DistanceActivity.class);
	    		startActivity(weightIntent);
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}
