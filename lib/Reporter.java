package lib;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter {
	ExtentReports reports;
	ExtentTest currentTest;
	
	public Reporter(String reporterPath){
		reports = new ExtentReports(reporterPath);
	}
	
	public void startTest(String testName) {
		currentTest = reports.startTest(testName);
	}

	public void endTest() {
		reports.endTest(currentTest);
		reports.flush();
	}
	
	public void log(String msg) {
		currentTest.log(LogStatus.INFO, msg);
	}
	public void pass(String msg) {
		currentTest.log(LogStatus.PASS, msg);
	}

	public void fail(String msg) {
		currentTest.log(LogStatus.FAIL, msg);
	}

}
