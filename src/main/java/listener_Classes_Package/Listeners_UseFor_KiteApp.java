package listener_Classes_Package;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base_Classes_Package.ListenerBase_KiteClass;

public class Listeners_UseFor_KiteApp extends ListenerBase_KiteClass implements ITestListener {


	
	public void onTestFailure(ITestResult result)   {
	  String TestCaseName = result.getName();
	  System.out.println("The Failed TC name is: "+TestCaseName);
	  
	  try {
		TakeScreenshot(TestCaseName);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}

	public void onTestSuccess(ITestResult result) {
		 String TestCaseName = result.getName();
		  System.out.println("The Passed TC name is: "+TestCaseName);
	}
}
