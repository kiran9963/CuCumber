package cucum.id;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Throwables;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AddId {

	public static WebDriver driver;

	@Given("user should launch browser")
	public void user_should_launch_browser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-kk\\cucumber\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/telecom/");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

	}

	@When("User click the add customer link")
	public void user_click_the_add_customer_link() {

		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();

	}

	@When("User Provide valid details")
	public void user_Provide_valid_details() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//label[text()='Done']")).click();
		driver.findElement(By.id("fname")).sendKeys("kranti");
		driver.findElement(By.id("lname")).sendKeys("kiran");
		driver.findElement(By.id("email")).sendKeys("kiran123@gmail.com");
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("Andhra");
		driver.findElement(By.id("telephoneno")).sendKeys("9963966653");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("To verify the customer id is Displayed")
	public void to_verify_the_customer_id_is_Displayed() {
		Assert.assertTrue((driver.findElement(By.xpath("//td[@align='center']")).isDisplayed()));

	}

}
