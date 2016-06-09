package myproject.myproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class WebDriverInit {

	public WebDriver driver;

	public WebDriver getWebdriver (String browserName) {
		driver = null;
		System.out.println("********");
		if (browserName.equals("firefox")) {
			System.out.println("&&&&&&&");
			driver = new FirefoxDriver();
		}
		return driver;
		
	}
	

}
