package myproject.myproject.pages;

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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'visibility: visible;');", dropDownMenu);
		List<WebElement> options = dropDownMenu.findElements(By.tagName("li"));

		for (WebElement option : options) {
			if(sorting.equals(option.getText()))
				option.click();
			break;
		}

	}
	
}
