package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice2 
{
	@Test(dataProvider = "OrgInd")
	public void addOrgnameAndIndusty(String OrgName, String IndName)
	{
		System.out.println(OrgName+" "+IndName);
		
	}
	@DataProvider(name = "OrgInd")
	public Object[][] getData()
	{
		Object[][] data = new Object[5][2];
		
		data[0][0] = "Auribindo";
		data[0][1] = "Chemical";
		
		data[1][0] = "Stark";
		data[1][1] = "Engineering";
		
		data[2][0] = "ICICI";
		data[2][1] = "Banking";
		
		data[3][0] = "Akash";
		data[3][1] = "Education";
		
		data[4][0] = "PVR";
		data[4][1] = "Entertainment";
		
		return data;
	}

}
