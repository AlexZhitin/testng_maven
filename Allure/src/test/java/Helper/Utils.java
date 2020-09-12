package Helper;

import Base.AllureTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Utils {
    public static boolean elementIsDisplayed(WebElement element, WebDriver driver) {
        try {
            Waiters.waitVisibilityOfElement(element, driver);
            return element.isDisplayed();
        } catch (Throwable e) {
            addErrorToAllureReport(e.toString());
            System.out.println(e);
            return false;
        }
    }

    public static void addErrorToAllureReport(String error) {
        AllureTestListener.saveTextLog(error);
        System.out.println(error);
    }

    public static void clickElementByClassAttribute(List<WebElement> elements, String attributeValue, WebDriver driver) {
        try {
            Waiters.waitVisibilityOfAllElements(elements, driver);
            for (WebElement i : elements)
                if (i.getAttribute("class").contains(attributeValue)) {
                    i.click();
                } else {
                }
        } catch (Throwable e) {
            addErrorToAllureReport(e.toString());
            System.out.println(e);
        }
    }

    public static void clickElement(WebElement element, WebDriver driver) {
        try {
            Waiters.waitVisibilityOfElement(element, driver);
            element.click();
        } catch (Throwable e) {
            addErrorToAllureReport(e.toString());
            System.out.println(e);
        }
    }

    public static void input (WebElement element, WebDriver driver, String input) {
        try {
            Waiters.waitVisibilityOfElement(element, driver);
            element.sendKeys(input);
        } catch (Throwable e) {
            addErrorToAllureReport(e.toString());
            System.out.println(e);
        }
    }
}
