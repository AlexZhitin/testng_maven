package Pages;

import Base.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class MobilePage {

    protected WebDriver driver;

    private By categories = By.xpath("//span[@class='title']");
    private By subcategories = By.xpath("//a[@class='link-blue']");

    Robot r =new Robot();




    public MobilePage(WebDriver driver) throws AWTException {

        this.driver = driver;
    }

    public void clickCategory(String category) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(categories));
            List<WebElement> list = driver.findElements(categories);
            for (WebElement i : list)
                if (i.getText().contains(category)) {
                    i.click();
                } else {
                }
        } catch (Throwable e) {
            ExtentTestManager.getTest().log(Status.INFO, e);
            System.out.println(e);
        }
    }

    public void clickSubcategory(String subcategory) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(subcategories));
            List<WebElement> list = driver.findElements(subcategories);
            for (WebElement i : list)
                if (i.getText().contains(subcategory)) {
                    i.click();
                } else {
                }
        } catch (Throwable e) {
            ExtentTestManager.getTest().log(Status.INFO, e);
            System.out.println(e);
        }
    }
}
