package vTiger.GenericUtlities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This class provides implementation to all the methods in ITestListener Interface of TestNG
 * @author balar
 *
 */
public class ListenersImplementationClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("--------"+methodName+"--Execution Started-----");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("---------"+methodName+"----Test script passed----");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("---------"+methodName+"---Test script failed------");
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("--------"+methodName+"---Test script skipped-------");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("----Suite Execution started-------");
	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("------Suite Execution finished");

	}
	

}
