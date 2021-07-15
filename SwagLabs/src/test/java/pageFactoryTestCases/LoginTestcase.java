package pageFactoryTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Libraries.utility;
import pageFactory.LoginPage;

public class LoginTestcase {
	
	public static void main(String[] args) throws InterruptedException {
		String baseUrl ="https://www.saucedemo.com/";
		String ExpectedTitle="Swag Labs";
        String ActualTitle =null;
        
        WebDriver driver = utility.launchApplication(1, baseUrl);
       
       LoginPage loginPage = null;
       loginPage = new LoginPage(driver);
       PageFactory.initElements(driver,loginPage);
       //PageFactory.initElements(driver,LoginPage.class) Method 2
       
       loginPage.logintoApplication("standard_user","secret_sauce");
       
       ActualTitle = loginPage.getPageTitle();
       if(ActualTitle.contentEquals(ExpectedTitle))
       {
    	   System.out.println("TestCase Passed");
    	   Thread.sleep(500);
    	   loginPage.quit();
       }
       else
       {
    	   System.out.println("TestCase Failed");
    	   loginPage.quit();
       }
       
       
	}

}
