package com.example.heartattack_prediction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Filewrite {
	public PrintWriter csvWriter;    
	public File file;

	public Filewrite(File file) {
	    this.file = file;

	}

	public void writeHeader(String data) {

	    try {
	        if (data != null) {

	            csvWriter = new PrintWriter(new FileWriter(file,true));
	            csvWriter.print("@relation abhi");
	            csvWriter.print('\n');
	            csvWriter.print('\n');
	            csvWriter.print("@attribute age numeric");
	    		csvWriter.print('\n');
	    		csvWriter.print("@attribute sex numeric");
	    		csvWriter.print('\n');
	    		csvWriter.print("@attribute cp numeric");
	    		csvWriter.print('\n');
	    		csvWriter.print("@attribute trestbps numeric");
	    		csvWriter.print('\n');
	    		csvWriter.print("@attribute chol numeric");
	    		csvWriter.print('\n');
	    		csvWriter.print("@attribute fbs numeric");
	    		csvWriter.print('\n');
	    		csvWriter.print("@attribute restecg numeric");
	    		csvWriter.print('\n');
	    		csvWriter.print("@attribute exang numeric");
	    		csvWriter.print('\n');
	    		csvWriter.print("@attribute oldpeak numeric");
	    		csvWriter.print('\n');
	    		csvWriter.print("@attribute slope numeric");
	    		csvWriter.print('\n');
	    		csvWriter.print("@attribute ca numeric");
	    		csvWriter.print('\n');
	    		csvWriter.print("@attribute thal numeric");
	    		csvWriter.print('\n');
	    		csvWriter.print("@attribute c numeric");
	    		csvWriter.print('\n');
	    		csvWriter.print("@attribute target {Safe,Positive}");
	    		csvWriter.print('\n');
	    		csvWriter.print('\n');
	    		csvWriter.print("@data");
	    		csvWriter.print('\n');
	            csvWriter.print(data);
	            csvWriter.print(",");
	            csvWriter.close();


	        
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	}

	public void writeHeader1(String string) {
		
		 try {
		        if (string != null) {

		            csvWriter = new PrintWriter(new FileWriter(file,true));
		csvWriter.print(string);
	   csvWriter.print(",");
	   csvWriter.close();
		        }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		
	}

	public void writeHeader2(String string1) {
		// TODO Auto-generated method stub
		 try {
		        if (string1 != null) {

		            csvWriter = new PrintWriter(new FileWriter(file,true));
		csvWriter.print(string1);
	csvWriter.print(",");
	csvWriter.print("?");
	csvWriter.close();
		        }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
	}
		

}
