package com.SwagLabsE2E;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CheckoutPage1;
import pages.LoginPage;
import pages.ProductPage;

public class SauceDemoLaunchE2E {
	WebDriver driver;
	
	//Browser launch
	@Parameters("browserName")
	@BeforeTest
	public void InitializeBrowser() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
	}
	
	//Launch Application
	@Parameters("url")
	@Test
	public void LaunchApp(String url) {
		driver.get(url);
	
	}
	
	
	//Login
	@Parameters({"username" , "password"})
	@Test
	public void Login(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.validatingLoginPage(username, password);
		
		
	}
	
	//Product Validation
	
	@Test
	
	public void ProductValidation() throws InterruptedException {
		ProductPage productpage = new ProductPage(driver);
		productpage.productsFilter();
		productpage.addProductsToCart();

	}
	
	//checkout
	
	@Parameters({"firstname","lastname","zipcode"})
	@Test
	public void checkout(String firstname, String lastname, String  zipcode) throws Exception {
		
		ProductPage productpage = new ProductPage(driver);
		CheckoutPage1 checkoutpage = new CheckoutPage1(driver);
		productpage.productsFilter();
		checkoutpage.clickOnCheckoutButton();
		checkoutpage.enteringDetails(firstname, lastname, zipcode);
		checkoutpage.clickOnContinueButton();
	
	}
	
@AfterTest
  
public void Quit() {
	driver.quit();
}

}
