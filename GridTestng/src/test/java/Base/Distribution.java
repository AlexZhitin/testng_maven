package Base;

import org.openqa.selenium.WebDriver;

public class Distribution {
    public static WebDriver Connection(String connection) {
        if (connection.equals("selenium")) {
            GridBase grid = new GridBase();
            return grid.getDriver();
        } else {
            TestngBase testng = new TestngBase();
            return testng.getDriver();
        }
    }
}
