package LearningTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

  @Test

  public void LoginviaEmail(){

    System.out.println("Login via Email");
    Assert.assertEquals("Alex", "Alex1");
    System.out.println("After Assert condition");
    //Assert.assertTrue(5>1);
    //Assert.assertFalse(5<1);
  }

  @Test

  public void LoginviaFB(){

    System.out.println("Login via FB");
  }

  @Test

  public void LoginviaTwitter(){

    System.out.println("Login via Twitter");
  }
}
