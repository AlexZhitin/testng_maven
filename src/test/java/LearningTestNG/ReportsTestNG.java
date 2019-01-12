package LearningTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReportsTestNG {

    @Test

    public void login(){
        System.out.println("login");
    }

    @Test

    public void logout(){
        System.out.println("logout");
        Assert.assertEquals("white", "black");
    }
}
