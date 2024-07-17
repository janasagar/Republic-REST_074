package testsuite;

import org.testng.annotations.Test;

import setup.Base_test;

public class Tests extends Base_test {
	
	
	
	@Test
	public void Register() throws InterruptedException {
		Thread.sleep(4000);
		hp.Register();
		Thread.sleep(4000);
		rp.sign_up(FirstName, LastName, Email, Phone, Password, RePassword);
		Thread.sleep(4000);
	}
	
	@Test(dependsOnMethods = "Register")
	public void Search_with_valid_item() throws InterruptedException {
		hp.Go_to_homepage();
		Thread.sleep(3000);
		hp.Search_with_data(search_text1);
		sp.Assert_with_valid_item();
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods = "Register")
	public void Search_with_invalid_item() throws InterruptedException {
		hp.Go_to_homepage();
		Thread.sleep(3000);
		hp.Search_with_data(search_text2);
		sp.Assert_with_invalid_item();
		Thread.sleep(3000);

	}
	@Test(dependsOnMethods = "Register")
	public void Search_with_valid_criteria() throws InterruptedException {
		hp.Go_to_homepage();
		Thread.sleep(3000);
		hp.Search_with_data(search_text3);
		sp.Assert_with_valid_criteria();
	}
	@Test(dependsOnMethods = "Register")
	public void Search_with_blank_text() throws InterruptedException {
		hp.Go_to_homepage();
		Thread.sleep(3000);
		hp.Search_with_blank();
		sp.Assert_with_blank_text();
		Thread.sleep(3000);
	}

}
