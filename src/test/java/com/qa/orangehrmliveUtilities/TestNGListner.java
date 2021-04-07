package com.qa.orangehrmliveUtilities;

import java.io.IOException;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.orangehrmliveTestscript.TestBase;
import com.qa.orangehrmliveTestscript.TestHRMApplicationLandingTC;

public class TestNGListner extends TestBase implements ITestListener {

	WebDriver drv;
			
	public void onTestStart(ITestResult result) {
		
//		System.out.println("New Test Started" +result.getName());
		
	}
	
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Successfully Finished" +result.getName());
//		String method=result.getName();
		
		String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
		
		try {
			captureScreenshot(Driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
 
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Failed" +result.getName());
		
		System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
        
        try {
			captureScreenshot(Driver,result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
 
	public void onTestSkipped(ITestResult result) {
		
//		System.out.println("Test Skipped" +result.getName());
		
	}
 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
//		System.out.println("Test Failed but within success percentage" +result.getName());
		
	}
 
	public void onStart(ITestContext context) {
		
		
//		System.out.println("This is onStart method" +context.getOutputDirectory());
		
	}
 
	public void onFinish(ITestContext context) {
			
//		System.out.println("This is onFinish method" +context.getPassedTests());
//		System.out.println("This is onFinish method" +context.getFailedTests());
	}
}
