package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	WebDriver driver;
	
	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "email")
	private WebElement emailid;
	
	@FindBy(name = "password")
	private WebElement pass;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement login;

	
	public WebElement getEmailid() {
		return emailid;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLogin() {
		return login;
	}
	
	public void sign_in(String email_id, String password) {
		emailid.sendKeys(email_id);
		pass.sendKeys(password);
		login.click();
	}

}
