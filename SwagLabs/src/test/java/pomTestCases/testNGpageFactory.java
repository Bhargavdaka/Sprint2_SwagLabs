package pomTestCases;

import org.testng.annotations.Test;



import Libraries.utility;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class testNGpageFactory {
	String baseUrl ="https://www.saucedemo.com/";
	String ExpectedTitle="Swag Labs";
    String ActualTitle =null;
    WebDriver driver;
    LoginPage lp;
  @Test
  public void verifyLoginPage() {
	  ActualTitle = lp.getPageTitle();
	  Assert.assertEquals(ActualTitle,ExpectedTitle);
  }
  @BeforeTest
  public void initilization() {
	  driver = utility.launchApplication(1, baseUrl);
	   
	  lp = new LoginPage(driver);
	  PageFactory.initElements(driver,lp);
	  lp.logintoApplication("standard_user","secret_sauce");
	  
  }

  @AfterTest
  public void stop() {
	  lp.quit();
  }

}
