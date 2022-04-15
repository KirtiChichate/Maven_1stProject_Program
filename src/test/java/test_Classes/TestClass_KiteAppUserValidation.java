package test_Classes;

import org.testng.annotations.Test;

import base_Classes_Package.Base_KiteClass;
import pom_Classes_Package.Kite_Home_DDFPage;
import pom_Classes_Package.Kite_Login_DDFPage;
import pom_Classes_Package.Kite_Pin_DDFPage;
import utility_Classes_Package.Utility_KiteClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

//1st We need to extend base class becz In this baseclass we use Nonstatic methods there and we want methods of base class in test class so we extends base class in test class
public class TestClass_KiteAppUserValidation extends base_Classes_Package.Base_KiteClass {
 
	Kite_Login_DDFPage login;
	 Kite_Pin_DDFPage pin;
	 Kite_Home_DDFPage home;
 
	 
 @BeforeClass
  public void Lunching_Browser() {
	 
	 LaunchBrowser(); //we call direcctly by method name this LaunchBrowser method of base class as we extends base class
	  
	  //Now we have to create object of login,pin and home page class here and  declaring it globally
	  login= new Kite_Login_DDFPage(driver);  //now as we have the visibility of driver before changing default in BASE classes so we have chnge that visibility to protected
      pin= new Kite_Pin_DDFPage(driver);
      home= new Kite_Home_DDFPage(driver);
      driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000)); 
  }

	 
 @BeforeMethod
  public void Login_To_Kite() throws EncryptedDocumentException, IOException {
	 Reporter.log("Kite Login Page Loading",true);
	 //Now Call all The methods of loginclass from pom class  by Objname as we created in above method with its method and passing the parameter in that as Utilityclassname.oneof the methods from that class
	//This we do bexz we store or call our excel file in utility class as we know we use it many times
	  login.EnterUsername(Utility_KiteClass.ReadExcel(1, 0));
	  login.EnterPassword(Utility_KiteClass.ReadExcel(1, 1));
	  login.ClickingLoginButton();

	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	//Now Call all The methods of pinclass from pom class  by Objname as we created in above method with its method and passing the parameter in that as Utilityclassname.oneof the methods from that class
		//This we do bexz we store or call our excel file in utility class as we know we use it many times	  
	  Reporter.log("Redirecting to Pin page",true);
	 pin.EnterPin(Utility_KiteClass.ReadExcel(1, 2)); 
	 pin.ClickingContinueButton();
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	
  }

 @Test
  public void Validate_User() throws EncryptedDocumentException, IOException {
	 Reporter.log("Kite Home page Successfully launched",true);
	 int TCID=101;  //Declare TC id here
	  //Here we validate our UserID by comparing Actual And Expected userId
	
	 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	 
	String ActualUserID = home.getActualUserID();     //here use home.that string variablename which you used in method name by remove the return type
	String ExpectedUserID = Utility_KiteClass.ReadExcel(1, 0); //we get expected id from the excel sheet which we declare in utilityclass and in that inside the read excel method
	//now we have to used assert(Hardassert becz we have only 1 tc ) to verify the condition
	Assert.assertEquals(ActualUserID,ExpectedUserID,"ActualUserId is not Matching ExpectedUserID" );
	//if this Tc is passed then we have to take screenshot so write script for that
	//call by classname.methodname by pass in the argument as driver and TC id so for that 1st declare id inside this method
	Reporter.log("UserId Validate Successfully,Tc is passed",true);
	Reporter.log("As TC is passed,So Take Screenshot that HomePage");
	Utility_KiteClass.TakeScreenshot(driver, TCID);
	 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));  
  }
  
  
 @AfterMethod
  public void LogOut_From_Kite() throws InterruptedException {
	//Call logout method from home POM class
	 Reporter.log("LoginOut Kite Application",true);
	  home.ClickingLogout();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000)); 
  }

  
 @AfterClass
  public void Closing_Browser() {
	 Reporter.log("Closing the Browser",true); 
	 CloseBrowser();
	  
	  
  }

}
