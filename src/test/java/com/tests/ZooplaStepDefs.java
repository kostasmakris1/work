package com.tests;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myproject.myproject.WebDriverInit;
import myproject.myproject.pages.HomePage;
import myproject.myproject.pages.RentProperty;
import myproject.myproject.pages.SearchResults;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ZooplaStepDefs {
	
	// public  WebDriver driver;
	String browserName = System.getProperty("browserName");
	WebDriver driver = new WebDriverInit().getWebdriver(browserName);
	HomePage homePage = new HomePage(driver);
	RentProperty rentProperty = new RentProperty(driver);
	SearchResults searchResults = new SearchResults(driver);

	public ZooplaStepDefs() throws Exception {

	}


	@Given("^I am on zoopla home page$")
	public void i_am_on_zoopla_home_page() {
		Assert.assertTrue(homePage.isPageLoaded());

	}

	@When("^I navigate to the rent property section$")
	public void i_navigate_to_the_rent_property_section()  {
    Assert.assertTrue(homePage.getPropertyRentSection());
	}


	@When("^I search for a property in \"([^\"]*)\" with minimum price \"([^\"]*)\" maximum price \"([^\"]*)\"  and type \"([^\"]*)\"$")
	public void i_search_for_a_property_in_with_minimum_price_maximum_price_and_type(String area, String minPrice, String maxPrice, String type)  {

		Assert.assertTrue(rentProperty.searchProperty(area,minPrice,maxPrice,type));
	}

	@Then("^rental type is correct \"([^\"]*)\"$")
	public void rental_type_is_correct(String type)  {
	 Assert.assertTrue(searchResults.rentalTypeIsDisplayed(type));
	}

	@Then("^view type \"([^\"]*)\" is enabled$")
	public void view_type_is_enabled(String viewType) throws InterruptedException {
		Assert.assertTrue(searchResults.viewTypeIsEnabled(viewType));
	}

	@Then("^view type \"([^\"]*)\" is disabled")
	public void view_type_is_disabled(String viewType) throws InterruptedException {
		Assert.assertFalse(searchResults.viewTypeIsEnabled(viewType));
	}

	@When("^I select view \"([^\"]*)\"$")
	public void i_select_view(String viewType) throws Throwable {

     searchResults.selectView(viewType);
	}
	
@After
public void tearDown () {
	if (driver !=null) {
	 driver.quit();
	}
}
}
