package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

 class CheckoutPage1 {
	WebDriver driver;
	public CheckoutPage1(WebDriver driver) {
		this.driver = driver;
	}

	By checkoutButton = By.id("checkout");
	By firstnameTxt = By.id("first-name");
	By lastnameTxt = By.id("last-name");
	By zipTxt = By.id("postal-code");
	By continueButton = By.id("continue");
	
	
	public void clickOnCheckoutButton() {
		WebElement CheckoutButton = driver.findElement(checkoutButton);
		CheckoutButton.click();
		
	}
	
	public void enteringDetails(String firstname, String lastname, String  zipcode) {
		driver.findElement(firstnameTxt).sendKeys(firstname);
		driver.findElement(lastnameTxt).sendKeys(lastname);
		driver.findElement(zipTxt).sendKeys(zipcode);
		
	}
	
	public void clickOnContinueButton() {
		WebElement ContinueButton = driver.findElement(continueButton);
		ContinueButton.click();
	}
	
}
