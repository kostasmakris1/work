package myproject.myproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

/**
 * Created by c1766077 on 09/09/2016.
 */
public class Utils {

	public WebDriver driver;

	public Utils (WebDriver driver) {
		this.driver = driver;
	}

	public void getRandomProductPage () {

		// click on a random page from the displayed list at the bottom of the page
		List<WebElement> numberOfPagesList = driver.findElement(By.cssSelector("td[class='pages']")).findElements(By.tagName("a"));
		int numberOfPagesListSize = numberOfPagesList.size();
		Random rn = new Random();
		int pageNumber = rn.nextInt(numberOfPagesListSize +1) ;
		numberOfPagesList.get(pageNumber-1).click();
		System.out.println("page clicked: " + pageNumber);
	}

	public int getNumberOfItemsDisplayedPerPage() {
		WebElement resultItemsElement = driver
				.findElement(By.id("ListViewInner"));
		          // get the number of items displayed per page
		return   Integer.parseInt(driver.findElement(By.cssSelector("a[class='btn btn-s small btn-ter dropdown-toggle']")).getText());
	}


}
