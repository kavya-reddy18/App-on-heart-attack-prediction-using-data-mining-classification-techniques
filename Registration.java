package com.example.heartattack_prediction;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity {
	Button submit;
	EditText pn,id,pwd,email,no;
	SQLiteDatabase d1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        submit=(Button) findViewById(R.id.button1);
        pn=(EditText)findViewById(R.id.editText5);
        id=(EditText)findViewById(R.id.editText1);   
        pwd=(EditText)findViewById(R.id.editText2);
        email=(EditText)findViewById(R.id.editText3);
        no=(EditText)findViewById(R.id.editText4);
        d1=openOrCreateDatabase("HPS",  Context.MODE_PRIVATE, null);
        d1.execSQL("create table if not exists reg1(pn varchar,id varchar,pwd varchar,email varchar,no varchar );");
        submit.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		if(pn.getText().toString().trim().length()==0||id.getText().toString().trim().length()==0||pwd.getText().toString().trim().length()==0||email.getText().toString().trim().length()==0||no.getText().toString().trim().length()==0)
        		{
        			Toast.makeText(Registration.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
        			return;
        		}
        		else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
        		{
        			Toast.makeText(Registration.this," please enter valid email id", Toast.LENGTH_SHORT).show();
        			return;
        		}
        		else if(no.getText().toString().length()!=10)
        		{
        			Toast.makeText(Registration.this," please enter  10 digit mobile number", Toast.LENGTH_SHORT).show();
        			return;
        		}
        		d1.execSQL("insert into reg1 values('"+pn.getText()+"','"+id.getText()+"','"+pwd.getText()+"','"+email.getText()+"','"+no.getText()+"' );");	
        		Toast.makeText(Registration.this,"Registration Done",Toast.LENGTH_SHORT).show();
        		clr();
        		startActivity(new Intent(Registration.this,Homepage.class));
        		
        	}
        });
    }
    public void clr()
    {
    	pn.setText("");
    	id.setText("");
    	pwd.setText("");
    	email.setText("");
    	no.setText("");
    }


    
}