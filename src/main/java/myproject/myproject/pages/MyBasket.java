package myproject.myproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

public class MyBasket  {

	public WebDriver driver;
	
	public MyBasket (WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isItemAddedToBasked(String product) {
		
		boolean isItemAdded = false;
		
		if (product.equals("jamesdesign/product/beer-o-clock")) {
			driver.findElement(By.id("line_item_options_attributes_1_product_option_value_id_currency_GBP")).sendKeys("3");
			driver.findElement(By.id("line_item_options_attributes_2_product_option_value_id_currency_GBP")).sendKeys("regular - 28cm ");
			driver.findElement(By.id("qty")).clear();
			driver.findElement(By.id("qty")).sendKeys("1");
			driver.findElement(By.id("add_to_cart")).click();
			}
		else if (product.equals("outthereinteriors/product/distressed-heart-chair")) {
			driver.findElement(By.id("qty")).sendKeys("1");
			driver.findElement(By.id("add_to_cart")).click();
	
		}
		
		if (driver.findElement(By.id("shopping_buttons")).isDisplayed()){
			isItemAdded = true;
			}
		
		return isItemAdded;
		
		}
		
	
	
}
