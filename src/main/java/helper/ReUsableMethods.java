package helper;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReUsableMethods {
	
	public static WebDriver driver;

	public void waitTillVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void refreshThePage() {
		driver.navigate().refresh();
	}
	
	public String gettingTitleOfThePage() {
		return driver.getTitle();
	}

	public void clickOnWebElement(WebElement element) {
		element.click();		
	}

	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public String gettingTextValue(WebElement element) {
		return element.getText();
	}
}
