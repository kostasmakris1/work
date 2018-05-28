package myproject.myproject.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Integer.valueOf;

public class BasketPage {

	@FindBy(id = "add-to-cart-button")
	private WebElement addToBasketEl;

	@FindBy(id = "nav-cart-count")
	private WebElement quantityAddedEl;

	private WebDriver driver;

	public BasketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	 boolean isAddToBasketBtnDisplayed(){
		return addToBasketEl.isDisplayed();
	}

	public void addProductToBasket(){
		addToBasketEl.click();
	}

	public boolean productIsAddedToBasket(){
		String quantityTxt = quantityAddedEl.getText();
		return valueOf(quantityTxt)>0;
	}

}
