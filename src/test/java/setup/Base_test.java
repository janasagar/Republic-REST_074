package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import objects.Home_Page;
import objects.Login_Page;
import objects.Register_Page;
import objects.SearchResult_page;

public class Base_test {
	protected WebDriver driver;
	protected String url;
	protected String search_text1;
	protected String search_text2;
	protected String search_text3;
	protected String FirstName;
	protected String LastName;
	protected String Email;
	protected String Phone;
	protected String Password;
	protected String RePassword;
	protected Home_Page hp;
	protected Register_Page rp;
	protected Login_Page lp;
	protected SearchResult_page sp;
	
	
	@BeforeTest
	public void setup() throws IOException {
		driver = new ChromeDriver();
		
		Properties pr = new Properties();
		FileInputStream fl = new FileInputStream("E:\\CW-B37\\Opencart_Automation_Testing\\src\\test\\resources\\config.properties");
		pr.load(fl);
		
		url = pr.getProperty("url");
		search_text1 = pr.getProperty("search_text1");
		search_text2 = pr.getProperty("search_text2");
		search_text3 = pr.getProperty("search_text3");
		FirstName = pr.getProperty("firstName");
		LastName = pr.getProperty("lastName");
		Email = pr.getProperty("Email");
		Phone = pr.getProperty("Phone");
		Password = pr.getProperty("Password");
		RePassword = pr.getProperty("RePassword");
		
		
		hp = new Home_Page(driver);
		rp = new Register_Page(driver);
		lp = new Login_Page(driver);
		sp = new SearchResult_page(driver);
		
		driver.get(url);
		driver.manage().window().maximize();;
			
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}
