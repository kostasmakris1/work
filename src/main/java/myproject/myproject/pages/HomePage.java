package myproject.myproject.pages;

import myproject.myproject.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isPageLoaded () {

		return driver.findElement(By.cssSelector("input[value='Search']")).isDisplayed();
	}


	public void  selectCategory (String category, String item) {
		Select categoriesElement = new Select(driver.findElement(By.id("gh-cat")));
		categoriesElement.selectByVisibleText(category);
	}

	public void searchForItem(String item) {
		driver.findElement(By.cssSelector("input[placeholder='Search...']")).sendKeys(item);
		driver.findElement(By.cssSelector("input[value='Search']")).click();

	}

	public void sortBySearch(String sorting) {
		WebElement dropDownMenu = driver.findElement(By.id("SortMenu"));
		           // use java script executor to make the web element visible
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'visibility: visible;');", dropDownMenu);
		List<WebElement> options = dropDownMenu.findElements(By.tagName("li"));

		for (WebElement option : options) {
			if(sorting.equals(option.getText()))
				option.click();
			break;
		}

		driver.findElement(By.cssSelector("input[value='Search']")).click();

	}

	public void freePostageAndPriceDisplayedForAllItems() {

		Utils util = new Utils(driver);
		util.getRandomProductPage();
		int itemsPerPage = util.getNumberOfItemsDisplayedPerPage();

		// iterate through the number of total items per page and validate
		WebElement resultItemsElement = driver
				.findElement(By.id("ListViewInner"));
		for (int i = 1; i <= itemsPerPage; i++) {
			WebElement itemInfoElement = resultItemsElement.findElement(By.cssSelector("li[r='" + i + "']"));
			String itemDescription = itemInfoElement.findElement(By.cssSelector("h3[class='lvtitle']")).findElement(By.cssSelector("a[class='vip']")).getText();
			String itemPrice = itemInfoElement.findElement(By.cssSelector("ul[class='lvprices left space-zero']")).findElement(By.cssSelector("li[class='lvprice prc']")).getText();
			List<WebElement> options = itemInfoElement.findElements(By.tagName("ul"));
			String postageText = options.get(0).findElements(By.tagName("li")).get(2).findElement(By.cssSelector("span[class='ship']")).getText();

			Assert.assertNotNull("No price displayed for " + itemDescription,itemPrice);
			Assert.assertEquals("No free postage displayed for " + itemDescription, "Free Postage", postageText);

		}
	}


	public void priceDisplayedForAllItems() {

		Utils util = new Utils(driver);
		util.getRandomProductPage();
		int itemsPerPage = util.getNumberOfItemsDisplayedPerPage();

		// iterate through the number of total items per page and validate
		WebElement resultItemsElement = driver
				.findElement(By.id("ListViewInner"));
		for (int i = 1; i <= itemsPerPage; i++) {
			WebElement itemInfoElement = resultItemsElement.findElement(By.cssSelector("li[r='" + i + "']"));
			String itemDescription = itemInfoElement.findElement(By.cssSelector("h3[class='lvtitle']")).findElement(By.cssSelector("a[class='vip']")).getText();
			String itemPrice = itemInfoElement.findElement(By.cssSelector("ul[class='lvprices left space-zero']")).findElement(By.cssSelector("li[class='lvprice prc']")).getText();
			Assert.assertNotNull("No price displayed for " + itemDescription,itemPrice);

		}
	}


	public void bidPriceDisplayedForAllItems() {

		Utils util = new Utils(driver);
		util.getRandomProductPage();
		int itemsPerPage = util.getNumberOfItemsDisplayedPerPage();

		// iterate through the number of total items per page and validate
		WebElement resultItemsElement = driver
				.findElement(By.id("ListViewInner"));
		for (int i = 1; i <= itemsPerPage; i++) {
			WebElement itemInfoElement = resultItemsElement.findElement(By.cssSelector("li[r='" + i + "']"));
			String itemDescription = itemInfoElement.findElement(By.cssSelector("h3[class='lvtitle']")).findElement(By.cssSelector("a[class='vip']")).getText();
			String bidPrice = itemInfoElement.findElement(By.cssSelector("ul[class='lvprices left space-zero']")).findElement(By.cssSelector("li[class='lvformat']")).getText();
			Assert.assertNotNull("No bid price displayed for " + itemDescription,bidPrice);

		}
	}


	public void buyItNowLogoDisplayedForAllItems() {

		Utils util = new Utils(driver);
		util.getRandomProductPage();
		int itemsPerPage = util.getNumberOfItemsDisplayedPerPage();

		// iterate through the number of total items per page and validate
		WebElement resultItemsElement = driver
				.findElement(By.id("ListViewInner"));
		for (int i = 1; i <= itemsPerPage; i++) {
			WebElement itemInfoElement = resultItemsElement.findElement(By.cssSelector("li[r='" + i + "']"));
			String itemDescription = itemInfoElement.findElement(By.cssSelector("h3[class='lvtitle']")).findElement(By.cssSelector("a[class='vip']")).getText();
			Boolean isBuyItNow = itemInfoElement.findElement(By.cssSelector("ul[class='lvprices left space-zero']")).findElement(By.cssSelector("li[class='lvformat']")).findElement(By.tagName("span")).findElement(By.cssSelector("span[title='Buy it now']")).isDisplayed();
			Assert.assertTrue("No buy it now logo displayed for " + itemDescription,isBuyItNow);

		}
	}



}
	

