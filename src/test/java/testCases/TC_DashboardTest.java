package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.DashBoardPage;
import PageObjects.LoginPage;

public class TC_DashboardTest extends BaseTest {
	
	LoginPage loginpage;
	DashBoardPage dashboard;
	
	@Test(groups = "Smoke")
	public void verifyingLeftMenuList() throws InterruptedException {
		loginpage = new LoginPage(driver);
		dashboard = new DashBoardPage(driver);
		loginpage.loginWithValidCredentials();
		
		Assert.assertTrue(dashboard.displayingLeftHandMenuLists());
	}
	
	@Test(groups = "Smoke")
	public void verifyingDashboardSectionList() throws InterruptedException {
		loginpage = new LoginPage(driver);
		dashboard = new DashBoardPage(driver);
		loginpage.loginWithValidCredentials();
		
		Assert.assertTrue(dashboard.displayingAllSectionsinDashboard());
	}

}
