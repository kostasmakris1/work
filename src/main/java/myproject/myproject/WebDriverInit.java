package myproject.myproject;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverInit {

	public WebDriver driver;

	public void getWebdriver (String webDriverName) {

		driver = null;
		if (webDriverName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (webDriverName.equals("chrome")) {

		}
		else if (webDriverName.equals("ie")) {

		}
		else {

		}
	}

	@After
	public  void tearDown () {
		if (driver != null) {
			driver.quit();
		}
	}

}
