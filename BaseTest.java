package testing;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

// Super class for all following derived tests
public class BaseTest {
	private static List<WebDriver> driverPool = new ArrayList<WebDriver>();
	
	// load config files, open DB connections, setup logging
	@BeforeSuite
	void setUpSuite() { 
		System.setProperty("webdriver.chrome.driver", "C:/Users/patri/Downloads/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:/Users/patri/Downloads/geckodriver.exe");
	}
	
	WebDriver getDriver() {
		return getDriver(BrowserType.CHROME, "https://www.google.com");
	}
	
	WebDriver getDriver(BrowserType type, String baseURL) {
		WebDriver driver = DriverFactory.getInstance().getDriver(type);
		driverPool.add(driver);
		driver.get(baseURL);
		return driver;
	}
	
	// close the files and the connections
	@AfterSuite
	void tearDownSuite() {
		for(WebDriver webDriver : driverPool) {
			webDriver.quit();
		}
	}

}
