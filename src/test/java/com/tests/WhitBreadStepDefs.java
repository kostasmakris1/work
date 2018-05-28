package com.tests;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myproject.myproject.pages.BasketPage;
import myproject.myproject.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static java.lang.System.getProperty;
import static myproject.myproject.WebDriverFactory.getDriver;

public class WhitBreadStepDefs {

	private WebDriver driver =  getDriver(getProperty("browserName"));
	private BasketPage basketPage ;
	private HomePage homePage;

	public WhitBreadStepDefs(){
		basketPage = new BasketPage(driver);
		homePage = new HomePage(driver,basketPage);
	}

	@Given("^I am on amazon home page$")
	public void i_am_on_amazon_home_page() {
		Assert.assertTrue(homePage.isPageLoaded());

	}

	@When("^I search for product \"([^\"]*)\" from the search menu$")
	public void i_search_for_a_product_from_search_menu(String productName){
		Assert.assertTrue(homePage.searchProduct(productName));
	}

	@When("^I add the product to the basket$")
	public void i_add_the_product_to_the_basket()  {
		basketPage.addProductToBasket();
	}

	@Then("^the product is added to the basket$")
	public void the_product_is_added_to_the_basket()  {
		Assert.assertTrue(basketPage.productIsAddedToBasket());

	}

	@After
	public void tearDown () {
		if (driver != null) {
			driver.quit();
		}
	}
}
