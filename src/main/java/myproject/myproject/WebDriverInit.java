package myproject.myproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverInit {

	public WebDriver driver;

	public WebDriver getWebdriver (String browserName) throws Exception {
		System.out.println("my browser is: "+ browserName);
		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			throw new Exception("please provide a valid browser name");
		}
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		return driver;
		
	}
	

}
