package edu.gatech.unitconverter;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

public class WeightActivity extends Fragment implements View.OnClickListener {

	private EditText text;
	private boolean isPounds = false;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_weight, container, false);
        text = (EditText) rootView.findViewById(R.id.weightEditText1);
	 	RadioButton button0 = (RadioButton) rootView.findViewById(R.id.radio0);
	 	RadioButton button1 = (RadioButton) rootView.findViewById(R.id.radio1);
        
	 	button0.setOnClickListener(this);
	 	button1.setOnClickListener(this);
        	   
	 	return rootView;
    }

	public void handleWeightClick(View view){
		boolean checked = ((RadioButton) view).isChecked();
		
		String txt = text.getText().toString();
		double weight;
		if(txt.equals("")){
			weight = 0.0;
		} else {
			weight = Double.parseDouble(txt);
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
		if( isPounds ){
			double w = weight*2.20462;
			isPounds = !isPounds;
			return String.valueOf(w);
		} else {
			return String.valueOf(weight);
		}
	}
	
	public String poundToKg(double weight){
		if (!isPounds){
			double w = weight/2.20462;
			isPounds = !isPounds;
			return String.valueOf(w);
		} else {
			return String.valueOf(weight);
		}
	}
	
	@Override
	public void onClick(View v) {
		handleWeightClick(v);
	}
}
