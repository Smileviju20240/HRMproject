package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import helper.ReUsableMethods;

public class BaseTest extends ReUsableMethods {

	public Properties property;
	public FileInputStream fis;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Regression","Login", "DataProvider"})
	public void setUpBrowser(String br) throws IOException {
		
		fis = new FileInputStream("./src//main//resources//config.properties");
		property = new Properties();
		property.load(fis);
		
		switch(br.toLowerCase()) {
			case "chrome" : driver = new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			case "firefox" : driver = new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name"); return;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(property.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
	}
	
	@AfterMethod(groups = {"Smoke","Regression","Login", "DataProvider"})
	public void tearDown() {
		driver.quit();
	}

}
