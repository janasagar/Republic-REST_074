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
	public void Search_function() throws InterruptedException {
		hp.Go_to_homepage();
		Thread.sleep(3000);
		hp.Search_with_data(search_text1);
		hp.Search_with_data(search_text2);
		hp.Search_with_data(search_text3);
		hp.Search_with_blank();
		Thread.sleep(3000);
	}

}
