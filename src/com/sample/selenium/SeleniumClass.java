package com.sample.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumClass {

	WebDriver driver;

	HttpURLConnection huc = null;

	@BeforeMethod
	public void beforemethodd() throws FileNotFoundException, IOException {

		// setting the path for the driver exe: / \\ \ reserved escape line character in
		// java: regular expression

		System.setProperty("webdriver.chrome.driver",
				"D:\\Eclipse_workspace_Nov2020_Batch\\NEW\\SeleniumTraining\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/upload/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 500 milli sec
		
		System.out.println(getProperty1());

	}

	@Test()
	public void testcase1(Method method) throws Exception {

		WebElement btnChooseFile = driver.findElement(By.xpath("//input[starts-with(@id,'uploadfile')]"));
		WebElement chkBoxTerms = driver.findElement(By.id("terms"));

		WebElement btnSubmit = driver.findElement(By.id("submitbutton"));

		WebElement lblSuccessMessage = driver.findElement(By.xpath("//center[contains(text(),'1')]"));

		btnChooseFile.sendKeys("C:\\Users\\pc\\Desktop\\Setup-Selenium\\index.html");

		chkBoxTerms.click();
		btnSubmit.click();

		TakesScreenshot screen = (TakesScreenshot) driver;

		File srcFile = screen.getScreenshotAs(OutputType.FILE);

		File dest = new File("./screenshot/" + method.getName() + ".png");

		FileUtils.copyFile(srcFile, dest);

	}

	@AfterMethod
	public void tearDOwn(ITestResult result) throws Exception {

		driver.quit();
	}

	public String getProperty1() throws FileNotFoundException, IOException {

		Properties pro = new Properties();

		pro.load(new FileInputStream("./config.properties"));

		return pro.getProperty("screenShot");
	}
}
