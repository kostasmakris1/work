package com.tests;

import junit.framework.Assert;
import myproject.myproject.WebDriverInit;
import myproject.myproject.pages.MyBasket;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class MyBasketStepDefs {
	
	public  WebDriver driver;
	
	@When("^I add a product to basket \"([^\"]*)\"$")
	public void there_are_coffees(String product) throws Exception {
	   String browserName = System.getProperty("browserName");
	  
	   driver = new WebDriverInit().getWebdriver(browserName);
	   MyBasket myBasket = new MyBasket (driver);
	   driver.get("http://www.notonthehighstreet.com/" + product);
	  
	   Assert.assertTrue(myBasket.isItemAddedToBasked(product));
	  
	}
	
@After
public void tearDown () {
	if (driver !=null) {
	driver.quit();
	}
}
}
