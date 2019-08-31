package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	//Singleton design pattern
	private static final DriverFactory instance = new DriverFactory();
	
	private DriverFactory() {		
	}
	
	public static DriverFactory getInstance() {
		return instance;
	}
	
	
	// Factory design pattern
	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver(BrowserType type) {
		if (threadLocal.get() == null) {
			switch (type) {
			case CHROME:
				threadLocal.set(new ChromeDriver());
				break;
			case FIREFOX:
				threadLocal.set(new FirefoxDriver());
				break;
			default:
				break;
			}
		}
		return threadLocal.get();
	}

}
