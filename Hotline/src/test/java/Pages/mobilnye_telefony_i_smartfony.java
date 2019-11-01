package Pages;

import Base.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class mobilnye_telefony_i_smartfony {
    protected WebDriver driver;

    private By filters = By.xpath("//li[@class='filters-value']/label[1]//a[1]");
    /*private By switcherCapacity = By.xpath("//i[@class='switch-thumb'][@xpath='3']");*/
    private By switcherCapacity = By.xpath("//label[@for='switch-gr-39854']/i[2]");
    private By itemFirst = By.xpath("((//div[@class='item-info'])[1]//a)[1]");


    public mobilnye_telefony_i_smartfony(WebDriver driver) {

        this.driver = driver;
    }

    public void selectFilter(String filter) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(filters));
            List<WebElement> list = driver.findElements(filters);
            for (WebElement i : list)
                if (i.getAttribute("data-eventlabel").equals(filter)) {
                    i.click();
                } else {
                }
        } catch (Throwable e) {
            ExtentTestManager.getTest().log(Status.INFO, e);
            System.out.println(e);
        }
    }

    public void clickSwitcherCapacity() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(switcherCapacity));
            WebElement switcher = driver.findElement(switcherCapacity);
            switcher.click();
        } catch (Throwable e) {
            ExtentTestManager.getTest().log(Status.INFO, e);
            System.out.println(e);
        }
    }

    public boolean checkPhone(String model) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(itemFirst));
            WebElement item = driver.findElement(itemFirst);
            System.out.println(item.getText());
            return item.getText().equals(model);
        } catch (Throwable e) {
            ExtentTestManager.getTest().log(Status.INFO, e);
            System.out.println(e);
            return false;
        }
    }
}
