package vTiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCommandLineTest 
{
	@Test
	public void readData()
	{
		String BROWSER = System.getProperty("Browser");
		System.out.println(BROWSER);
		
		String URL = System.getProperty("Url");
		System.out.println(URL);
		
		String USERNAME = System.getProperty("Username");
		System.out.println(USERNAME);
		
		String PASSWORD = System.getProperty("Password");
		System.out.println(PASSWORD);
	}

}
