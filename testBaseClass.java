package Scenario2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class testBaseClass {
 
	public WebDriver driver;
	public LoginPage lp;
	public DashboardPage dp;
	
  @BeforeTest
  public void setUp() 
  {
	 driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	  //Initialize Page Objects
	  lp=new LoginPage(driver);
	  dp=new DashboardPage(driver);
	  
  }
  
  @BeforeClass
  public void pageSetup()
  {
	  System.out.println("Login Test");
	  lp.doLogin("Admin","admin123");
  }
  
  
}
