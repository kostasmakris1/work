package com.tests;

import myproject.myproject.WebDriverInit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;

public class MyBasketStepDefs {
	
	public  WebDriver driver;
	public String browserName ;
	WebDriverInit webDriverInit = new WebDriverInit();
	
	@Given("^there are coffees$")
	public void there_are_coffees() {
	  browserName = System.getProperty("browserName");
	  
	   
	   
	   //driver = webDriverInit.getWebdriver(browserName);
	   //driver.get("http://www.msn.com/en-gb/");
	   //driver.quit();
	   
	}
	
@After
public void tearDown () {
	driver.quit();
}
}
