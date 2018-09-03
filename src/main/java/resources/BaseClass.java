package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass extends Screenshot {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlReporter;

	public WebDriver initialiseDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Work\\TestPro\\src\\main\\java\\resources\\utils.properties");
		prop.load(fis);
		if (prop.getProperty("browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\shree\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	@BeforeSuite
	public void startReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/TestSummaryReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("OS", "Mac Sierra");
        extent.setSystemInfo("Host Name", "Shree");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Sridhar Kandagatla");
         
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
        htmlReporter.config().setReportName("My Own Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);	
    }

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(MarkupHelper.createLabel(result.getName() + " Test case failed", ExtentColor.RED));
			test.fail(result.getThrowable());
			//String screenshotPath = Screenshot.getScreenshot(driver, result.getName());
			//test.addScreenCaptureFromPath(screenshotPath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass(MarkupHelper.createLabel(result.getName() + " Test case passed", ExtentColor.GREEN));
		} else {
			test.skip(MarkupHelper.createLabel(result.getName() + " Test case skipped", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}

		driver.close();
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "test.test@example.com";
		data[0][1] = "test123";
		data[1][0] = "test.test1@example.com";
		data[1][1] = "test123";
		return data;
	}
}