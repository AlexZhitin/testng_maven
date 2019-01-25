package ExtentReportsMultipleClasses;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FunctionalTests1 extends BaseTest {

  @Test

  public void NoCommerceTitletest() {

    test = extent.createTest("NoCommerceTitletest");
    String title = driver.getTitle();
    System.out.println("title");
    Assert.assertEquals(title, "nopCommerce demo!!!!!!!!!!!");

  }

  @Test

  public void NoCommerceLogoTest() {

    test = extent.createTest("NopCommerceLogoTest");
    Boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
    Assert.assertTrue(status);

  }

  @Test

  public void NoCommerceLoginTest() {
    test = extent.createTest("NopCommerceLoginTest");
    test.createNode("Login with valid input");
    Assert.assertTrue(true);

    test.createNode("Login with invalid input");
    Assert.assertTrue(true);


    Assert.assertTrue(true); //test method will be passed
  }
}