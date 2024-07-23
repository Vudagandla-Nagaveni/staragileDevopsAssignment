package com.CRM.TestCases2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionTest {
  @Test
  public void hardAssertionTest() {
	  
	  String act="Selenium WebDriver is API for WebUi Test";
	  String exp="Selenium WebDriver is API for WebUi library";
	  Assert.assertEquals(act,exp,"Test Fail:Strings are not equal");
	  System.out.println("Test Pass: Strings are equal!!");
	    
  }
}
