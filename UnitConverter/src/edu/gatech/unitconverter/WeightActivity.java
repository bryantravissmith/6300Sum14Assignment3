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

public class WeightActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight);
	}
	
	public void handleWeightClick(View view){
		boolean checked = ((RadioButton) view).isChecked();
		
		EditText text = (EditText) findViewById(R.id.weightEditText1);
		String txt = text.getText().toString();
		double weight;
		if(txt == null){
			weight = Double.parseDouble(txt);
		} else {
			weight = 0.0;
		}

		
		switch(view.getId()){
		case R.id.radio0:
			if(checked)
				text.setText(poundToKg(weight));
			break;
			
		case R.id.radio1:
			if(checked)
				text.setText(kgToPound(weight));
			break;
		}
				
	}
	
	public String kgToPound(double weight){
		return String.valueOf(weight*2.20462);
	}
	
	public String poundToKg(double weight){
		return String.valueOf(weight/2.20462);
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
