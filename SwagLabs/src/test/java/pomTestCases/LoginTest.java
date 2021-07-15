package pomTestCases;

import org.openqa.selenium.WebDriver;

import Libraries.utility;
import pom.LoginPage;

public class LoginTest {

	public static void main(String[] args) {
		String baseUrl ="https://www.saucedemo.com/";
        String expectedTitle ="Swag Labs";
		WebDriver driver = utility.launchApplication(1, baseUrl);
        
		LoginPage loginPage = new LoginPage(driver);
        loginPage.logintoApplication("standard_user", "secret_sauce");
	    
        String pageTitle = loginPage.getPageTitle();
	    
	    if(pageTitle.equals(expectedTitle))
	    		{
	    	System.out.println("Testcase Passed");
	    		}
	    else
	    {
	    	loginPage.quit();
	    	System.out.println("Testcase Failed");
	    	
	    }
}
}