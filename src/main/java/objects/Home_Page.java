package objects;

// Import necessary packages and classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
    // WebDriver instance variable
    WebDriver driver;
    
    // Constructor to initialize the WebDriver and PageFactory
    public Home_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize WebElements using PageFactory
    }
    
    // WebElement for the homepage link
    @FindBy(linkText = "Qafox.com")
    private WebElement homepage;
    
    // WebElement for the "My Account" menu
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement my_account;
    
    // WebElement for the register link
    @FindBy(linkText = "Register")
    private WebElement register;
    
    // WebElement for the login link
    @FindBy(linkText = "Login")
    private WebElement login;
    
    // WebElement for the search input field
    @FindBy(xpath = "(//input[@placeholder='Search'])[1]")
    private WebElement search_input;
    
    // WebElement for the search button
    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    private WebElement search_button;
    
    // WebElement for the logout link
    @FindBy(linkText = "Logout")
    private WebElement logout;
    
    // Getter method for homepage WebElement
    public WebElement getHomepage() {
        return homepage;
    }

    // Getter method for my_account WebElement
    public WebElement getMy_account() {
        return my_account;
    }

    // Getter method for register WebElement
    public WebElement getRegister() {
        return register;
    }

    // Getter method for login WebElement
    public WebElement getLogin() {
        return login;
    }

    // Getter method for search_input WebElement
    public WebElement getSearch_input() {
        return search_input;
    }

    // Getter method for search_button WebElement
    public WebElement getSearch_button() {
        return search_button;
    }
    
    // Getter method for logout WebElement
    public WebElement getLogout() {
        return logout;
    }

    // Method to navigate to the homepage
    public void Go_to_homepage() {
        homepage.click();
    }
    
    // Method to navigate to the registration page
    public void Register() {
        my_account.click();   // Click on "My Account"
        register.click();     // Click on "Register"
    }

    // Method to navigate to the login page
    public void Login() {
        my_account.click();   // Click on "My Account"
        login.click();        // Click on "Login"
    }
    
    // Method to search with given data
    public void Search_with_data(String text) throws InterruptedException {
        search_input.sendKeys(text); // Enter search text
        search_button.click();       // Click on search button
        Thread.sleep(4000);          // Wait for 4 seconds
        search_input.clear();        // Clear the search input
    }
    
    // Method to perform search with blank text
    public void Search_with_blank() {
        search_input.clear();        // Clear the search input
        search_button.click();       // Click on search button
    }
    
    // Method to log out
    public void Logout() {
        my_account.click();          // Click on "My Account"
        logout.click();              // Click on "Logout"
    }
}
