package com.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.tests"},features = "src/test/java/com/tests/my_basket.feature", format = {"pretty",
"json:target/cucumber-reports/cucumber.json"})
public class MyBasketTests {

}
