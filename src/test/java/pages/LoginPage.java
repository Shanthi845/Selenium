package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
		WebDriver driver;
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			
		}

		By usernametxt = By.id("user-name");
		By passwordtxt = By.id("password");
		By loginbtn = By.id("login-button");
		
		
	public void validatingLoginPage(String username, String password) {
		driver.findElement(usernametxt).sendKeys(username);
		driver.findElement(passwordtxt).sendKeys(password);
		driver.findElement(loginbtn).click();
		
	}
}
