package StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps {
	String baseUrl = "https://www.saucedemo.com/";
	WebDriver driver;
	@Given("the user is on login screen")
	public void the_user_is_on_login_screen() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\CHANDU\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		System.out.println("Login Screen displayed");
		Thread.sleep(3000);

	}
	
    @When("user enters valid username provided")
	public void user_enters_valid_username_provided() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		System.out.println("username entered");
	}

	@When("user enters valid password provided")
	public void user_enters_valid_password_provided() {
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		System.out.println("password entered");
	} 

	@When("user clicks login button")
	public void user_clicks_login_button() {
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login successful");

	}

	@Then("user should be on swaglabs page")
	public void user_should_be_on_swaglabs_page() {
		System.out.println(driver.getTitle());
		System.out.println("SwagLabs page displayed");

	}

	@Then("user closes browser")
	public void user_closes_browser() {
		driver.quit();
		System.out.println("Browser closed");

	}
	@When("user enters invalid username")
	public void user_enters_invalid_username() {
		driver.findElement(By.id("user-name")).sendKeys("standarduser");
		System.out.println("username entered");
	}

	@When("user enters valid password")
	public void user_enters_valid_password() {
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		System.out.println("password entered");

	}

	@Then("user should be on loginpage with error")
	public void user_should_be_on_loginpage_with_error() {
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login unsuccessful");
	}
	@When("user enters username as a {string}")
	public void user_enters_username_as_a(String username) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		System.out.println("username entered");

	}

	@When("user enters password as a {string}")
	public void user_enters_password_as_a(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		System.out.println("password entered");
	}


	@Then("user should be on SwagLabs page")
	public void user_should_be_on_SwagLabs_page() {
		System.out.println(driver.getTitle());
		System.out.println("SwagLabs page Displayed");
	}
}
