package pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class CheckoutPage {
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By checkoutButton = By.id("checkout");
	By firstnameTxt = By.id("first-name");
	By lastnameTxt = By.id("last-name");
	By zipTxt = By.id("postal-code");
	By continueButton = By.id("continue");
	By item = By.className("inventory_item_name");
	By finishButton = By.id("finish");
	By backHomeButton = By.id("back-to-products");
	
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
	public void validatingitem() {
		WebElement Item = driver.findElement(item);
		Assert.assertEquals(Item.isDisplayed(),true);
	}
	
	public void clickOnFinishButton() {
		WebElement FinishButton = driver.findElement(finishButton);
		FinishButton.click();
	}
	
	public void clickOnBackHomeButton() {
		WebElement BackHomeButton=driver.findElement(backHomeButton);
		BackHomeButton.click();
		
	}
}
