package com.orangehrm.testcases.login;

import org.testng.annotations.Test;

import com.orangehrm.pages.login.LoginPage;

import test.BaseClass;

public class LoginTest extends BaseClass {

	@Test
	public void verifyLogin() throws Exception {

		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(5000);
		loginPage.loginToPage();

	}

}
