package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	WebDriver driver;
	
	public Home_Page(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Qafox.com")
	private WebElement homepage;
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement my_account;
	
	@FindBy(linkText = "Register")
	private WebElement register;
	
	@FindBy(linkText = "Login")
	private WebElement login;
	
	@FindBy(xpath = "(//input[@placeholder='Search'])[1]")
	private WebElement search_input;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement search_button;
	
	@FindBy(linkText = "Logout")
	private WebElement logout;
	
	
	
	public WebElement getHomepage() {
		return homepage;
	}

	
	public WebElement getMy_account() {
		return my_account;
	}

	

	public WebElement getRegister() {
		return register;
	}

	

	public WebElement getLogin() {
		return login;
	}

	

	public WebElement getSearch_input() {
		return search_input;
	}

	

	public WebElement getSearch_button() {
		return search_button;
	}
	
	public WebElement getLogout() {
		return logout;
	}

	public void Go_to_homepage() {
		homepage.click();
	}
	
	public void Register() {
		my_account.click();
		register.click();
	}
	public void Login() {
		my_account.click();
		login.clear();
	}
	
	public void Search_with_data(String text) throws InterruptedException {
		search_input.sendKeys(text);
		search_button.click();
		Thread.sleep(4000);
		search_input.clear();
	}
	
	public void Search_with_blank() {
		search_input.clear();
		search_button.click();
	}
	
	public void Logout() {
		my_account.click();
		logout.click();
	}
	
	

}
