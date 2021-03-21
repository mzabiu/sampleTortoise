package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.xml.XmlTest;

import com.sample.listeners.DriverListener;

public class BaseClass {

	public WebDriver driver;

	public RemoteWebDriver remoteDriver;
	public EventFiringWebDriver eventDriver;
	public DriverListener driverListener;

	@BeforeMethod(alwaysRun = true)
	public void setUp(ITestResult result, XmlTest config) throws Exception {
		String projectPath = System.getProperty("user.dir");
		String chromeDriverPath = projectPath + "/drivers/chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		ChromeOptions options = new ChromeOptions();

		options.setAcceptInsecureCerts(true);
		options.addArguments("start-maximized");

		driver = new ChromeDriver(options);

		String url = "https://opensource-demo.orangehrmlive.com/";

		driver.get(url);

		Reporter.setCurrentTestResult(result);
		Reporter.log("Opened the application URL " + url);
		System.out.println("initializing Everything...");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
		System.out.println("Quitting Everything...");

	}

}
