package Helper;

import Base.AllureTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Utils {
    public static boolean elementIsDisplayed(WebElement element, int time, WebDriver driver) {
        try {
            Waiters.waitVisibilityOfElement(element, time, driver);
            return element.isDisplayed();
        } catch (Throwable e) {
            AllureTestListener.saveTextLog(e.toString());
            System.out.println(e);
            return false;
        }
    }

    public static void addErrorToAllureReport(String error) {
        AllureTestListener.saveTextLog(error);
        System.out.println(error);
    }

    public static void clickElementByClassAttribute(List<WebElement> elements, String attributeValue, int time, WebDriver driver) {
        try {
            Waiters.waitVisibilityOfAllElements(elements, time, driver);
            for (WebElement i : elements)
                if (i.getAttribute("class").contains(attributeValue)) {
                    i.click();
                } else {
                }
        } catch (Throwable e) {
            AllureTestListener.saveTextLog(e.toString());
            System.out.println(e);
        }
    }
}
