package edu.gatech.unitconverter;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

public class TemperatureActivity extends Fragment implements OnClickListener{
	
	private EditText text;
	private boolean isCelsius = false;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_temperature, container, false);
        text = (EditText) rootView.findViewById(R.id.temperatureEditText1);
	 	RadioButton button0 = (RadioButton) rootView.findViewById(R.id.radio0);
	 	RadioButton button1 = (RadioButton) rootView.findViewById(R.id.radio1);
        
	 	button0.setOnClickListener(this);
	 	button1.setOnClickListener(this);
        	   
	 	return rootView;
    }

	public void handleTemperatureClick(View view){
		boolean checked = ((RadioButton) view).isChecked();
		
		String txt = text.getText().toString();
		double temperature;
		if(txt.equals("")){
			temperature = 0.0;
		} else {
			temperature = Double.parseDouble(txt);
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
		if (isCelsius){
			double temp = temperature - 32;
			temp /= 1.8;
			isCelsius = !isCelsius;
			return String.valueOf(temp);
		} else {
			return String.valueOf(temperature);
		}
	}
	
	public String celsiusToFahrenheit(double temperature){
		if (!isCelsius){
			double temp = 9*temperature/5;
			temp += 32;
			isCelsius = !isCelsius;
			return String.valueOf(temp);
		} else {
			return String.valueOf(temperature);
		}
	}
	
	@Override
	public void onClick(View v) {
		handleTemperatureClick(v);
	}
	
}
