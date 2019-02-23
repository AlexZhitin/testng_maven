package Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestA {

    WebDriver driver = new ChromeDriver();

    // Test to pass as to verify listeners .
    @Test
    public void Login() throws InterruptedException {
        driver.get("http://demo.guru99.com/V4/");
        driver.findElement(By.name("uid")).sendKeys("mngr180317");
        driver.findElement(By.name("password")).sendKeys("YquzanA");
        driver.findElement(By.name("btnLogin")).click();
        Thread.sleep(5000);
        driver.quit();
    }

    // Forcefully failed this test as to verify listener.
    @Test
    public void TestToFail()
    {
        System.out.println("This method to test fail");
        Assert.assertTrue(false);
        driver.quit();
    }
}
