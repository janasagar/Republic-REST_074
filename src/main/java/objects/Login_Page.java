package objects;

// Import necessary packages and classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
    // WebDriver instance variable
    WebDriver driver;
    
    // Constructor to initialize the WebDriver and PageFactory
    public Login_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize WebElements using PageFactory
    }
    
    // WebElement for the email input field
    @FindBy(name = "email")
    private WebElement emailid;
    
    // WebElement for the password input field
    @FindBy(name = "password")
    private WebElement pass;
    
    // WebElement for the login button
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement login;

    // Getter method for emailid WebElement
    public WebElement getEmailid() {
        return emailid;
    }

    // Getter method for pass WebElement
    public WebElement getPass() {
        return pass;
    }

    // Getter method for login WebElement
    public WebElement getLogin() {
        return login;
    }
    
    // Method to fill out the login form and submit it
    public void sign_in(String email_id, String password) {
        emailid.sendKeys(email_id);  // Enter email ID
        pass.sendKeys(password);     // Enter password
        login.click();               // Click the login button
    }
}
