package com.tests;

import myproject.myproject.WebDriverInit;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;

public class MyBasketStepDefs {
	
	public  WebDriver driver;
	public WebDriverInit webDriverInit;
	public String browserName ;
	
	
	@Given("^there are (\\d+) coffees$")
	public void there_are_coffees(int arg1) {
	   browserName = System.getProperty("browserName");
	   webDriverInit = new WebDriverInit();
	   driver = webDriverInit.getWebdriver(browserName);
	   
	   driver.get("http://www.msn.com/en-gb/");
	   driver.quit();
	   
	}

}
