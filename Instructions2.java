package com.example.heartattack_prediction;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Instructions2 extends Activity {
Button con;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instructions2);
		con=(Button)findViewById(R.id.button1);
		con.setOnClickListener(new OnClickListener(){
			public void onClick(View v)
			{
				Intent i=new Intent(Instructions2.this,Entrydata.class);
				startActivity(i);
			}
		});
		
	}

}

