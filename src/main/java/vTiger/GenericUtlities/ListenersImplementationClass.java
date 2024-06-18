package vTiger.GenericUtlities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to all the methods in ITestListener Interface of TestNG
 * @author balar
 *
 */
public class ListenersImplementationClass implements ITestListener {
	
	ExtentReports reports;
	ExtentTest test;

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("----Suite Execution started-------");
		
		//Basic config for Extent Reports
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Reports");
		htmlReport.config().setReportName("Vtiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		
		//Actual Report for system info in Extent Reports
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Base Url","http://localhost:8888");
		reports.setSystemInfo("Base Browser","Chrome");
		reports.setSystemInfo("Base platform", "windows");
		reports.setSystemInfo("ReporterName", "Krishna M");
	
	}
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
//		System.out.println("--------"+methodName+"--Execution Started-----");
		
		test = reports.createTest(methodName);//To monitor the test script
		test.log(Status.INFO, "--Execution Started-----"+methodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
//		System.out.println("---------"+methodName+"----Test script passed----");
		test.log(Status.INFO,"----Test script passed----"+methodName);
	}

	public void onTestFailure(ITestResult result) 
	{
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new  WebDriverUtility();
		
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
//		System.out.println("---------"+methodName+"---Test script failed------");
		test.log(Status.INFO,"---Test script failed------"+methodName);
		test.log(Status.FAIL, result.getThrowable());
		
		String ScreenShotsName = methodName+"-"+jUtil.getSystemDateInFormat();
		try 
		{
			String path=wUtil.takeScreenShot(BaseClass.sdriver, ScreenShotsName);
			test.addScreenCaptureFromPath(path);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) 
	{
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
//		System.out.println("--------"+methodName+"---Test script skipped-------");
		test.log(Status.SKIP,"---Test script skipped-------"+methodName);
		test.log(Status.INFO, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) 
	{
		// TODO Auto-generated method stub
		System.out.println("------Suite Execution finished");
		reports.flush();//It will tell to Extent Repots that execution is finsihed then we can generate report
	}
	

}
