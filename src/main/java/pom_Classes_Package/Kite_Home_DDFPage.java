package pom_Classes_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kite_Home_DDFPage {

//	Step 1)--->globallically declare the data members---Declaration
//	@FindBy(AttributeName="Attribute value") private WebElement Datamember;	
	
	@FindBy(xpath="//span[@class='user-id']") private WebElement UserIdHome;
	@FindBy(xpath="//a[@target='_self']") private WebElement LogoutOption;
	
	
//  Step 2)--->create a constructor having public access specifier and in that create pagefactory class
	
	public Kite_Home_DDFPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
// Step 3)---->Create parameterized method
	
	public String getActualUserID()   //******remove void return type and we get ExpectedResult from excel sheet in test class
	{
		String ActualUserID = UserIdHome.getText() ;
		return ActualUserID ;  // ********when we remove return type we have to return that return type
		
/*		if(ActualResult.equals(ExpectedResult))
		{
			System.out.println("UserId is matching so test case is passed");
		}
		else
		{
			System.out.println("UserId is not matching so test case is failed");
		}
	As we r using testNG so instead of if else control statement we can use assert in test class and here provide ValidateUsername as a string retrun type	
		*/
	}
	
	
	public void ClickingLogout() throws InterruptedException
	{
		UserIdHome.click();
		Thread.sleep(1000);
		
		LogoutOption.click();
	}
	
 
	
}
