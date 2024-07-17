package objects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Register_Page {
	WebDriver driver;
	
	public Register_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "firstname")
	private WebElement firstname;
	
	@FindBy(name = "lastname")
	private WebElement lastname;
	
	@FindBy(name = "email")
	private WebElement email;
	
	@FindBy(name = "telephone")
	private WebElement telephone;
	
	@FindBy(name = "password")
	private WebElement pass;
	
	@FindBy(name = "confirm")
	private WebElement confirm_pass;
	
	@FindBy(name = "agree")
	private WebElement agree_checkBox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement submit_button;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement con_msg;

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getTelephone() {
		return telephone;
	}

	public WebElement getPassword() {
		return pass;
	}

	public WebElement getConfirm_pass() {
		return confirm_pass;
	}

	public WebElement getAgree_checkBox() {
		return agree_checkBox;
	}

	public WebElement getSubmit_button() {
		return submit_button;
	}
	
	public WebElement getCon_msg() {
		return con_msg;
	}
	public void sign_up(String f_name,String l_name,String email_id, String contact_num, String password, String re_pass) {
		firstname.sendKeys(f_name);
		lastname.sendKeys(l_name);
		email.sendKeys(email_id);
		telephone.sendKeys(contact_num);
		pass.sendKeys(password);
		confirm_pass.sendKeys(re_pass);
		agree_checkBox.click();
		submit_button.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(con_msg));
		String msg = con_msg.getText();
		boolean t = msg.contains("Created!");
		Assert.assertTrue(t);
		
				
	}
	
	

}
