package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import helper.ReUsableMethods;

public class BasePage extends ReUsableMethods {

	public BasePage(WebDriver driver) {
		ReUsableMethods.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
