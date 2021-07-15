package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	public WebDriver driver;
	@CacheLookup
	@FindBy(how = How.ID,using = "user-name") WebElement txtusername;
	@FindBy(how = How.ID,using = "password") WebElement txtpassword;
	@FindBy(how = How.ID,using ="login-button") WebElement cmdLogin;
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void enterUserName(String username) {
		txtusername.sendKeys("standard_user");
	}
	public void enterPassword(String password) {
		txtpassword.sendKeys("secret_sauce");
	}
	public void ClickLogin() {
		cmdLogin.click();
	}
	public void logintoApplication(String username,String pwd) {
		this.enterUserName(username);
		this.enterPassword(pwd);
		this.ClickLogin();
	}
	public String getPageTitle() {
		
		return driver.getTitle();
	}
	public void quit() {
		driver.quit();
	}

}
