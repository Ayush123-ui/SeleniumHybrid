package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BaseComponents {

	
	//constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement myAccountText;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logOutElement;
	
	//action methods
	public boolean isMyAccountExists() {
		try {
		return myAccountText.isDisplayed();}
		catch (Exception e) {
			return false;
		}
	
	}
	
	public void clickLogOut() {
		logOutElement.click();
		
	}
	
	
	
	
	

}
