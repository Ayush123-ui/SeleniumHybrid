package com.HybridFramework.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HybridFramework.TestBase.Base;
import com.HybridFramework.Utilities.DataProviders;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;

public class LoginDataDrivenTest extends Base {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_login_DDT(String userName, String passWord, String expectedResult) {
		logger.info("***********Starting Login Test*****************");
		HomePage hp = new HomePage(driver);
		logger.info("Clicking My Account");
		hp.clickMyAccount();
		logger.info("Clicking  login");
		hp.clickLogin();
		
	
		//login page
		LoginPage lp = new LoginPage(driver);
		logger.info("Entering Email and pasword ");
		lp.setEmail(userName);
		lp.setPass(passWord);
		logger.info("Clicking Login Button ");
		lp.clickLogin();

		MyAccountPage myac =  new MyAccountPage(driver);
		boolean target = myac.isMyAccountExists();
		
		logger.info("Validation for invalid result");
		if(expectedResult.equalsIgnoreCase("invalid")) {
			if(target==true) {
				myac.clickLogOut();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
		
		logger.info("Validation for Valid result");
		if(expectedResult.equalsIgnoreCase("valid")) {
			if(target==true) {
				myac.clickLogOut();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		
		logger.info("***********Completed Login Test*****************");
		
		
		
		
	}
	

}
