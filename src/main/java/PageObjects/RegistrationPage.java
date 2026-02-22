package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage  extends BaseComponents{

	WebDriver driver;

	// constructor
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;

	@FindBy(css = "#input-password")
	WebElement password;

	@FindBy(css = "#input-confirm")
	WebElement passconfirm;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement policyElement;

	@FindBy(css = "input[value='Continue']")
	WebElement continueElement;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirMsg;

	// action methods
	public void setFirstName(String fName) {
		firstName.sendKeys(fName);
	}

	public void setLastNam(String lName) {
		lastName.sendKeys(lName);
	}

	public void setEmail(String myEmail) {
		email.sendKeys(myEmail);
	}

	public void setTelephone(String myTele) {
		telephone.sendKeys(myTele);
	}

	public void setPass(String myPass) {
		password.sendKeys(myPass);
	}

	public void setPassConf(String myPass) {
		passconfirm.sendKeys(myPass);
	}

	public void checkPolicy() {
		policyElement.click();
	}

	public void clickCont() {
		continueElement.click();
	}

	public String getConfirMsg() {
		try {
			return confirMsg.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
