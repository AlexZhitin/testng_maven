package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobilePage {

    protected WebDriver driver;

    private By sections = By.xpath("//li[@data-level='1']");


    public MobilePage(WebDriver driver) {

        this.driver = driver;
    }
}
