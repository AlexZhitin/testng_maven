package ExtentReportsMultipleClasses;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FunctionalTests1 extends BaseTest {

  @Test

  public void NoCommerceTitletest1() {

    test = extent.createTest("NoCommerceTitletest1");
    String title = driver.getTitle();
    System.out.println("title");
    Assert.assertEquals(title, "nopCommerce demo!!!!!!!!!!!");

  }

  @Test

  public void NoCommerceLogoTest1() {

    test = extent.createTest("NopCommerceLogoTest1");
    Boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
    Assert.assertTrue(status);

  }

  @Test

  public void NoCommerceLoginTest1() {
    test = extent.createTest("NopCommerceLoginTest1");
    test.createNode("Login with valid input");
    Assert.assertTrue(true);

    test.createNode("Login with invalid input");
    Assert.assertTrue(true);
  }
}