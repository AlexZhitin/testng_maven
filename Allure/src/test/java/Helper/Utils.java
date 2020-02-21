package Helper;

import Base.AllureTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    public static boolean elementIsDisplayed(WebElement element, int time, WebDriver driver) {
        /*WebDriverWait wait = new WebDriverWait(driver, time);
        System.out.println(element.getText());
        wait.until(ExpectedConditions.visibilityOf(element));*/
        try {
            Waiters.waitVisibilityOfElement(element, time, driver);
            return element.isDisplayed();
        } catch (Throwable e) {
            AllureTestListener.saveTextLog(e.toString());
            System.out.println(e);
            return false;
        }
    }
}
