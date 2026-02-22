package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseComponents {

	// constructor
	public LoginPage(WebDriver driver) {
		super(driver);

	}

	// locators
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailElement;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement passElement;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButtonElement;

	// action methods
	public void setEmail(String myEmail) {
		emailElement.sendKeys(myEmail);
	}

	public void setPass(String pass) {
		passElement.sendKeys(pass);
	}

	public void clickLogin() {
		loginButtonElement.click();
	}

}
