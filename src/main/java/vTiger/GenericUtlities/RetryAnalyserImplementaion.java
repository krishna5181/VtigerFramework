package vTiger.GenericUtlities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will provide to the IRetryAnalyser interface of TestNG
 * @author balar
 *
 */
public class RetryAnalyserImplementaion implements IRetryAnalyzer {
	
	int count = 0;
	int retryCount = 3;
	/**
	 * Retry will retry count is met
	 */
	public boolean retry(ITestResult result) 
	{
		while(count<retryCount)
		{ 
			count++;
			return true;
		}
		return false;
	}
}
