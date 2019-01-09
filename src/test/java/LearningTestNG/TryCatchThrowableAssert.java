package LearningTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TryCatchThrowableAssert {

  ChromeDriver driver = new ChromeDriver();

  @Test
  public void googleSearch(){

    driver.get("http://www.google.co.in/");
    System.out.println(" ---------- Start -------------");


    /*Try/catch block catches the exception when  Assert.assertTrue (false),shows System.out.println("Error") and lets
    * the execution proceed with the test: passed status*/

    try {
      Assert.assertTrue(driver.findElement(By.xpath("xyz")).isDisplayed(), "unable to find the link");

    } catch (Throwable t) {
      System.out.println("Error");
    }
    System.out.println(" ---------- End -------------");
  }

  @Test
  public void anotherTest(){
    System.out.println("another test");
  }
}
