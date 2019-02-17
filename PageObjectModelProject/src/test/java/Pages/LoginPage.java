package Pages;

/*

This class stores all the locators and methods of login page

 */

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    By email = By.name("login");
    By password = By.name("password");
    By loginButton = By.xpath("//button[@type='submit']");


    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }


    public void LoginToBlaBlaCar(String useremail, String userpassword) {

        driver.findElement(email).sendKeys(useremail);
        driver.findElement(password).sendKeys(userpassword);
        driver.findElement(loginButton).click();

        driver.findElement(By.xpath("//*[@class='u-blablacar-logo']"));

    }
}
