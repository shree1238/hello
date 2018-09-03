package TestPack;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import objectRepository.LandingPageObjects;
import objectRepository.LoginObjects;
import resources.BaseClass;
import resources.Screenshot;

public class Login extends BaseClass{
	
	@BeforeMethod
	public void testDemo() throws IOException {
		driver = initialiseDriver();
		driver.get("http://demowebshop.tricentis.com/");
	}
	
	@Test(dataProvider="getData")
	public void login(String username, String pwd) throws InterruptedException
	{
		test = extent.createTest("login");
		LoginObjects lo = new LoginObjects(driver);
		lo.loginLink().click();
		test.pass("Login page", Screenshot.getScreenshotAtTestCaseLevel(driver, "Login page"));
		lo.emailBox().sendKeys(username);
		lo.pwdBox().sendKeys(pwd);
		test.pass("Entered credentials", Screenshot.getScreenshotAtTestCaseLevel(driver, "entering credentials"));
		lo.loginButton().click();
		test.pass("Logged in", Screenshot.getScreenshotAtTestCaseLevel(driver, "Logged in"));
	    Assert.assertEquals(true, lo.logout().isDisplayed());
        lo.logout().click();
		test.pass("Logged out", Screenshot.getScreenshotAtTestCaseLevel(driver, "Logged out"));
			
	}
	
	

}
