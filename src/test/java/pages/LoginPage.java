package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
By usernameTextbox=By.id("user-name");
By passwordTextbox=By.id("password");
By loginButton=By.id("login-button");


public void loginCredentials(String username, String password) {
	driver.findElement(usernameTextbox).sendKeys(username);
	driver.findElement(passwordTextbox).sendKeys(password);
	driver.findElement(loginButton).click();
	
	
}


}
