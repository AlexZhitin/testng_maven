package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class NopCommerceTest {

  public ChromeDriver driver = new ChromeDriver();

  public ExtentHtmlReporter htmlReporter;
  public ExtentReports extent;
  public ExtentTest test;

  @BeforeTest
  public void setExtent() { //All report settings are done here

    htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");

    htmlReporter.config().setDocumentTitle("Automation Report"); //Title of the report
    htmlReporter.config().setReportName("Functional Report"); //Name of the report
    htmlReporter.config().setTheme(Theme.DARK);

    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);

    extent.setSystemInfo("Hostname", "LocalHost");
    extent.setSystemInfo("Tester Name", "Alex");
    extent.setSystemInfo("OS", "Windows");
    extent.setSystemInfo("Browser", "Chrome");
  }

  @AfterTest

  public void endRepot() {
    extent.flush();
  }

  @BeforeMethod

  public void setUp() {

    driver = new ChromeDriver();

    driver.get("http://demo.nopcommerce.com/");

  }

  @Test

  public void NoCommerceTitletest() {

    test = extent.createTest("NoCommerceTitletest");
    String title = driver.getTitle();
    System.out.println("title");
    Assert.assertEquals(title, "nopCommerce demo store");

  }

  @Test

  public void NoCommerceLogoTest() {

    test = extent.createTest("NoCommerceLogoTest");
    Boolean logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
    Assert.assertTrue(logo);

  }


}


