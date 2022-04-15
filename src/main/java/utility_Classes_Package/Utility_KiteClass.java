package utility_Classes_Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility_KiteClass {
//make all the methods of utility class as static methods
	
	static Sheet GetSheet;  //we make sheet declare as globally becz due to this we can able to use it in another class
	
	public static String ReadExcel(int rowindex, int columnindex) throws EncryptedDocumentException, IOException
	{
		  FileInputStream ObjFIS= new FileInputStream("C:\\Users\\OWNER\\Desktop\\VELOCITY DATA\\Automation Excel sheet\\IntroExcel.xlsx");
          GetSheet = WorkbookFactory.create(ObjFIS).getSheet("DDF Data");
          String value = GetSheet.getRow(rowindex).getCell(columnindex).getStringCellValue();
	      return value;
        
	}
	
	public static void TakeScreenshot(WebDriver driver, int TCID) throws IOException     //here we add in the parameter WebDriver driver becz screenshot will taken using TakesScreenshot interface which is connect with WebDriver 
	{                                                                                    //and we also add TC in parameter becz we want screenshot when TC is getting Passed
		 
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Desti = new File("C:\\Users\\OWNER\\Desktop\\VELOCITY DATA\\ScreenShot By Automation\\"+TCID+"TcImage.png");
		FileHandler.copy(Source, Desti);
		Reporter.log("Taking Screenshot of TC becz TC is passed"+TCID,true);  //Here we add TCID in comment becz when this tc get passed then it will take screenshot that y we concat TCID
	}
}
