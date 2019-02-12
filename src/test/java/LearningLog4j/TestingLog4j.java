package LearningLog4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestingLog4j {

  Logger logger;
  FileInputStream propertiespath;

  @Test

  public void testLog4j() throws FileNotFoundException {

    propertiespath = new FileInputStream (System.getProperty("user.dir")+"/src/test/java/LearningLog4j/log4j.properties");
    PropertyConfigurator.configure(propertiespath);

    logger = Logger.getLogger("testlogger");
    logger.debug("Starting of selenium tests");
    ChromeDriver driver = new ChromeDriver();
    logger.debug("Chrome browser opens");
    driver.get("https://www.google.com/");
    logger.debug("Navigate to Chrome");
    driver.quit();

  }
}
