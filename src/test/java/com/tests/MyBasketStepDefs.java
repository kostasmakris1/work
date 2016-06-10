package com.tests;

import myproject.myproject.WebDriverInit;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;

public class MyBasketStepDefs {
	
	public  WebDriver driver;
	
	@Given("^there are coffees$")
	public void there_are_coffees() {
	   String browserName = System.getProperty("browserName");
	  
	   driver = new WebDriverInit().getWebdriver(browserName);
	   driver.get("http://www.msn.com/en-gb/");
	    
	}
	
@After
public void tearDown () {
	driver.quit();
}
}
