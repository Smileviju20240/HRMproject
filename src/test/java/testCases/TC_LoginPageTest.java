package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import utlities.DataProviders;

public class TC_LoginPageTest extends BaseTest {
	
	LoginPage loginpage;
	
	@Test(groups = {"Smoke","Regression","Login"})
	public void verifyingLoginWithValidCredential() {
		loginpage = new LoginPage(driver);
		loginpage.loginWithValidCredentials();
		
		Assert.assertEquals(loginpage.gettingTitleOfThePage(), "OrangeHRM");
		Assert.assertTrue(loginpage.logo.isDisplayed());
		Assert.assertEquals(loginpage.dashBoard.getText(), "Dashboar");
	}

	@Test(groups = "Regression")
	public void forgotPasswordLink() {
		loginpage = new LoginPage(driver);
		loginpage.clickOnForGotPasswordLink();
		super.waitTillVisible(loginpage.resetPasswordPopupHeading);
		
		Assert.assertEquals(loginpage.gettingResetPasswordHeading(), "Reset Password");
		Assert.assertEquals(loginpage.gettingResetPasswordText(), "Please enter your username to identify your account to reset your password");
		Assert.assertEquals(loginpage.resetPasswordSuccessful(),"Reset Password link sent successfully");			
	}
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"DataProvider", "Regression"})
	public void verifyNotLoginWithWrongCredentials(String username, String pwd, String error_Message) {
		loginpage = new LoginPage(driver);
		loginpage.setEmail(username);
		loginpage.setPassword(pwd);
		loginpage.clickOnLoginButton();
	
		if(loginpage.invalidErrorMessage().equals("Invalid credentials")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);
		}
		
	}

}
