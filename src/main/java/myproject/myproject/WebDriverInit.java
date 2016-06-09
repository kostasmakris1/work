package myproject.myproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class WebDriverInit {

	public WebDriver driver;

	public WebDriver getWebdriver (String browserName) {
		driver = null;
		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		return driver;
		
	}
	

}
