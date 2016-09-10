package myproject.myproject.pageobject;

import myproject.myproject.Constants;
import myproject.myproject.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Amount implements Constants, Locators{

	private  WebDriver driver ;

	public Amount (WebDriver driver)
	{
		this.driver = driver;
	}


public Boolean getAmountPage () {

	driver.get(JUST_GIVING_PAGE_URL);
	new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(CHOOSE_AMOUNT_LABEL_KEY))));
	return driver.findElement(By.cssSelector(CHOOSE_AMOUNT_LABEL_KEY)).isDisplayed();
}


public Boolean completeAmountForm(String currency, String amount, Boolean hideDonation, String message, String name, String email, String password) throws InterruptedException {


	new Select(driver.findElement(By.id(SELECT_CURRENCY_KEY))).selectByVisibleText(currency);
	driver.findElement(By.id(AMOUNT_FIELD_KEY)).clear();
	driver.findElement(By.id(AMOUNT_FIELD_KEY)).sendKeys(amount);
	if (hideDonation) {
		driver.findElement(By.id(HIDE_AMOUNT_KEY)).click();
	}
	driver.findElement(By.id(MESSAGE_FIELD_KEY)).sendKeys(message);
	driver.findElement(By.id(NAME_FIELD_KEY)).sendKeys(name);
	WebElement continueBtnElem = driver.findElement(By.cssSelector(CONTINUE_BTN_KEY));
	continueBtnElem.click();
	driver.findElement(By.id(EMAIL_ADDRESS_FIELD_KEY)).sendKeys(email);
	WebElement contBtnEmailFieldElement = driver.findElement(By.xpath(CONTINUE_BTN_EMAIL_KEY));
	Thread.sleep(1000);
	// use java script executor to make the web element visible
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style', 'visibility: visible;');", contBtnEmailFieldElement);
	Thread.sleep(1000);
	contBtnEmailFieldElement.click();
	driver.findElement(By.id(PASSWORD_FIELD_KEY)).sendKeys(password);
	WebElement contBtnPaswFieldElement = driver.findElement(By.xpath(CONTINUE_BTN_PASSWD_KEY));
	Thread.sleep(1000);
	// use java script executor to make the web element visible
	js.executeScript("arguments[0].setAttribute('style', 'visibility: visible;');", contBtnPaswFieldElement);
	Thread.sleep(100);
	contBtnPaswFieldElement.click();

    return new PaymentMethod(driver).isPaymentMethodPageDisplayed();
}

}
