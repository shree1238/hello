package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageObjects {

	public WebDriver driver;

	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	By booksMenuItem = By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a");

	public WebElement booksMenuItem() {
		return driver.findElement(booksMenuItem);
	}

	public WebElement computersMenuItem() {
		return driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"));
	}
	
	By electronicsMenuItem = By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[3]/a");

	public WebElement electronicsMenuItem() {
		return driver.findElement(electronicsMenuItem);
	}
	
	By appShoesMenuItem = By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header-menu > ul.top-menu > li:nth-child(4) > a");
	public WebElement appShoesMenuItem() {
		return driver.findElement(appShoesMenuItem);
	}
}