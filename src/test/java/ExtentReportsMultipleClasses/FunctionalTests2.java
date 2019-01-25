package ExtentReportsMultipleClasses;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FunctionalTests2 extends BaseTest {

  @Test

  public void NoCommerceTitletest2() {

    test = extent.createTest("NoCommerceTitletest2");
    String title = driver.getTitle();
    System.out.println("title");
    Assert.assertEquals(title, "nopCommerce demo!!!!!!!!!!!");

  }

  @Test

  public void NoCommerceLogoTest2() {

    test = extent.createTest("NopCommerceLogoTest2");
    Boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
    Assert.assertTrue(status);

  }

  @Test

  public void NoCommerceLoginTest2() {
    test = extent.createTest("NopCommerceLoginTest2");
    test.createNode("Login with valid input2");
    Assert.assertTrue(true);

    test.createNode("Login with invalid input2");
    Assert.assertTrue(true);


    Assert.assertTrue(true); //test method will be passed
  }
}