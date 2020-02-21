package Helper;

import Base.AllureTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waiters {

    /*protected static WebDriver driver;*/

    public static WebElement waitVisibilityOfElement(WebElement element, int time, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        System.out.println("Element: " + element.getText());
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static List<WebElement> waitVisibilityOfAllElements(List<WebElement> elements, int time, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
