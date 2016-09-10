package myproject.myproject.pageobject;


import myproject.myproject.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

public class ReviewAndDonate  implements Locators{

	private WebDriver driver ;

	public ReviewAndDonate (WebDriver driver) {
		this.driver = driver;
	}


public  Boolean isReviewAndDonatePageDisplayed() throws InterruptedException {
	Boolean displayed;
	Thread.sleep(1000);
	try {
		displayed = driver.findElement(By.id(REVIEW_AND_DONATE_KEY)).isDisplayed();
	}
	catch (ElementNotVisibleException e) {
		displayed = false;
	}
	return displayed;
}


}
