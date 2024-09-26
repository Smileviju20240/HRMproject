package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.ReUsableMethods;

public class LoginPage extends BasePage {
	
	DashBoardPage dashboard;
	ReUsableMethods reUsableComp;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		reUsableComp = new ReUsableMethods();
	}
	
	// Finding WebElemets
	@FindBy(name = "username")
	public WebElement userName;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
    public WebElement Login;
	
	@FindBy(xpath="//img[@alt='client brand banner']")
	public WebElement logo;
	
	@FindBy(xpath="//div[@class='orangehrm-login-logo']//img[@alt='orangehrm-logo']")
	public WebElement orangeHRMLogo;
	
	@FindBy(css=".oxd-topbar-header-breadcrumb")
	public WebElement dashBoard;
	
	@FindBy(css = ".orangehrm-login-forgot-header")
	WebElement forgotPasswordLink;
	
    @FindBy(xpath="//h6[text()='Reset Password']")
    public WebElement resetPasswordPopupHeading;
    
    @FindBy(xpath="//p[text()='Please enter your username to identify your account to reset your password']")
    WebElement popUpmessage;
    
    @FindBy(xpath="//button[@type='button']")
    WebElement cancleButton;
    
    @FindBy(xpath="//button[@type='submit']")
    WebElement resetPasswordButton;
    
    @FindBy(name="username")
    WebElement userNameInputText;
    
    @FindBy(xpath="//h6[text()='Reset Password link sent successfully']")
    WebElement resetPasswordSuccessfulPopupHeading;
    
    @FindBy(xpath="//label[text()='Username']//..//following-sibling::span")
    WebElement loginuserNameError_msg;
    
    @FindBy(xpath="//label[text()='Password']//..//following-sibling::span")
    WebElement loginPasswordError_msg;
    
    @FindBy(xpath="//p[text()='Invalid credentials']")
    WebElement invalidCredMsg;

	// Actions performed on WebElements
	public void loginWithValidCredentials() {	
		reUsableComp.enterText(userName, "Admin");
		reUsableComp.enterText(password, "admin123");
		reUsableComp.clickOnWebElement(Login);
		reUsableComp.gettingTitleOfThePage();	
	}
	
	public String gettingTitleOfThePage() {
		return reUsableComp.gettingTitleOfThePage();
	}
	
	public void setEmail(String email) {
		reUsableComp.enterText(userName, email);
	}
	
	public void setPassword(String pwd) {
		reUsableComp.enterText(password, pwd);
	}
	
	public void clickOnLoginButton() {
		reUsableComp.clickOnWebElement(Login);
	}
	
	public String loginUserNameErrorMessage() {
		return reUsableComp.gettingTextValue(loginuserNameError_msg);
	}
	
	public String loginPasswordErrorMessage() {
		return reUsableComp.gettingTextValue(loginPasswordError_msg);
	}
	
	public String invalidErrorMessage() {
		return reUsableComp.gettingTextValue(invalidCredMsg);
	}
	
	public void clickOnForGotPasswordLink() {
		reUsableComp.clickOnWebElement(forgotPasswordLink);
	}
	
	public String gettingResetPasswordHeading() {
		return reUsableComp.gettingTextValue(resetPasswordPopupHeading);
	}
	
	public String gettingResetPasswordText() {
		return reUsableComp.gettingTextValue(popUpmessage);
	}
	
	public String resetPasswordSuccessful() {
		reUsableComp.enterText(userNameInputText, "Test@gmail.com");
		reUsableComp.clickOnWebElement(resetPasswordButton);
        return reUsableComp.gettingTextValue(resetPasswordSuccessfulPopupHeading);
	}
}
