package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cs.constants.FrameworkConstants;

public final class ExtentReport {
	
	public static ExtentReports extent; 
	public static ExtentTest    extentTest;
	
	private ExtentReport() {}
	
	public static void initReports()
	{
		extent = new ExtentReports();  // thread safe 
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReportPath());
		extent.attachReporter(spark);
		
	}
	
	public static void flushReport()
	{
		extent.flush();
	}
	
	public static void createTest(String testCaseName)
	{
		extentTest = extent.createTest(testCaseName);
		//provides ability to run extent test in parallel
		ExtentManager.setExtentTest(extentTest);
	}
	
	public static void assignAuthor(String[] strings)
	{
		for(String authorName : strings)
			ExtentManager.getExtentTest().assignAuthor(authorName);
	}
	
	public static void assignCategory(String[] strings)
	{
		for(String testCaseCategory :strings)
			ExtentManager.getExtentTest().assignCategory(testCaseCategory);
	}



}
