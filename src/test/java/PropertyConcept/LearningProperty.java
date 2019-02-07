package PropertyConcept;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LearningProperty {

  Properties property;
  FileInputStream fis;

  @Test

  public void testProperty() throws IOException {

    //Initialization of variables
    fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/PropertyConcept/config.properties");
    property = new Properties();

    property.load(fis);
    System.out.println(property.getProperty("name"));

  }
}
