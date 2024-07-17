package testsuite;

//Import necessary packages and classes
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import setup.Base_test;

//Tests class that contains the test methods
public class Tests extends Base_test {
	
	
	// Test method for user registration
	@Test
	public void Register() throws InterruptedException {
		test = extent.createTest("Register Test", "Test to validate user registration");
		
		// Navigate to the registration page
		hp.Register();
		test.log(Status.INFO, "Navigated to registration page");
		Thread.sleep(4000); // Wait for 4 seconds
		
		// Fill out the registration form and submit
		rp.sign_up(FirstName, LastName, Email, Phone, Password, RePassword);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(rp.getCon_msg())); // Wait for confirmation message
		rp.Assert_successful_registration(); // Assert successful registration
		test.log(Status.PASS, "User registered successfully");
		Thread.sleep(3000); // Wait for 3 seconds
	}
	
	// Test method for searching with a valid item
	@Test(dependsOnMethods = "Register")
	public void Search_with_valid_item() throws InterruptedException {
		test = extent.createTest("Search with valid item Test", "Test to validate search functionality with valid item");
		
		// Navigate to the home page
		hp.Go_to_homepage();
		test.log(Status.INFO, "Navigated to home page");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Perform search with valid item
		hp.Search_with_data(search_text1);
		wait.until(ExpectedConditions.visibilityOf(sp.getTablet())); // Wait for tablet element
		
		// Assert that the valid item is found
		sp.Assert_with_valid_item(search_text1); // Assert valid item
		test.log(Status.PASS, "Valid item found and verified");
		Thread.sleep(3000); // Wait for 3 seconds
	}
	
	// Test method for searching with an invalid item
    @Test(dependsOnMethods = "Search_with_valid_item")
    public void Search_with_invalid_item() throws InterruptedException {
        test = extent.createTest("Search with invalid item Test", "Test to validate search functionality with invalid item");
        
        // Navigate to the home page
        hp.Go_to_homepage();
        test.log(Status.INFO, "Navigated to home page");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Perform search with invalid item
        hp.Search_with_data(search_text2);
        wait.until(ExpectedConditions.visibilityOf(sp.getNo_result())); // Wait for no result element
        
        // Assert that no item is found
        sp.Assert_with_invalid_item(); // Assert invalid item
        test.log(Status.PASS, "No item found and verified");
        Thread.sleep(3000); // Wait for 3 seconds
    }
    
    // Test method for searching with valid search criteria
    @Test(dependsOnMethods = "Search_with_invalid_item")
    public void Search_with_valid_criteria() throws InterruptedException {
        test = extent.createTest("Search with valid search criteria Test", "Test to validate search functionality with valid items");
       
        // Navigate to the home page
        hp.Go_to_homepage();
        test.log(Status.INFO, "Navigated to home page");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Perform search with valid criteria
        hp.Search_with_data(search_text3);
        wait.until(ExpectedConditions.visibilityOfAllElements(sp.getProducts())); // Wait for all products
        
        // Assert that all expected items are found
        sp.Assert_with_valid_criteria(); // Assert valid criteria
        test.log(Status.PASS, "All the expected items found and verified");
        Thread.sleep(3000); // Wait for 3 seconds
    }
    
    // Test method for searching with blank text
    @Test(dependsOnMethods = "Search_with_valid_criteria")
    public void Search_with_blank_text() throws InterruptedException {
        test = extent.createTest("Search with blank text", "Test to validate search functionality with blank text");
        
        // Navigate to the home page
        hp.Go_to_homepage();
        test.log(Status.INFO, "Navigated to home page");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Perform search with blank text
        hp.Search_with_blank();
        wait.until(ExpectedConditions.visibilityOf(sp.getNo_result())); // Wait for no result element
        
        // Assert that no item is found
        sp.Assert_with_blank_text(); // Assert blank text
        test.log(Status.PASS, "No item found and verified");
        Thread.sleep(3000); // Wait for 3 seconds
    }
    
    // Test method for log out from application
    @Test(dependsOnMethods = "Search_with_blank_text")
    public void Log_out() {
    	test = extent.createTest("Log Out", "Log out from application and close the browser");
    	
    	// Navigate to home page
    	hp.Go_to_homepage();
    	
    	// Log out from application
    	hp.Logout();
    }

}
