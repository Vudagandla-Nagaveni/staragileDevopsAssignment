package Scenario2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

	@Test(priority=1)
	public void verifyTitle()
	{

		String act=lp.getAppTitle();
		Assert.assertTrue(act.contains("HRM"),"Error-Title does not match");
		System.out.println("Title matches!");
	}

	@Test(priority=2)
	public void verifyLogin()
	{
		System.out.println(lp.doLogin("Admin","admin123"));
	}

	@Test(priority=3)
	public void verifyCurrentUrl()
	{
		System.out.println(lp.getAppUrl());

	}

}
