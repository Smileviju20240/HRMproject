package utlities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import helper.ReUsableMethods;

public class ExtentReportManager extends ReUsableMethods implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports reports;
	public ExtentTest test;
	String reportName;
	String timeStamp;
	String failedImage;
	
	@Override
	public void onStart(ITestContext context) {
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName = "Test_Report - " +timeStamp+ ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+reportName);
		
		sparkReporter.config().setDocumentTitle("orangeHRM Automation Report");
		sparkReporter.config().setReportName("orangeHRM functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);
		reports.setSystemInfo("Application", "OrangeHRM");
		reports.setSystemInfo("User Name", System.getProperty("user.name"));
		reports.setSystemInfo("Environment", "QA");
		
		String os = context.getCurrentXmlTest().getParameter("os");
		reports.setSystemInfo("operating System", os);
		
		String browser = context.getCurrentXmlTest().getParameter("browser");
		reports.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty())
		reports.setSystemInfo("Groups", includedGroups.toString());	
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test = reports.createTest(result.getTestClass().getName());        // to display class name in the report
		test.assignCategory(result.getMethod().getGroups());               // to display groups in the report
		test.log(Status.PASS, result.getName()+"successfully executed.");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		failedImage = "FailedTest_" +timeStamp+ ".png";
		
		test = reports.createTest(result.getTestClass().getName());        // to display class name in the report
		test.assignCategory(result.getMethod().getGroups());               // to display groups in the report
		test.log(Status.FAIL, result.getName()+"got failed.");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		TakesScreenshot takescreenshot = (TakesScreenshot)driver;
		File sourceFile = takescreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"/screenshots/"+failedImage;
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		test.addScreenCaptureFromPath(targetFilePath);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test = reports.createTest(result.getTestClass().getName());        // to display class name in the report
		test.assignCategory(result.getMethod().getGroups());               // to display groups in the report
		test.log(Status.SKIP, result.getName()+"got skipped.");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
