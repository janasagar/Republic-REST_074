package objects;

//Import necessary packages and classes
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SearchResult_page {
    
    // WebDriver instance variable
    WebDriver driver;
    
    // Constructor to initialize the WebDriver and PageFactory
    public SearchResult_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize WebElements using PageFactory
    }
    
    // WebElement for Samsung Galaxy Tab 10.1 link
    @FindBy(linkText = "Samsung Galaxy Tab 10.1")
    private WebElement tablet;
    
    // WebElement for no result message
    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criteria.')]")
    private WebElement no_result;
    
    // List of WebElements representing products found in the search result
    @FindBys({@FindBy(className = "product-thumb")})
    private List<WebElement> products;

    // Getter method for tablet WebElement
    public WebElement getTablet() {
        return tablet;
    }

    // Getter method for no_result WebElement
    public WebElement getNo_result() {
        return no_result;
    }

    // Getter method for products list
    public List<WebElement> getProducts() {
        return products;
    }
    
    // Assertion method to validate if the valid item is displayed
    public void Assert_with_valid_item(String text) {
        // Get text from the tablet WebElement
        String item = tablet.getText();
        // Assert that the text matches text veriable
        Assert.assertEquals(item, text);
    }
    
    // Assertion method to validate if the invalid item message is displayed
    public void Assert_with_invalid_item() {
        // Get text from the no_result WebElement
        String msg = no_result.getText();
        // Assert that the message matches the expected no result message
        Assert.assertEquals(msg, "There is no product that matches the search criteria.");
    }
    
    // Assertion method to validate if the search criteria returns products
    public void Assert_with_valid_criteria() {
        // Get the size of the products list
        int size = products.size();
        // Initialize a boolean flag to false
        boolean t = false;
        // If there is at least one product, set the flag to true
        if (size >= 1) {
            t = true;
        }
        // Assert that the flag is true, indicating products were found
        Assert.assertTrue(t);
    }
    
    // Assertion method to validate if the blank search text returns no result message
    public void Assert_with_blank_text() {
        // Get text from the no_result WebElement
        String msg = no_result.getText();
        // Assert that the message matches the expected no result message
        Assert.assertEquals(msg, "There is no product that matches the search criteria.");
    }
}
