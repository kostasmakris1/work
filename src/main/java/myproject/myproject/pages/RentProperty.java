package myproject.myproject.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentProperty {

	public WebDriver  driver;

	public RentProperty (WebDriver driver) {
		this.driver = driver;
	}

	public Boolean searchProperty(String area, String minPrice, String maxPrice, String propertyType) {

		driver.findElement(By.id("search-input-location")).sendKeys(area);
		driver.findElement(By.id("search-input-location")).sendKeys(Keys.TAB);
		new Select(driver.findElement(By.id("rent_price_min_per_month"))).selectByVisibleText(minPrice);
		new Select(driver.findElement(By.id("rent_price_max_per_month"))).selectByVisibleText(maxPrice);
		new Select(driver.findElement(By.id("property_type"))).selectByVisibleText(propertyType);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("search-submit"))));
		Actions actions = new Actions(driver);
		WebElement searchElem = driver.findElement(By.id("search-submit"));
		actions.moveToElement(searchElem).click().perform();

		return new SearchResults(driver).searchResultsPageIsDisplayed();
	}
}
