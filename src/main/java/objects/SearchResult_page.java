package objects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SearchResult_page {
	
	WebDriver driver;
	
	public SearchResult_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Samsung Galaxy Tab 10.1")
	private WebElement tablet;
	
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criteria.')]")
	private WebElement no_result;
	
	
	@FindBys({@FindBy(className = "product-thumb")})
	private List<WebElement> products;


	public WebElement getTablet() {
		return tablet;
	}


	public WebElement getNo_result() {
		return no_result;
	}


	public List<WebElement> getProducts() {
		return products;
	}
	
	public void Assert_with_valid_item() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfAllElements(products));
		String item = tablet.getText();
		Assert.assertEquals(item, "Samsung Galaxy Tab 10.1");
	}
	
	public void Assert_with_invalid_item() {
		String msg = no_result.getText();
		Assert.assertEquals(msg, "There is no product that matches the search criteria.");
	}
	
	public void Assert_with_valid_criteria() {
		int size = products.size();
		boolean t = false;
		if(size>=1) {
			t = true;
		}
		Assert.assertTrue(t);
	}
	
	public void Assert_with_blank_text() {
		String msg = no_result.getText();
		Assert.assertEquals(msg, "There is no product that matches the search criteria.");
		
	}
	
}
