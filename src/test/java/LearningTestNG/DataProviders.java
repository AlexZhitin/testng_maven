package LearningTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

  @Test (dataProvider = "dataprovidername")

  public void registerUser (String firstname, String lastname, String email, String password) {
    System.out.println(firstname);
    System.out.println(lastname);
    System.out.println(email);
    System.out.println(password);


  }

  @DataProvider (name = "dataprovidername")// Can be named

  public Object[][] datatobeprovided() {

    Object [][] object = new Object[3][4];

    object [0][0] = "Lara";
    object [0][1] = "Croft";
    object [0][2] = "lc@gmail.com";
    object [0][3] = "tombraider111";

    object [1][0] = "Tom";
    object [1][1] = "Cruze";
    object [1][2] = "tc@gmail.com";
    object [1][3] = "missionimpossible111";

    object [2][0] = "Arnold";
    object [2][1] = "Schwarzeneger";
    object [2][2] = "as@gmail.com";
    object [2][3] = "terminator111";

return object;


  }
}
