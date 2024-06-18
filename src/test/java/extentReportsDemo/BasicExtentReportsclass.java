package extentReportsDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasicExtentReportsclass {
	
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void startReport() {
		htmlreporter = new ExtentSparkReporter("ExtentReports.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		
	}

}
