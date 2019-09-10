import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass extends BaseClass {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
    }

    @Test

    public void test_01() throws InterruptedException {
        getDriver().findElement(By.xpath("//*[@id=\"mySidenav\"]/div/a[1]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@id=\"topnav\"]/div/div[1]/a[4]")).click();
        Thread.sleep(2000);
    }

    @Test

    public void test_02() throws InterruptedException {
        getDriver().findElement(By.xpath("//*[@id=\"mySidenav\"]/div/a[1]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@id=\"topnav\"]/div/div[1]/a[4]")).click();
        Thread.sleep(2000);
    }

}
