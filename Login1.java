package com.example.heartattack_prediction;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login1 extends Activity {
	Button submit;
	EditText id,pwd;
	SQLiteDatabase d1;
	String s;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        id=(EditText) findViewById(R.id.editText1);
        pwd=(EditText) findViewById(R.id.editText2);
        s=id.getText().toString();
        submit=(Button) findViewById(R.id.button1);
        

        d1=openOrCreateDatabase("HPS",  Context.MODE_PRIVATE, null);
        
        submit.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		if(id.getText().toString().trim().length()==0||pwd.getText().toString().trim().length()==0)
        		{
        			Toast.makeText(Login1.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
        			return;
        		}
        		
        		Cursor c1=d1.rawQuery("select * from reg1 where id='"+id.getText()+"' and pwd='"+pwd.getText()+"'", null);
        		if(c1.moveToFirst())
        		{

        			Toast.makeText(Login1.this,"Welcome",Toast.LENGTH_SHORT).show();
        			startActivity(new Intent(Login1.this,Instructions.class));
        			return;
        		}
        		
        		
        		else
        		{
        	
        		Toast.makeText(Login1.this,"Invalid Details",Toast.LENGTH_SHORT).show();
        		}
        	}
        });
    }
    


    
}


