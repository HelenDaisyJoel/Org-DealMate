package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
	WebDriver driver;
	
	
	@Given("the user is on the nopCommerce login page")
	public void the_user_is_on_the_nop_commerce_login_page() {
	   driver=new ChromeDriver();
	   driver.get("https://dealmate.co.in/demo/dashboard/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("the user enters valid credentials \\(email: {string}, password: {string})")
	public void the_user_enters_valid_credentials_username_password(String email, String password) {
	    driver.findElement(By.xpath("//input[@placeholder='E-Mail Address']")).sendKeys(email);
	    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
	    
	    
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Then("the user should be redirected to the My Account page")
	public void the_user_should_be_redirected_to_the_my_account_page() {
		boolean logo=driver.findElement(By.xpath("//img[@class='c-sidebar-brand-full']")).isDisplayed();
		Assert.assertTrue("true", logo);

		
		
	    
	}

	@Then("the user should see a userloginPage")
	public void the_user_should_see_a_userloginPage() {
		
		String userName = driver.findElement(By.xpath("//label[normalize-space()='Demo User']")).getText();
		Assert.assertEquals(userName, "Demo User");
		driver.quit();	
	    
	}

}
