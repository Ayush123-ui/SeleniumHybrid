package com.HybridFramework.TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HybridFramework.TestBase.Base;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;

public class LoginTest extends Base {
	/**
	 * 
	 */
	@Test
	public void verify_login() {
		//homepage
		logger.info("***********Starting Login Test*****************");
		HomePage hp = new HomePage(driver);
		logger.info("Clicking My Account");
		hp.clickMyAccount();
		logger.info("Clicking  login");
		hp.clickLogin();
		
	
		//login page
		LoginPage lp = new LoginPage(driver);
		logger.info("Entering Email and pasword ");
		lp.setEmail(prop.getProperty("myEmail"));
		lp.setPass(prop.getProperty("myPass"));
		logger.info("Clicking Login Button ");
		lp.clickLogin();

		//myaccount page
		MyAccountPage ap =  new MyAccountPage(driver);
		SoftAssert sa = new SoftAssert();
		
		logger.info("Validaiting Account existence");
		ap.isMyAccountExists();
		sa.assertTrue(ap.isMyAccountExists());
		logger.info(" Login Test failed ");
		sa.assertAll();
		
		logger.info("***********Completed Login Test*****************");
		
		
		
		
		
		
		
		
	
	}

}
