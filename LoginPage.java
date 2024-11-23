package Scenario2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	//Encapsulation= data + function

	private WebDriver driver;

	//initialize driver
	public LoginPage(WebDriver driver)//Base class
	{
		this.driver=driver;
	}

	//method
	public boolean doLogin(String un, String psw) {
		try {
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(psw);
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			// Add a wait or check for an element that is present after a successful login
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	            // Navigate to relevant section
	            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav/ul/li[1]/a/span[1]"))).click();
	            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav/ul/li[1]/div/ul/li/a/span"))).click();
			//driver.findElement(By.xpath("//a[@id='menu_dashboard_index']")); // Example element
			return false;
		} catch (Exception e) {

			// Handle the exception, maybe log it, and return false to indicate login failed
			e.printStackTrace();
			return false ;
		}
	}

	public String getAppTitle()
	{
		return driver.getTitle();
	}


	public String getAppUrl()
	{
		return driver.getCurrentUrl();
	}
}