package com.SwagLabs;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ProductPage;

public class SauceDemoLaunch {
	
	WebDriver driver;
	
	//BrowserLaunch

	@Parameters("browserName")
	@BeforeTest
	public void InitialiseBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Parameters("url")
	@Test
	public void LaunchApp(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

	}

	// login
	
	@Parameters({ "username", "password" })
	@Test
	public void Login(String userName, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginCredentials(userName, password);
	}

	// product validation
	
	@Test
	public void product() {
		
		ProductPage productpage = new ProductPage(driver);
		productpage.selectValueInDropdown();
		productpage.clickOnAddToCartButton();
		productpage.clickOnCartBucket();
		productpage.validatingContinueShopping();
		productpage.validatingCheckoutButton();
		productpage.validatingRemoveButton();
		productpage.clickOnContinueShopping();

	}
	
	
	//checkout
	
	@Parameters({"firstname","lastname","zip"})
	@Test
	public void checkout(String firstname, String lastname, String  zipcode) {
		
		ProductPage productpage = new ProductPage(driver);
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		productpage.selectValueInDropdown();
		productpage.clickOnAddToCartButton();
		productpage.clickOnCartBucket();
		checkoutpage.clickOnCheckoutButton();
		checkoutpage.enteringDetails(firstname, lastname, zipcode);
		checkoutpage.clickOnContinueButton();
		checkoutpage.validatingitem();
		checkoutpage.clickOnFinishButton();
		checkoutpage.clickOnBackHomeButton();
		
	}
	
	//logout
	
	@Test
	public void logout() throws Exception {
		
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickOnMenu();
		logoutpage.clickOnLogoutButton();
		Thread.sleep(2000);
		
	}
	
	
	
	
@Parameters("sleepTime")
	@AfterTest
	public void Quit(Long sleepTime) throws Exception {
		Thread.sleep(sleepTime);
	driver.quit();
}

	

}
