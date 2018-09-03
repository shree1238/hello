package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObjects {
	
	public WebDriver driver;

	public LoginObjects(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement loginLink() {
		return driver.findElement(By.linkText("Log in"));

}

	public WebElement emailBox() {
		return driver.findElement(By.xpath("//input[@id='Email']"));

}
	
	public WebElement pwdBox() {
		return driver.findElement(By.xpath("//input[@id='Password']"));

}
	
	public WebElement loginButton() {
		return driver.findElement(By.xpath("//input[@value='Log in']"));

}
	public WebElement logout() {
		return driver.findElement(By.linkText("Log out"));

}
}