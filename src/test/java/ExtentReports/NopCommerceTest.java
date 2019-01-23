package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeTest;

public class ExtentReportsClass {

  ExtentReports extent;
  ExtentTest logger;


  @BeforeTest

  public void startTest(){

    extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/STMExtentReport.html", true);
  }
}
