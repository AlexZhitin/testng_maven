package LearningTestNG;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderAdvancedData {

    @DataProvider(name = "datatobeprovided")

    public static Object[][] datatobeprovided(Method m) {
        Object[][] object = null;

        if (m.getName().equals("registerUser")) {
            object = new Object[3][4];

            object[0][0] = "Lara";
            object[0][1] = "Croft";
            object[0][2] = "lc@gmail.com";
            object[0][3] = "tombraider111";

            object[1][0] = "Tom";
            object[1][1] = "Cruze";
            object[1][2] = "tc@gmail.com";
            object[1][3] = "missionimpossible111";

            object[2][0] = "Arnold";
            object[2][1] = "Schwarzeneger";
            object[2][2] = "as@gmail.com";
            object[2][3] = "terminator111";
        }

        if (m.getName().equals("loginUser")) {
            object = new Object[3][2];


            object[0][0] = "LaraCroft";
            object[0][1] = "Croftpassword";

            object[1][0] = "TomCruze";
            object[1][1] = "Cruzepassword";


            object[2][0] = "ArnoldSchwarzeneger";
            object[2][1] = "Schwarzpassword";
        }
        return object;
    }
}