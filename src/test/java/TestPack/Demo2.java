package TestPack;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import objectRepository.LandingPageObjects;
import resources.BaseClass;
import resources.Screenshot;

public class Demo2 extends BaseClass {
	
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	@BeforeMethod
	public void testDemo1() throws IOException {
		driver = initialiseDriver();
		driver.get("http://demowebshop.tricentis.com/");
	}

	@Test
	public void electronics() throws IOException, Exception {
		test = extent.createTest("electronics");
		LandingPageObjects lp = new LandingPageObjects(driver);
		test.pass("Home page", Screenshot.getScreenshotAtTestCaseLevel(driver, "homepageelectronics"));
		lp.electronicsMenuItem().click();
		test.pass("clicked on elec men item", Screenshot.getScreenshotAtTestCaseLevel(driver, "clickelectmenitem"));
        Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Electronics");
	}

	@Test
	public void appShoes() throws IOException, Exception {
		test = extent.createTest("appshoes");
		LandingPageObjects lp = new LandingPageObjects(driver);
		test.pass("Home page", Screenshot.getScreenshotAtTestCaseLevel(driver, "homepageappshoes"));		
	    lp.appShoesMenuItem().click();
		test.pass("clicked on appshoes", Screenshot.getScreenshotAtTestCaseLevel(driver, "clickappshoesmenitem"));
		log.info("clicked on apparel and shoes");
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Apparel & Shoes");
	}
}