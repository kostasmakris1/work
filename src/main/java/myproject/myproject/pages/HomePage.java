package myproject.myproject.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	@FindBy(css = "span[class='nav-logo-base nav-sprite']")
	private WebElement amazonLabel;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBoxEl;

	@FindBy(tagName = "h2")
	private WebElement fullDescriptionEl;

	private WebDriver driver;
    private BasketPage basketPage;
    private final static String AMAZON_URL = "https://www.amazon.co.uk/";

	public HomePage(WebDriver driver, BasketPage basketPage) {
		this.driver = driver;
		this.basketPage = basketPage;
		PageFactory.initElements(driver,this);
	}

	public boolean isPageLoaded() {

		driver.get(AMAZON_URL);
		return amazonLabel.getText().equals("Amazon.co.uk");
	}

	public boolean searchProduct(String productName) {

		searchBoxEl.sendKeys(productName);
		searchBoxEl.sendKeys(Keys.ENTER);
		String fullProductDescriptionTxt = fullDescriptionEl.getAttribute("data-attribute");
		driver.findElement(By.partialLinkText(fullProductDescriptionTxt)).click();

		return basketPage.isAddToBasketBtnDisplayed();
	}
}
	

