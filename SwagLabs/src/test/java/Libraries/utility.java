package Libraries;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class utility {
	public static WebDriver driver;
	public static WebDriver launchApplication(int browser,String baseUrl) {
		switch (browser) {
		case 1:
			System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\CHANDU\\\\Desktop\\\\chromedriver.exe");
			driver=new ChromeDriver();
			break;

		default:
			break;
		case 2:
			System.setProperty("webdriver.gecko.driver","C:\\\\Users\\\\CHANDU\\\\Desktop\\\\chromedriver.exe");
			driver=new FirefoxDriver();
			break;
			
		case 3:
			System.setProperty("webdriver.ie.driver","C:\\\\Users\\\\CHANDU\\\\Desktop\\\\chromedriver.exe");
			driver=new InternetExplorerDriver();
			break;
			
		}
		
		
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		
		return driver;
	}
	public static void captureScreenshot(WebDriver driver,String fileName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(".\\Screenshots\\"+fileName+".png"));
	}
	public static void loginToApplication(WebDriver driver,String uName,String pass) {
		driver.findElement(By.cssSelector("input#ctl00_MainContent_username")).sendKeys(uName);
		driver.findElement(By.cssSelector("input[type=password]")).sendKeys(pass);
		driver.findElement(By.cssSelector("input.button[value^='Log']")).click();
	}
	public static void logOut(WebDriver driver) {
		driver.findElement(By.linkText("Logout")).click();
	}
	public static String getPageTitle(WebDriver driver) {
		String s=driver.getTitle();
		
		return s;
	}
}