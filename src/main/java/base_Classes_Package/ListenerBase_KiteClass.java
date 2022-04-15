package base_Classes_Package;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class ListenerBase_KiteClass {


	//In this class we use Nonstatic methods there and we want methods of base class in test class so we extends base class in test class
	
	protected static WebDriver driver; //Here we declare WebDriver globally becz we need WebDriver in both of this methods
	
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\OWNER\\Desktop\\VELOCITY DATA\\VELOCITY NOTES\\Automation Notes\\SELENIUM Software\\chromedriver.exe");
		
		//here insted of launch browser u can have option i.e --disable-notifications to create that you ChromeOptions Class
               Reporter.log("Browser is launching",true);
		       ChromeOptions obj= new ChromeOptions();
		       obj.addArguments("--disable-notifications");
		       driver= new ChromeDriver(obj);   //due to this we r not seeing the notification but the action can be taken in backdata and we got the output in console 
		 
		       driver.get("https://kite.zerodha.com/");
			   driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
			   driver.manage().window().maximize();
			   Reporter.log("Browser Lanunched Successfully",true);
		         
	}
	
	
	
	public void TakeScreenshot(String TCNAME) throws IOException    //In this when we take this for listener Remove WebDriver driver and convert TCID to TCName
	{                                                                                   
		 
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Desti = new File("C:\\Users\\OWNER\\Desktop\\VELOCITY DATA\\ScreenShot By Automation\\"+TCNAME+"TcImg.png");
		FileHandler.copy(Source, Desti);
		Reporter.log("Taking Screenshot of TC becz TC is passed"+TCNAME,true);  //Here we add TCID in comment becz when this tc get passed then it will take screenshot that y we concat TCID
	}
	
	public void CloseBrowser()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	   	driver.close();
	   	Reporter.log("closing the browser sucessfully");
		
		
	}
	
}
