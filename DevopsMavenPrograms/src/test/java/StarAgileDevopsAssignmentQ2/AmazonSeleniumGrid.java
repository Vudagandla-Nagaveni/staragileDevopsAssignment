
/*Write Automation script for Amazon application using docker test it on three 
 * different browsers like chrome, Firefox and edge with selenium grid setup and 
 * push your code on git hub and trigger job in Jenkins to print the result
 */
package StarAgileDevopsAssignmentQ2;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonSeleniumGrid {
	public WebDriver driver;

	@Parameters({ "browsername" })
	@Test
	public void crossBrowserTest(String browsername) throws MalformedURLException, InterruptedException {
		System.out.println("Remote Driver Connectivity Started");
		if (browsername.equals("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
			System.out.println("Session Created on Chrome!");

		} else if (browsername.equals("Firefox")) {

			FirefoxOptions options = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
			System.out.println("Session Created on Firefox!");

		} else if (browsername.equals("Edge")) {
			EdgeOptions options = new EdgeOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);

			System.out.println("Session Created on Edge!");
			driver.quit();

		}
		// open Application
		System.out.println("Remote Driver Connectivity Completed");
		Thread.sleep(3000);
		driver.get("https://www.amazon.in");
		Thread.sleep(10000);
		System.out.println("Title is :" + driver.getTitle());

	}
}
