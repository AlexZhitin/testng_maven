package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

  public WebDriver driver;

  public static ExtentHtmlReporter htmlReporter;
  public static ExtentReports extent;
  public static ExtentTest test;


  @BeforeTest
  @Parameters("browser")

  public void setUp(String browserName) {
    if (browserName.equalsIgnoreCase("chrome")) {
      driver = new ChromeDriver();
    } else if (browserName.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    } else if (browserName.equalsIgnoreCase("safari")) {
      driver = new SafariDriver();
    }

    htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/resources/test-output/myReport.html");
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);


    htmlReporter.config().setDocumentTitle("Automation Report"); //Title of the report
    htmlReporter.config().setReportName("Functional Report"); //Name of the report
    htmlReporter.config().setTheme(Theme.DARK);


    extent.setSystemInfo("Hostname", "LocalHost");
    extent.setSystemInfo("Tester Name", "Alex");
    extent.setSystemInfo("OS", "Windows");
    extent.setSystemInfo("Browser", "Chrome");

  }


  @AfterMethod

  public void getResult(ITestResult result) throws IOException {
    if (result.getStatus() == ITestResult.FAILURE) {
      test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName() + result.getThrowable()); // to add name in extent report
      /* test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report*/
      String screenshotPath = LoginTest.getScreenshot(driver, result.getName());
      test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
    } else if (result.getStatus() == ITestResult.SKIP) {
      test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
    } else if (result.getStatus() == ITestResult.SUCCESS)
      test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
  }

  public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);

    // after execution, you could see a folder "FailedTestsScreenshots" under src folder
    String destination = System.getProperty("user.dir") + "/src/test/resources/Screenshots/" + screenshotName + dateName + ".png";
    File finalDestination = new File(destination);
    FileUtils.copyFile(source, finalDestination);
    return destination;
  }

  @AfterTest()

  public void endReport() {
    extent.flush();
    driver.quit();
  }
}
