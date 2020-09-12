package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waiters {
   public static WebDriverWait wait;


    public static WebElement waitVisibilityOfElement(WebElement element, WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
        System.out.println("Element: " + element.getText() + " " + element.getTagName());
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static List<WebElement> waitVisibilityOfAllElements(List<WebElement> elements, WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
