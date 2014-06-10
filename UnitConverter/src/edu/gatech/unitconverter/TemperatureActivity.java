package edu.gatech.unitconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class TemperatureActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_temperature);
	}
	
	public void handleTemperatureClick(View view){
		boolean checked = ((RadioButton) view).isChecked();
		
		EditText text = (EditText) findViewById(R.id.temperatureEditText1);
		String txt = text.getText().toString();
		double temperature;
		if(txt == null){
			temperature = Double.parseDouble(txt);
		} else {
			temperature = 0.0;
		}

		
		switch(view.getId()){
		case R.id.radio0:
			if(checked)
				text.setText(celsiusToFahrenheit(temperature));
			break;
			
		case R.id.radio1:
			if(checked)
				text.setText(fahrenheitToCelsius(temperature));
			break;
		}
				
	}
	
	public String fahrenheitToCelsius(double temperature){
		return String.valueOf(5*(temperature-32)/9);
	}
	
	public String celsiusToFahrenheit(double temperature){
		return String.valueOf(9*temperature/5+32);
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
