package Scenario1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDrivenTest {

	public static WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test(dataProvider = "Data", dataProviderClass = L01DataSet.class)
	public void testdatadriven(String username, String password) throws InterruptedException {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
		// Wait for the URL to contain "dashboard"
		try {
			wait.until(ExpectedConditions.urlContains("dashboard"));
			Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login Failed");
			System.out.println("Login Successful");
		} catch (Exception e) {
			captureScreenshot("login_failure_" + username);
			Assert.fail("Login failed for user: " + username);
		}finally {
            // Capture screenshot regardless of login success or failure
            captureScreenshot(username + "_login.png");
		}
	}

	
	public String captureScreenshot(String filename) {
		if (driver == null) {
			System.out.println("WebDriver is not initialized");
			return null;
		}

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String filePath = "E://CapstoneLiveProject//OrangeHrmProject//Screenshots//" + filename + ".png";
		File dest = new File(filePath);
		try {
			FileHandler.copy(src, dest);
			System.out.println("Screenshot captured!" + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePath;
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}


