package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListnerIMPClass implements ITestListener {
   ExtentReports report;
   ExtentTest test;
   
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test=report.createTest(methodname);
		Reporter.log("execution starts from here",true);
		
	}
		
	public void onTestSuccess(ITestResult result) {                                                           
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, methodname);
		Reporter.log(methodname+"---->executed successfully");
	
	}

	public void onTestFailure(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		try {
			String screenshot = WebDriverUtility.getScreenShot(BaseClass.sdriver, methodname);
		test.log(Status.FAIL,methodname+"---failed");
		test.log(Status.FAIL,result.getThrowable());
		test.addScreenCaptureFromPath(screenshot);
		Reporter.log(methodname+"--->Failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		 
		
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		test.log(Status.SKIP,methodname+"---->Skipped");
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log(methodname+"---->Skipped");
		
		
		
			}
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtendReporter/Report.html");
		htmlReport.config().setDocumentTitle("");
		htmlReport.config().setReportName("");
		htmlReport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-platform","window");
		report.setSystemInfo("Base-browser","chrome");
		report.setSystemInfo("Base-url", "http://rmgtestingserver:8888/");
		report.setSystemInfo("ReporterName", "Vidya");
		
		
		
		
		
			}

	public void onFinish(ITestContext context) {
		report.flush();
		
		
		
	}

}
