package Pages;

import Base.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
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
    private By priceFrom = By.xpath("//div[@class='filters-item opened filters-price']//input[1]");
    private By priceTill = By.xpath("//div[@class='filters-item opened filters-price']//input[3]");
    private By buttonOk = By.xpath("//input[@class='btn-graphite']");
    private By sliderLeft = By.xpath("//div[@class='filters-item opened filters-price']//div[@class='item-bd']//span[1]");

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

    public void inputPriceFrom(String price) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String script = "document.querySelector(\"#page-catalog > div.wrapper > div.content.row > div.row-fixed > aside > div > div.filters-bd.tabs-content > div.filters-all.active > div.filters-item.opened.filters-price > div.item-bd > div > div.nowrap.m_b-lg > input:nth-child(1)\").setAttribute('value', '6000'); document.querySelector(\"#page-catalog > div.wrapper > div.content.row > div.row-fixed > aside > div > div.filters-bd.tabs-content > div.filters-all.active > div.filters-item.opened.filters-price > div.item-bd > div > div.nowrap.m_b-lg > input:nth-child(2)\").setAttribute('value', '6000')";
            String scriptOk = "document.getElementsByClassName('btn-graphite')[2].click();";
            WebElement button = driver.findElement(buttonOk);
            wait.until(ExpectedConditions.visibilityOfElementLocated(priceFrom));
            WebElement input = driver.findElement(priceFrom);
            input.click();
            js.executeScript(script);
            Thread.sleep(3000);
            js.executeScript(scriptOk);
            /*for (int i = 0; i < 10; i++) {
                input.sendKeys(Keys.BACK_SPACE);
            }*/
            Thread.sleep(5000);

        } catch (Throwable e) {
            ExtentTestManager.getTest().log(Status.INFO, e);
            System.out.println(e);
        }
    }

    public void inputPriceTill(String price) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(priceTill));
            WebElement input = driver.findElement(priceTill);
            WebElement button = driver.findElement(buttonOk);
            input.click();
            for (int i = 0; i < 10; i++) {
                input.sendKeys(Keys.BACK_SPACE);
            }
            input.sendKeys(price);
            button.click();
        } catch (Throwable e) {
            ExtentTestManager.getTest().log(Status.INFO, e);
            System.out.println(e);
        }
    }
}
