package edu.gatech.unitconverter;



import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

public class DistanceActivity extends Fragment implements View.OnClickListener{

	private EditText text;
	private boolean isKm = false;
	
	public DistanceActivity(){
		
	}
	 @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
	 	View rootView = inflater.inflate(R.layout.activity_distance, container, false);
	 	text = (EditText) rootView.findViewById(R.id.distanceEditText1);
	 	RadioButton button0 = (RadioButton) rootView.findViewById(R.id.radio0);
	 	RadioButton button1 = (RadioButton) rootView.findViewById(R.id.radio1);
        
	 	button0.setOnClickListener(this);
	 	button1.setOnClickListener(this);
        	   
	 	return rootView;
     }
	
	
	public void handleDistanceClick(View view){
		boolean checked = ((RadioButton) view).isChecked();

		String txt = text.getText().toString();
		Log.i("handleDistance",txt);
		double distance;
		if(txt.equals("")){
			distance = 0.0;
		} else {
			distance = Double.parseDouble(txt);
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
		if (isKm){
			isKm = !isKm;
			return String.valueOf(distance/1.6093);
		} else {
			return String.valueOf(distance);
		}
	}
	
	public String mileToKm(double distance){
		if (!isKm){
			isKm = !isKm;
			return String.valueOf(distance*1.6093);
		} else {
			return String.valueOf(distance);
		}
	}
	
	@Override
	public void onClick(View v) {
		handleDistanceClick(v);
	}
	
	
	
	
	
}
