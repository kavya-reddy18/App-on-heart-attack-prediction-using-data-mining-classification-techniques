package com.example.heartattack_prediction;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;


public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    

  
    new Timer (). schedule(new TimerTask() {

    public void run()
    {
    	Intent i =new Intent(Splash.this,Homepage.class);
    	 startActivity(i);
    }
},3000);
}
}
