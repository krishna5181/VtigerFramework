package vTiger.Practice;

import java.io.IOException;

import vTiger.GenericUtlities.ExcelFileUtility;
import vTiger.GenericUtlities.JavaUtility;
import vTiger.GenericUtlities.PropertyFileUtility;

public class GenericUtilityPractice 
{
	public static void main(String[] args) throws IOException 
	{
		JavaUtility jUtil = new JavaUtility();
		 int data = jUtil.getrandomNumber();
		 System.out.println(data);
		 
		 String date = jUtil.getSystemdate();
		 System.out.println(date);
		 
		 String frormatDate = jUtil.getSystemDateInFormat();
		 System.out.println(frormatDate);
		 
		 PropertyFileUtility pUtil = new PropertyFileUtility();
		 String value = pUtil.readDataFromPropertyFile("browser");
		 System.out.println(value);
		 
		 
		 ExcelFileUtility eUtil = new ExcelFileUtility();
		 String value1 = eUtil.readDataFromExelSheet("Contacts", 1 , 2);
		 System.out.println(value1);
		 
		 eUtil.writeDataIntoExcel("Contacts",1, 3, "AVATHAR");
		 System.out.println("data added");
		 
		 System.out.println(eUtil.getRowCount("Contacts"));
		 
	}
}
