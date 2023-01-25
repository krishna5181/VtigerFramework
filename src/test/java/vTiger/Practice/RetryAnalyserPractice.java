package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice 
{
	@Test(retryAnalyzer = vTiger.GenericUtlities.RetryAnalyserImplementaion.class)
	public void retryAnalyserTest() 
	{
		System.out.println("Executed");
		Assert.fail();
	}
	@Test
	public void retryAnalyserTest1() 
	{
		System.out.println("Executed 1");
		
	}

}
