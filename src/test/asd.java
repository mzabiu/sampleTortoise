package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class asd extends BaseClass {

	@Test(priority = 2, groups = "smoke")
	public void doLogintest() {
		System.out.println("Test doLogin test Executing");
		Assert.fail("Login test failed.......");

	}

	@Test(priority = 3, groups = "smoke", dependsOnMethods = { "doLogintest" })
	public void titleValidation() {
		System.out.println("Test titleValidation test Executing");

	}

	@Test(priority = 4, groups = "smoke")
	public void pageValidation() {
		System.out.println("Test pageValidation test Executing");

	}

	@Test(priority = 1, groups = "smoke")
	public void doUserRegtest() {
		System.out.println("Test Regestratio test executing");

	}
}
