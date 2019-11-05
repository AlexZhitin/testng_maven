package Pages;

import Base.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class mobilnye_telefony_i_smartfony {
    protected WebDriver driver;

    private By filters = By.xpath("//li[@class='filters-value']/label[1]//a[1]");
    /*private By switcherCapacity = By.xpath("//i[@class='switch-thumb'][@xpath='3']");*/
    private By switcherCapacity = By.xpath("//label[@for='switch-gr-39854']/i[2]");
    private By itemFirst = By.xpath("((//div[@class='item-info'])[1]//a)[1]");
    private By buttonOk = By.xpath("//input[@class='btn-graphite']");
    private By sliderLeft = By.xpath("//div[@class='filters-item opened filters-price']//div[@class='item-bd']//span[1]");
    private By sliderRight = By.xpath("//div[@class='item-bd']//span[2]");
    private By sliderLine = By.xpath("//div[@class='ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']");

    //input[@class='btn-graphite']


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

        public void sliderPriceLeft() {

            try {
                WebDriverWait wait = new WebDriverWait(driver, 5);
                wait.until(ExpectedConditions.visibilityOfElementLocated(sliderLeft));
                WebElement slider = driver.findElement(sliderLeft);
                WebElement sliderL = driver.findElement(sliderLine);
                int width=sliderL.getSize().getWidth();
                Actions move = new Actions(driver);
                Action action  = move.dragAndDropBy(slider, (int) ((width*4.87)/100), 0).build();
                action.perform();
            } catch (Throwable e) {
                ExtentTestManager.getTest().log(Status.INFO, e);
                System.out.println(e);
            }
        }

    public void sliderPriceRight() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement button = driver.findElement(buttonOk);
            wait.until(ExpectedConditions.visibilityOfElementLocated(sliderRight));
            WebElement slider = driver.findElement(sliderRight);
            WebElement sliderL = driver.findElement(sliderLine);
            int width=sliderL.getSize().getWidth();
            Actions move = new Actions(driver);
            Action action  = move.dragAndDropBy(slider, ((width*-92)/100), 0).build();
            action.perform();
            button.click();
        } catch (Throwable e) {
            ExtentTestManager.getTest().log(Status.INFO, e);
            System.out.println(e);
        }
    }
}
