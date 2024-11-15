package pages;



import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;


public class ProductPage {
	WebDriver driver;
	String productHeading; 
	 
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	By containerDropdown = By.className("product_sort_container");
	By continueShopping = By.id("continue-shopping");
	
	
	
	public void productsFilter() throws InterruptedException {
		
		Select ContainerDropdown = new Select(driver.findElement(containerDropdown));
	    ContainerDropdown.selectByValue("lohi");
        List<WebElement> productPriceElements = driver.findElements(By.className("inventory_item_price"));
       
	    System.out.println(productPriceElements.size());
		for(int i=1;i<productPriceElements.size();i++) {
		String actualPrice = productPriceElements.get(i).getText();

		System.out.println(actualPrice);
			
			//Assert.assertEquals(ProductPrice.equals(ProductPrice), true);
			
		}
		
	}
	public void addProductsToCart() throws InterruptedException  {
		int i;
		for(i=1;i<=4;i++) {
			
		Select ContainerDropdown = new Select(driver.findElement(containerDropdown));
			ContainerDropdown.selectByValue("lohi");
			
			String productName = "(//div[@class=\'inventory_item_name \'])["+i+"]";
			String productHeading=driver.findElement(By.xpath(productName)).getText();
			System.out.println(productHeading);
			String productPrice = "(//div[@class=\"inventory_item_price\"])["+i+"]";
			String ProductPrice=driver.findElement(By.xpath(productPrice)).getText();
			System.out.println(ProductPrice);
			String addToCartProducts="(//button[text()='Add to cart'])[1]" ;
			
			WebElement addToCartBtn=driver.findElement(By.xpath(addToCartProducts));
			addToCartBtn.click();
			Thread.sleep(2000);	
			WebElement cartBucket = driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]"));
			cartBucket.click();
			Thread.sleep(2000);
			Assert.assertEquals(productHeading.equals(productHeading), true);
			WebElement continueShoppingButton = driver.findElement(continueShopping);
			continueShoppingButton.click();
			
		}
		
		
			
		
	}
	

}

