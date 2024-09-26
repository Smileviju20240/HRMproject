package PageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage {
	
	List<String> left_Menus_List;
	List<String> dashboardSections;
	boolean bool;
	boolean bool1;
	
	 public DashBoardPage(WebDriver driver) {
		 super(driver);
	 }
	 
	//Finding WebElemets	 
	 @FindBy(xpath = "//ul//li//a//span")
	 List<WebElement> left_Menu_Links;
	 
	 @FindBy(css = ".orangehrm-dashboard-widget-header .oxd-text--p")
	 List<WebElement> dashboard_Sections;
	 
	 
	//Actions performed on WebElements
	public boolean displayingLeftHandMenuLists() {
		String[] left_Menus = {"Admin", "PIM", "Leave", "Time", "Recruitment", "My Info", "Performance", "Dashboard", "Directory", "Maintenance", "Claim","Buzz"};
		List<String> left_Menulink = Arrays.asList(left_Menus);
		
		for(WebElement left_Menu_Link: left_Menu_Links) {
			bool = left_Menulink.contains(left_Menu_Link.getText());
		} 
		return bool;
	}
	 
	public boolean displayingAllSectionsinDashboard() {
		String[] sections = {"Time at Work", "My Actions", "Quick Launch", "Buzz Latest Posts", "Employees on Leave Today", "Employee Distribution by Sub Unit", "Employee Distribution by Location"};
		 dashboardSections = Arrays.asList(sections);

		 for(WebElement dashboard_Section: dashboard_Sections) {
				bool1 = dashboardSections.contains(dashboard_Section.getText());
			}
	 	
		 return bool1;
	}
}
