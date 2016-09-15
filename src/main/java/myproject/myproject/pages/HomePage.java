package myproject.myproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriver driver;

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isPageLoaded () {

		driver.get("http://www.zoopla.co.uk/");
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("logo"))));
		return driver.findElement(By.id("logo")).isDisplayed();
	}


public Boolean getPropertyRentSection () {
    driver.findElement(By.cssSelector("a[href='/to-rent/']")).click();
	return driver.findElement(By.cssSelector("p[class='h-subheader']")).getText().equals("Search for houses and flats to rent across the UK");

}




}
	

