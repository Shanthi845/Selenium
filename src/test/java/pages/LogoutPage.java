package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By menuBar=By.id("react-burger-menu-btn");
	By logoutButton=By.id("logout_sidebar_link");
	
	public void clickOnMenu() {
		WebElement MenuBar = driver.findElement(menuBar);
		MenuBar.click();
		
	}
	
	public void clickOnLogoutButton() {
		WebElement LogoutButton= driver.findElement(logoutButton);
		LogoutButton.click();
	}
}
