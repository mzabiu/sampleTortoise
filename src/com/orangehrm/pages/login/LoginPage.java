package com.orangehrm.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

	WebDriver driver;
	String userName = "admin";
	String password = "admin123";

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		init();

	}

	@FindBy(id = "txtUsername")
	WebElement txtLogin;

	@FindBy(id = "txtPassword")
	WebElement txPassword;

	@FindBy(id = "btnLogin")
	WebElement btnLogin;

	public void loginToPage() {

		txtLogin.sendKeys(userName);
		txPassword.sendKeys(password);
		btnLogin.click();

	}
	
	public void loginToPage(String userName, String password) {

		txtLogin.sendKeys(userName);
		txPassword.sendKeys(password);
		btnLogin.click();

	}

	public void init() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this);
	}
	
	public void selectMultiple(String[] country) {
		
		//
		//
		//
	}

}
