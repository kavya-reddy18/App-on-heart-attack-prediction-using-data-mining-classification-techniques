package com.example.heartattack_prediction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.res.AssetManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Entrydata extends Activity {
	Filewrite csv;
	StringBuffer filePath;
	File file;
	@SuppressLint("SdCardPath")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entrydata);
		Button b1=(Button)findViewById(R.id.button1);
		final EditText e1=(EditText)findViewById(R.id.editText1);
		final EditText e2=(EditText)findViewById(R.id.editText2);
		final EditText e3=(EditText)findViewById(R.id.editText3);
		final EditText e4=(EditText)findViewById(R.id.editText4);
		final EditText e5=(EditText)findViewById(R.id.editText5);
		final EditText e6=(EditText)findViewById(R.id.editText6);
		final EditText e7=(EditText)findViewById(R.id.editText7);
		final EditText e8=(EditText)findViewById(R.id.editText8);
		final EditText e9=(EditText)findViewById(R.id.editText9);
		final EditText e10=(EditText)findViewById(R.id.editText10);
		final EditText e11=(EditText)findViewById(R.id.editText11);
		final EditText e12=(EditText)findViewById(R.id.editText12);
		final EditText e13=(EditText)findViewById(R.id.editText13);
		
		
		 filePath = new StringBuffer();
		
		 filePath.append("/sdcard/ee.csv");
		    file = new File(filePath.toString());

		    csv = new Filewrite(file);
		b1.setOnClickListener(new OnClickListener(){
			@SuppressLint("SimpleDateFormat")
			public void onClick(View v)
			{
				
				csv.writeHeader(e1.getText().toString());
				csv.writeHeader1(e2.getText().toString());
        		csv.writeHeader1(e3.getText().toString());
        		csv.writeHeader1(e4.getText().toString());
        		csv.writeHeader1(e5.getText().toString());
        		csv.writeHeader1(e6.getText().toString());
        		csv.writeHeader1(e7.getText().toString());
        		csv.writeHeader1(e8.getText().toString());
        		csv.writeHeader1(e9.getText().toString());
        		csv.writeHeader1(e10.getText().toString());
        		csv.writeHeader1(e11.getText().toString());
        		csv.writeHeader1(e12.getText().toString());
        		
        		csv.writeHeader2(e13.getText().toString());
		        Classifier classifier = null;
		        try
		        {
		      
		       // ("read training arff");
		        	AssetManager assetManager = getAssets(); 
		        	InputStream input = assetManager.open("heartattackfinal.csv.arff");
		        	Instances train = new Instances(new BufferedReader(new InputStreamReader(input, "UTF-8")));
		        	train.setClassIndex(13);//in my case the class was the first attribute thus zero otherwise it's the number of attributes -1
	       
		        	
		        	Instances unlabeled = new Instances(new BufferedReader(new FileReader("/sdcard/ee.csv")));
		        	unlabeled.setClassIndex(13);
	          
		        
	        // training using a collection of classifiers (NaiveBayes, SMO (AKA SVM), KNN and Decision trees.)

		        	StringBuffer buffer =new StringBuffer();
	            classifier = new NaiveBayes();

	            //System.out.println("==========================================================================");
	       
				Evaluation eval = new Evaluation(train);
		        //perform 10 fold cross validation
		        eval.crossValidateModel(classifier, train, 10, new Random(1));
		        String output = eval.toSummaryString();
		       // buffer.append(output);
		
		        String classDetails = eval.toClassDetailsString();
		       // buffer.append(classDetails);
		
		        classifier.buildClassifier(train);
	        

	        
				
		        // label instances (use the trained classifier to classify new unseen instances)
		        for (int i = 0; i < (unlabeled).numInstances(); i++) {
		            double clsLabel = classifier.classifyInstance(unlabeled.instance(i));
		            buffer.append(clsLabel + " -> " + unlabeled.classAttribute().value((int) clsLabel));
		            if(clsLabel==1.0)
		            {
		            	buffer.append("\n");
		            	buffer.append("as per presense or absense of risk factors for heart attack you are at HIGH RISK of having Heart Attack ");
		            }
		            else
		            {
		            	buffer.append("\n");
		            	buffer.append("as per presense or absense of risk factors for heart attack you are at LOW RISK of having Heart Attack ");
		            }
		        }

        	
        			//buffer.append(classifier);
        		
        		showMessage("Result",buffer.toString());
	          
        		
	           file.delete();
		        }
		        catch(Exception e){
		        	Toast.makeText(getApplicationContext(),"execptn"+e,Toast.LENGTH_SHORT).show();
		        }
				
			}
		});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.entrydata, menu);
		return true;
	}
	 public void showMessage(String title, String message)
	    {
	    	Builder builder=new Builder(this);
	    	builder.setCancelable(true);
	    	builder.setTitle(title);
	    	builder.setMessage(message);
	    	builder.show();
	    }

}

