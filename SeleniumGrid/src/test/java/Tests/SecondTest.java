package Tests;

import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTest extends TestBase {


    @Test
    public void GOOGLE4() {
        System.out.println("Google4 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        getDriver().navigate().to("http://www.google.com");
        System.out.println("Google4 Test's Page title is: " + getDriver().getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(getDriver().getTitle(), "Google");
        System.out.println("Google4 Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }

    @Test
    public void YAHOO() {
        System.out.println("Yahoo Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        getDriver().navigate().to("http://www.yahoo.com");
        System.out.println("Yahoo Test's Page title is: " + getDriver().getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(getDriver().getTitle(), "Yahoo");
        System.out.println("Yahoo Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }
}