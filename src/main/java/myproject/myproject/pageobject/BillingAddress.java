package myproject.myproject.pageobject;

import myproject.myproject.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public  class BillingAddress implements Locators {

	private WebDriver driver ;

	public BillingAddress(WebDriver driver) {
		this.driver = driver;
	}


 public Boolean isBillingAddressDisplayed() throws InterruptedException {
 	 Boolean displayed;
	 Thread.sleep(1000);
	 try {
		 displayed = driver.findElement(By.id(BILLING_ADDRESS_FIELDET_KEY)).isDisplayed();
	 }
	 catch (ElementNotVisibleException e) {
	 	displayed = false;
	 }
	 return displayed;
}

public Boolean completeBillingAddressForm(String country, String addressLine1, String city, String postcode) throws InterruptedException {

	new Select(driver.findElement(By.id(BILLING_ADDRESS_COUNTRY_KEY))).selectByVisibleText(country);
	driver.findElement(By.id(BILLING_ADDRESS_LINE1_KEY)).sendKeys(addressLine1);
	driver.findElement(By.id(BILLING_CITY_KEY)).sendKeys(city);
	driver.findElement(By.id(BILLING_POSTCODE_KEY)).sendKeys(postcode);
	WebElement continueBtnElem = driver.findElement(By.xpath(CONTINUE_BTN_BILLING_KEY));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style', 'visibility: visible;');", continueBtnElem);
	Thread.sleep(1000);
	continueBtnElem.click();

	return new ReviewAndDonate(driver).isReviewAndDonatePageDisplayed();
}

}
