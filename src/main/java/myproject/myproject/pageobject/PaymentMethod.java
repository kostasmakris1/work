package myproject.myproject.pageobject;

import myproject.myproject.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class PaymentMethod implements Locators {

		private WebDriver driver ;

		public PaymentMethod (WebDriver driver)
		{
			this.driver = driver;
		}


		public Boolean isPaymentMethodPageDisplayed () throws InterruptedException {

			Boolean displayed;
			Thread.sleep(1000);
			try {
				displayed = driver.findElement(By.id(PAYMENT_FIELDSET_KEY)).isDisplayed();
			}
			catch (ElementNotVisibleException e){
				displayed = false;
			}
			return  displayed;
		}


	public Boolean completePaymentMethodForm(String cardType, String cardNo, String expiryMonth, String expiryYear, String nameOnCard) throws InterruptedException {

	new Select (driver.findElement(By.id(SELECT_CARD_KEY))).selectByVisibleText(cardType);
	driver.findElement(By.id(CARD_NUMBER_KEY)).sendKeys(cardNo);
	new Select(driver.findElement(By.id(EXPIRY_MONTH_KEY))).selectByVisibleText(expiryMonth);
	new Select(driver.findElement(By.id(EXPIRY_YEAR_KEY))).selectByVisibleText(expiryYear);
	driver.findElement(By.id(NAME_ON_CARD_KEY)).sendKeys(nameOnCard);
	WebElement continueBtnElem = driver.findElement(By.xpath(CONTINUE_PAYM_KEY));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style', 'visibility: visible;');", continueBtnElem);
	Thread.sleep(1000);
	continueBtnElem.click();

		return new BillingAddress(driver).isBillingAddressDisplayed();
}

}
