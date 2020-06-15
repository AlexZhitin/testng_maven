package Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Streams {

    WebDriver driver;

    @FindBy(xpath = "//a")
    List<WebElement> categories;

    String url = "https://www.amazon.com/";

    @BeforeMethod

    public void SetUp() {

        System.setProperty("webdriver.chrome.driver", "D:\\QA\\Selenium_projects\\testng_maven\\Allure\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    /*@Test

    public void ForEach(){

        categories.forEach(e -> System.out.println(e.getText()));
        System.out.println(categories.size());
    }*/

    /*@Test

    public void Lamda() {


        List<String> collectionList = categories.stream()
                .filter(e -> !e.getText().equals(""))
                .map(e -> e.getText()).
                collect(Collectors.toList());

        collectionList.forEach(e -> System.out.println(e));
        System.out.println(collectionList.size());

    }*/


   /* @Test

    public void getFirstElement() {


        String text = categories.stream()
                .filter(e -> !e.getText().equals(""))
                .findFirst().get().getText();
        System.out.println(text);
    }*/

    /*@Test

        public void startsWith() {
        List<String> collectionList = categories.stream()
                .filter(e -> e.getText().startsWith("Amazon") && !e.getText().equals("")) //also available contains(),
                .map(e -> e.getText())
                .collect(Collectors.toList());

        collectionList.forEach(e -> System.out.println(e));

    }*/

    @Test

    public void removingSpaces() {
       /* List<String> AllLinkTextLinks = categories.stream()
                .filter(e -> !e.getText().isEmpty())
                .filter(e -> !e.getText().startsWith(" "))
                .map(e -> e.getText().trim()) //removes spaces before and after the string
                .collect(Collectors.toList());

        AllLinkTextLinks.forEach(e -> System.out.println(e));*/


        List<String> list = new ArrayList<>();

        categories.stream()
                .filter(e -> !e.getText().isEmpty())
                .filter(e -> !e.getText().startsWith(" "))
                .forEach(e -> list.add(e.getText()));

        list.forEach(e -> System.out.println(e));


    }

    @AfterMethod

    public void tearDown() {
        driver.quit();
    }
}

