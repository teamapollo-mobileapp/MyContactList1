package com.example.mycontactlist1;

import android.os.Bundle;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;
import com.example.mycontactlist1.R.color;


public class ContactSettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_settings);
		
		initSettings();
		initSortByClick();
		initSortOrderClick();
		initListButton();
		initMapButton();
		initSettingsButton();
		initColor();
		initBackgroundColor();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_settings, menu);
		return true;
	}

	private void initSettings() {
		String sortBy = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).getString("sortfield", "contactname");
		String sortOrder = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).getString("sortorder", "ASC");
		String background= getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).getString("background", "green");

		RadioButton rbName = (RadioButton) findViewById(R.id.radioName);
		RadioButton rbCity = (RadioButton) findViewById(R.id.radioCity);
		RadioButton rbBirthDay = (RadioButton) findViewById(R.id.radioBirthday);
		if (sortBy.equalsIgnoreCase("contactname")) {
			rbName.setChecked(true);
		}
		else if (sortBy.equalsIgnoreCase("city")) {
			rbCity.setChecked(true);
		}
		else {
			rbBirthDay.setChecked(true);
		}			

		RadioButton rbAscending = (RadioButton) findViewById(R.id.radioAscending);
		RadioButton rbDescending = (RadioButton) findViewById(R.id.radioDescending);
		if (sortOrder.equalsIgnoreCase("ASC")) {
			rbAscending.setChecked(true);
		}
		else {
			rbDescending.setChecked(true);
		}	
		
		RadioButton bRed = (RadioButton) findViewById(R.id.radioRed);
		RadioButton bGreen = (RadioButton) findViewById(R.id.radioGreen);
		RadioButton bYellow = (RadioButton) findViewById(R.id.radioYellow);
		
		if (background.equalsIgnoreCase("red")){
			bRed.setChecked(true);
		}
		else if(background.equalsIgnoreCase("green")){
			bGreen.setChecked(true);
		}
		else {
			bYellow.setChecked(true);
		}

		
	}
	
	
	
		
	
	private void initSortByClick() {
		RadioGroup rgSortBy = (RadioGroup) findViewById(R.id.radioGroup1);
		rgSortBy.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				RadioButton rbName = (RadioButton) findViewById(R.id.radioName);
				RadioButton rbCity = (RadioButton) findViewById(R.id.radioCity);
//				RadioButton rbBirthDay = (RadioButton) findViewById(R.id.radioBirthdate);
				if (rbName.isChecked()) {
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortfield", "contactname").commit();
				}
				else if (rbCity.isChecked()) {
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortfield", "city").commit();
				}
				else {
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortfield", "birthday").commit();
				}			
			}		
		});
	}

	private void initSortOrderClick() {
		RadioGroup rgSortOrder = (RadioGroup) findViewById(R.id.radioGroup2);
		rgSortOrder.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				RadioButton rbAscending = (RadioButton) findViewById(R.id.radioAscending);
//				RadioButton rbDescending = (RadioButton) findViewById(R.id.radioDescending);
				if (rbAscending.isChecked()) {
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortorder", "ASC").commit();
				}
				else {
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortorder", "DESC").commit();
				}			
			}		
		});
	}
	
	private void initBackgroundColor(){
		RadioGroup colorGroup = (RadioGroup) findViewById(R.id.radioGroup3);
		colorGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				RadioButton bRed = (RadioButton) findViewById(R.id.radioRed);
				RadioButton bGreen = (RadioButton) findViewById(R.id.radioGreen);
				RadioButton bYellow = (RadioButton) findViewById(R.id.radioYellow);
				ScrollView layout1 = (ScrollView)findViewById(R.id.scrollView1);
				if(bRed.isChecked()){
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("background", "red").commit();
					layout1.setBackgroundResource(R.color.red);
				}
				else if(bGreen.isChecked()){
					layout1.setBackgroundResource(R.color.green);
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("background", "green").commit();
				}
				else{
					layout1.setBackgroundResource(R.color.yellow);
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("background", "Yellow").commit();

				}			
			}		
		});
	}

	private void initColor(){
		RadioGroup rgChangeColor = (RadioGroup) findViewById(R.id.radioGroup3);
		//rgChangeColor.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			//@Override
		//	public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				RadioButton bRed = (RadioButton) findViewById(R.id.radioRed);
				RadioButton bGreen = (RadioButton) findViewById(R.id.radioGreen);
				ScrollView layout1 = (ScrollView)findViewById(R.id.scrollView1);
				
				if (bRed.isChecked()) {
					
					layout1.setBackgroundResource(R.color.red);
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("color", "Red").commit();
					
				}
				else if (bGreen.isChecked()) {
					layout1.setBackgroundResource(R.color.green);
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("color", "Green").commit();
					
				}
				else {
					layout1.setBackgroundResource(R.color.yellow);
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("color", "Yellow").commit();
					}
			//}
		//});
	}

	private void initListButton() {
        ImageButton list = (ImageButton) findViewById(R.id.imageButtonList);
        list.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
    			Intent intent = new Intent(ContactSettingsActivity.this, ContactListActivity.class);
    			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
   			startActivity(intent);
            }
        });
	}

	private void initSettingsButton() {
        ImageButton list = (ImageButton) findViewById(R.id.imageButtonSettings);
        list.setEnabled(false);
	}

	private void initMapButton() {
        ImageButton list = (ImageButton) findViewById(R.id.imageButtonMap);
        list.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		Intent intent = new Intent(ContactSettingsActivity.this, ContactMapActivity.class);
    			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		   		startActivity(intent);
            }
        });
	}

	
}
