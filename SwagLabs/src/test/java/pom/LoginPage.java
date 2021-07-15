package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	By txtUserName = By.id("user-name");
	By txtPassword = By.id("password");
	By cmdLogin = By.id("login-button");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void enterUsername(String username) {
		driver.findElement(txtUserName).sendKeys(username);
	}
	public void enterPassword(String pwd) {
		driver.findElement(txtPassword).sendKeys(pwd);
	}
	public void clickLogin() {
		driver.findElement(cmdLogin).click();
	}
	public void logintoApplication(String username,String pwd) {
		this.enterUsername(username);
		this.enterPassword(pwd);
		this.clickLogin();
	}
	public String getPageTitle() {
		
		return driver.getTitle();
	}
	public void quit() {
		driver.quit();
	}
}
