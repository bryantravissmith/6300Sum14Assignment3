package edu.gatech.unitconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class DistanceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_distance);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}
	
	public void handleDistanceClick(View view){
		boolean checked = ((RadioButton) view).isChecked();
		
		EditText text = (EditText) findViewById(R.id.distanceEditText1);
		String txt = text.getText().toString();
		double distance;
		if(txt != null){
			distance = Double.parseDouble(txt);
		} else {
			distance = 0.0;
		}

		
		switch(view.getId()){
		case R.id.radio0:
			if(checked)
				text.setText(kmToMile(distance));
			break;
			
		case R.id.radio1:
			if(checked)
				text.setText(mileToKm(distance));
			break;
		}
				
	}
	
	public String kmToMile(double distance){
		return String.valueOf(distance/1.6093);
	}
	
	public String mileToKm(double distance){
		return String.valueOf(distance*1.6093);
	}
	
	
	
	
	
}
