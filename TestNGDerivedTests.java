package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDerivedTests extends BaseTest {	
	
	@Test
	void calcTest() {
		WebDriver driver = getDriver();
        
		WebElement element = driver.findElement(By.name("q")); 
        element.sendKeys("sqrt 16");
        element.submit();
        
        WebElement result = driver.findElement(By.id("cwos"));
        Assert.assertEquals(result.getText(), "4");
	}
	
	@Test
	void searchTest() {
		WebDriver driver = getDriver(BrowserType.FIREFOX, "http://www.google.com");
        
		WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium WebDriver");
        element.submit();
        
        (new WebDriverWait(driver, 15)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith("Selenium WebDriver");
            }
        });
        Assert.assertTrue(driver.getTitle().startsWith("Selenium WebDriver"));
	}

}
