package utils;

import java.util.concurrent.TimeUnit;
import org.testng.xml

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestNg {
	
	WebDriver driver=null;
	
	@BeforeTest
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\CHANDU\\Desktop\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  

	}
	
	@Test(dataProvider="test1data")
	public void test1(String username, String password) throws Exception {
		System.out.println(username+" | "+password);
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);
		
		
		
		
		
	}
	
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String excelPath = "C:\\Users\\CHANDU\\Downloads\\ExcelSheet.xlsx";
		Object data[][] = testData(excelPath, "LoginTestData");
		return data;
		
	}
	
	
	public Object[][] testData(String excelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				
				String cellData = excel.getCellDataString(i, j);
				System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			
			}
			System.out.println();
		}
		return data;
		
	}

}