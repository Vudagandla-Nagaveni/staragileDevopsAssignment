package com.CRM.TestCases2;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePageTestCase extends BaseClass {
	@Test(priority = 1)
	public void verifyUrl() {

		String actUrl = hp.getAppUrl();
		Assert.assertTrue(actUrl.contains("crm"), "Test Fail:Url not matched!!");
		Reporter.log("Test Pass:Because Url matched!!");
	}

	@Test(priority = 2)
	public void verifyTitle() {
		String actTitle = hp.getAppTitle();
		Assert.assertTrue(actTitle.contains("Customer"), "Test Fail:Title is not matched");
		Reporter.log("Test Pass: Title matched");
	}

	@Test(priority = 3)
	public void validateSignInLink() {
		String nextPageUrl = hp.getStatusOfLink();
		Assert.assertTrue(nextPageUrl.contains("login"), "Test Fail:Login page not open");
		Reporter.log("Test Pass:Application navigating to Login Page");
	}

}
