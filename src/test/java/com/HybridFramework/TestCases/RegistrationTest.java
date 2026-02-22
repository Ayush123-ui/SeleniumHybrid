package com.HybridFramework.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HybridFramework.TestBase.Base;
import com.HybridFramework.Utilities.Retry;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;

public class RegistrationTest extends Base {

	@Test
	public void verify_registration() {

		logger.info("********Starting Test*********");

		HomePage hp = new HomePage(driver);
		logger.info("Clicking My Account");
		hp.clickMyAccount();
		logger.info("Clicking Register");
		hp.clickRegister();

		RegistrationPage rp = new RegistrationPage(driver);
		logger.info("Entering all Details");
		rp.setFirstName(getRandomString());
		rp.setLastNam(getRandomString());
		rp.setEmail(getRandomString() + "@gmail.com");
		rp.setTelephone(getRandomNum());
		String pass = getAlphaNum();
		rp.setPass(pass);
		rp.setPassConf(pass);
		logger.info("Selecing Policy Checkbox");
		rp.checkPolicy();
		logger.info("Clicking Continue button");
		rp.clickCont();

		logger.info("Validating Confirmation message");
		String msg = rp.getConfirMsg();
		if (msg.equalsIgnoreCase("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		} else {
			System.out.println("Test fail.!");
			Assert.fail();
		}
		logger.info("********Completed Test*********");

	}

}
