package vTiger.GenericUtlities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItTestListnerImplementationClass implements ITestListener{
	
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("------Suite Execution Strated------");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("------Suite Execution F------");
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("-----------"+methodName+"--Execution started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("---------"+methodName+"---Test script pass---");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("---------"+methodName+"---Test script Failed---");
		System.out.println(result.getThrowable());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("---------"+methodName+"---Test script Skipped---");
		System.out.println(result.getThrowable());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}
 
}
