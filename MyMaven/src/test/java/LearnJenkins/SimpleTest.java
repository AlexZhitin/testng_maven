package LearnJenkins;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


    public class SimpleTest {

        ChromeDriver driver = new ChromeDriver();



        @Test
        public void precedingSibling (){

            driver.get("https://www.w3schools.com/");
            driver.findElement(By.xpath("//*[@id=\"mySidenav\"]/div/a[4]/parent:: div/div[1]")).click();
            driver.quit();


        }
    }
