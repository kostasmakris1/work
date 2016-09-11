package com.tests;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import myproject.myproject.WebDriverInit;
import myproject.myproject.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbayStepDefs {
	
	// public  WebDriver driver;
	String browserName = System.getProperty("browserName");
	WebDriver driver = new WebDriverInit().getWebdriver(browserName);
	HomePage homePage = new HomePage(driver);

	public EbayStepDefs() throws Exception {
	}


	@Given("^I am on the ebay home page$")
	public void i_am_on_the_ebay_home_page()   {

		driver.get("http://www.ebay.co.uk/");

		Assert.assertTrue(homePage.isPageLoaded());

	}


	@When("^I filter my search by (All listings|Auction|Buy it now)$")
	public void i_filter_my_search_by(String filter)  {
		driver.findElement(By.cssSelector("a[title='" + filter + "']")).click();
	}

	@And("^I sort my search by \"([^\"]*)\"$")
	public void I_sort_my_search_By(String sorting)  {
	homePage.sortBySearch(sorting);
	}

	@And("^I search for an item \"([^\"]*)\"$")
	public void i_search_for_an_item(String item)  {
		homePage.searchForItem(item);
	}

	@When("^I search for category \"([^\"]*)\" and item \"([^\"]*)\"$")
	public void i_search_for_category_and_item(String category, String item)  {
		homePage.selectCategory(category, item);
	}

	@Then("^free postage and price are displayed for all items$")
	public void free_postage_is_displayed_for_all_items()  {
    homePage.freePostageAndPriceDisplayedForAllItems();
	}

	@Then("^price is displayed for all items$")
	public void price_is_displayed_for_all_items()  {
		homePage.priceDisplayedForAllItems();
	}

	@Then("^bid price is displayed for all items$")
	public void bid_price_is_displayed_for_all_items()  {
		homePage.bidPriceDisplayedForAllItems();
	}

	@Then("^buy it now logo is displayed for all items$")
	public void buy_it_now_logo_is_displayed_for_all_items()  {
		homePage.buyItNowLogoDisplayedForAllItems();
	}

	
@After
public void tearDown () {
	if (driver !=null) {
	driver.quit();
	}
}
}
