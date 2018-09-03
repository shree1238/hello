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

public class Demo extends BaseClass {

	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	@BeforeMethod
	public void testDemo() throws IOException {
		driver = initialiseDriver();
		driver.get("http://demowebshop.tricentis.com/");
	}

	@Test
	public void books() throws IOException, Exception {
		test = extent.createTest("books");
		LandingPageObjects lp = new LandingPageObjects(driver);
		test.pass("Home page", Screenshot.getScreenshotAtTestCaseLevel(driver, "homepagebooks"));
		lp.booksMenuItem().click();
		test.pass("clicked on books menu item", Screenshot.getScreenshotAtTestCaseLevel(driver, "clickedonbooksmenuitem"));
		log.info("clicked on books");
		Assert.assertEquals(lp.driver.getTitle(), "Demo Web Shop. Book");
	}

	@Test
	public void computers() throws IOException, Exception {
		test = extent.createTest("computers");
		LandingPageObjects lp = new LandingPageObjects(driver);
		test.pass("Home page", Screenshot.getScreenshotAtTestCaseLevel(driver, "homepagecomputers"));
		lp.computersMenuItem().click();
		test.pass("clicked on computers", Screenshot.getScreenshotAtTestCaseLevel(driver, "clickedoncomputersmenuitem"));
		log.info("clicked on computers");
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Computers");
	}
}