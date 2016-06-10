package myproject.myproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverInit {

	public WebDriver driver;

	public WebDriver getWebdriver (String browserName) {
		System.out.println("my browser is: "+ browserName);
		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		return driver;
		
	}
	

}
