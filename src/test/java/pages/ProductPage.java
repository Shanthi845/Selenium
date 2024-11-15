package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	By sortDropdown = By.className("product_sort_container");
	By cartButton = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
	By cBucket = By.xpath("//span[@class='shopping_cart_badge']");
	By Shopping = By.id("continue-shopping");
	By checkout = By.id("checkout");
	By remove = By.id("remove-sauce-labs-onesie");
	
	public void selectValueInDropdown() {
		Select productDropdown = new Select(driver.findElement(sortDropdown));
		productDropdown.selectByValue("lohi");
		
	}
	
	public void clickOnAddToCartButton() {
		WebElement addToCartButton = driver.findElement(cartButton);
		addToCartButton.click();
	}
	
	public void clickOnCartBucket() {
		WebElement cartBucket = driver.findElement(cBucket);
		cartBucket.click();
		
	}
	
	public void validatingContinueShopping() {
		WebElement continueShopping = driver.findElement(Shopping);
		Assert.assertEquals(continueShopping.isDisplayed(), true);
	}
	
	public void clickOnContinueShopping() {
		WebElement continueShopping = driver.findElement(Shopping);
		continueShopping.click();
		
	}
	
	
	public void validatingCheckoutButton() {
		WebElement checkoutButton = driver.findElement( checkout);
		Assert.assertEquals(checkoutButton.isDisplayed(), true);
	}
     
	public void validatingRemoveButton() {
		WebElement removeButton = driver.findElement(remove);
		removeButton.click();
	}
}
