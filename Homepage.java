package com.example.heartattack_prediction;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Homepage extends Activity {
Button reg,login;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_homepage);
		reg=(Button)findViewById(R.id.button1);
		login=(Button)findViewById(R.id.button2);
		reg.setOnClickListener(new OnClickListener(){
			public void onClick(View v)
			{
				Intent i=new Intent(Homepage.this,Registration.class);
				startActivity(i);
			}
		});
		login.setOnClickListener(new OnClickListener(){
			public void onClick(View v)
			{
				Intent i=new Intent(Homepage.this,Login1.class);
				startActivity(i);
			}
		});
	}

}