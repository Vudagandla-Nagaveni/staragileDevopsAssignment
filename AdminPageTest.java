package Scenario2;

import org.testng.annotations.Test;

public class AdminPageTest extends BaseClass {

	// Testcase to get all 12 options from leftside menu and print the count 
	@Test
	public void verifyAdmin() {
		ap.getMenu();

	}

	@Test
	public void verifygetText() {
		ap.getText();
	}
	/*Employee searchByUserName() : here send username
	Admin to username text box and click on search button 
	and display total record found and
	refresh page.*/
	@Test(priority = 2)
	public void VerifySearchWithUsername() throws InterruptedException {
		ap.searchEmpByUsername("Admin");

	}
	/*Employee searchByUserRole() : here automate dropdown 
  and select Role Admin and click on search button and
   display total record found and refresh page.*/
	@Test(priority = 3)
	public void VerifySearchWithUserRole() throws InterruptedException {
		ap.searchEmpByUserRole("Admin");

	}
	/*Employee searchByUserStatus() : here automate dropdown
  and select status Enabled or Disabled then click on 
  search button and display total record found.*/
	@Test(priority = 4)
	public void VerifySearchWithUserStatus() throws InterruptedException {
		ap.searchEmpByStatus("Enabled");

	}
}
