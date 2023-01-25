package vTiger.GenericUtlities;

import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	public int getrandomNumber() {
		Random ran = new Random();
		int value = ran.nextInt(1000);
		return value;
	}
	
	public String getSystemdate() {
		Date d = new Date();
		 String value = d.toString();
		return value;	
	}
	
	public String getSystemDateInFormat() {
		
		Date d = new Date();
		 String[] dArr = d.toString().split(" ");
		  String date = dArr[2];
		  String month = dArr[1];
		  String year = dArr[5];
		  String time = dArr[3].replace(":", "-");
		  String dateInFormat = date+"_"+month+"_"+year+"_"+time;
		  return dateInFormat;
	}
}
