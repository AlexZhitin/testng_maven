package LearningTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAdvanced {


    @Test(dataProviderClass = DataProviderAdvancedData.class, dataProvider = "datatobeprovided")

    public void registerUser(String firstname, String lastname, String email, String password) {
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(email);
        System.out.println(password);


    }

    @Test(dataProviderClass = DataProviderAdvancedData.class, dataProvider = "datatobeprovided")

    public void loginUser(String username, String password) {
        System.out.println(username);
        System.out.println(password);


    }
}
