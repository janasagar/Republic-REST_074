package objects;

// Import necessary packages and classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Register_Page {
    // WebDriver instance variable
    WebDriver driver;
    
    // Constructor to initialize the WebDriver and PageFactory
    public Register_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize WebElements using PageFactory
    }
    
    // WebElement for the first name input field
    @FindBy(name = "firstname")
    private WebElement firstname;
    
    // WebElement for the last name input field
    @FindBy(name = "lastname")
    private WebElement lastname;
    
    // WebElement for the email input field
    @FindBy(name = "email")
    private WebElement email;
    
    // WebElement for the telephone input field
    @FindBy(name = "telephone")
    private WebElement telephone;
    
    // WebElement for the password input field
    @FindBy(name = "password")
    private WebElement pass;
    
    // WebElement for the confirm password input field
    @FindBy(name = "confirm")
    private WebElement confirm_pass;
    
    // WebElement for the terms and conditions checkbox
    @FindBy(name = "agree")
    private WebElement agree_checkBox;
    
    // WebElement for the submit button
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement submit_button;
    
    // WebElement for the confirmation message after successful registration
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement con_msg;

    // Getter method for firstname WebElement
    public WebElement getFirstname() {
        return firstname;
    }

    // Getter method for lastname WebElement
    public WebElement getLastname() {
        return lastname;
    }

    // Getter method for email WebElement
    public WebElement getEmail() {
        return email;
    }

    // Getter method for telephone WebElement
    public WebElement getTelephone() {
        return telephone;
    }

    // Getter method for password WebElement
    public WebElement getPassword() {
        return pass;
    }

    // Getter method for confirm_pass WebElement
    public WebElement getConfirm_pass() {
        return confirm_pass;
    }

    // Getter method for agree_checkBox WebElement
    public WebElement getAgree_checkBox() {
        return agree_checkBox;
    }

    // Getter method for submit_button WebElement
    public WebElement getSubmit_button() {
        return submit_button;
    }
    
    // Getter method for con_msg WebElement
    public WebElement getCon_msg() {
        return con_msg;
    }
    
    // Method to fill out the registration form and submit it
    public void sign_up(String f_name, String l_name, String email_id, String contact_num, String password, String re_pass) {
        firstname.sendKeys(f_name);        // Enter first name
        lastname.sendKeys(l_name);         // Enter last name
        email.sendKeys(email_id);          // Enter email
        telephone.sendKeys(contact_num);   // Enter telephone number
        pass.sendKeys(password);           // Enter password
        confirm_pass.sendKeys(re_pass);    // Confirm password
        agree_checkBox.click();            // Agree to terms and conditions
        submit_button.click();             // Submit the registration form
    }
    
    // Method to assert that the registration was successful
    public void Assert_successful_registration() {
        // Get text from the confirmation message WebElement
        String msg = con_msg.getText();
        // Check if the message contains "Created!"
        boolean t = msg.contains("Created!");
        // Assert that the message contains "Created!"
        Assert.assertTrue(t);
    }
}
