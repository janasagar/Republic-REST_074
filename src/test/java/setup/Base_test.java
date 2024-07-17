package setup;

//Import necessary packages and classes
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objects.Home_Page;
import objects.Login_Page;
import objects.Register_Page;
import objects.SearchResult_page;


//Base_test class that sets up the WebDriver and other configurations
public class Base_test {
	// Declare protected variables for WebDriver, ExtentReports, ExtentTest, and test data
	protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;
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
	
	// Setup method to initialize WebDriver, ExtentReports, and load properties
	@BeforeTest
	public void setup() throws IOException, InterruptedException {
		driver = new ChromeDriver(); // Initialize ChromeDriver
		
		// Set up ExtentReports
		ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
		
     // Load properties from the config file
		Properties pr = new Properties();
		FileInputStream fl = new FileInputStream("E:\\CW-B37\\Opencart_Automation_Testing\\src\\test\\resources\\config.properties");
		pr.load(fl);
		
		// Retrieve properties
		url = pr.getProperty("url");
		search_text1 = pr.getProperty("search_text1");
		search_text2 = pr.getProperty("search_text2");
		search_text3 = pr.getProperty("search_text3");
		FirstName = pr.getProperty("firstName");
		LastName = pr.getProperty("lastName");
		String BaseEmail = pr.getProperty("Email");
		String random = RandomStringUtils.randomAlphanumeric(3);
		Email = "sagar" + random + BaseEmail; // Generate random email
		Phone = pr.getProperty("Phone");
		Password = pr.getProperty("Password");
		RePassword = pr.getProperty("RePassword");
		
		// Initialize page objects
		hp = new Home_Page(driver);
		rp = new Register_Page(driver);
		lp = new Login_Page(driver);
		sp = new SearchResult_page(driver);
		
		// Navigate to the URL and maximize the window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(4000); // Wait for 4 seconds to let the page load
			
	}
	
	@AfterTest
	public void close() {
		extent.flush(); // Write the report
		driver.quit(); // Quit the driver
	}
}
