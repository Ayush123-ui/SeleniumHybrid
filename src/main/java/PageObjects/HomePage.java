package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseComponents {
	
	WebDriver driver;
	
	//constructor
	public  HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	//locators
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement loginElement;
	
	
	//action methods
	public void clickMyAccount() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
	}
	
	public void clickRegister() {
		register.click();
	}
	
	public void clickLogin() {
		loginElement.click();
	}
	

}
