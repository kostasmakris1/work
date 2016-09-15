package myproject.myproject.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResults {

	public WebDriver driver;

	public  SearchResults (WebDriver driver) {
		this.driver = driver;
	}

	public Boolean searchResultsPageIsDisplayed () {

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='listing-results-utils-view clearfix bg-muted']"))));
		return driver.findElement(By.cssSelector("div[class='listing-results-utils-view clearfix bg-muted']")).isDisplayed();

	}

	public Boolean rentalTypeIsDisplayed (String type) {
		return driver.findElement(By.cssSelector("h1[style='font-weight: normal; margin-bottom: 1.4em; margin-top: .2em;']")).getText().contains("rent");
	}

	public Boolean viewTypeIsEnabled(String viewType) throws InterruptedException {

		Boolean isEnabled = false;
		Thread.sleep(2000);
		try {
			isEnabled = driver.findElement(By.cssSelector("span[class='listing-view-link is-active']")).getAttribute("title").equals(viewType);
		}
		catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
		return  isEnabled;
	}

	public  void selectView(String viewType) {

		WebElement viewElem = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]"));
        WebElement e = viewElem.findElement(By.cssSelector("div[class='fright']"));

		if (viewType.equals("Grid view")) {
			e.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[3]/span"));
		}

		e.click();

	}
}
