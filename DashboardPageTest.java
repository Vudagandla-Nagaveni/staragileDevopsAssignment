package Scenario2;

import org.testng.annotations.Test;

public class DashboardPageTest extends testBaseClass {

	@Test(priority = 1)
	public void verifyAdmin() {
		dp.getMenu();
	}

	@Test(priority = 2)
	public void VerifySearchWithUsername() {
		dp.searchEmpByUsername("Admin");
	}

	@Test(priority = 3)
	public void VerifySerchWithUserRole() {
		dp.searchEmpByUserRole("Admin");
	}

	@Test(priority=4)
		  public void VerifySerchWithUserStatus()
		  {
			  dp.searchEmpByStatus("Enabled");
  
		  }
}
