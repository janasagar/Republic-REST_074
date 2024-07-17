package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResult_page {
	
	WebDriver driver;
	
	public SearchResult_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Samsung Galaxy Tab 10.1")
	private WebElement tablet;
	
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement no_result;
	
	@FindBy(className = "product-thumb")
	private WebElement products;

}
