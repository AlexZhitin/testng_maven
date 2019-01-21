package LearningTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Listeners {

  @Test

  public void loginwithEmail(){
    System.out.println("Inside test login with email");
  }

  @Test

  public void loginwithFB(){
    System.out.println("Inside test login with FB");
    Assert.assertEquals(1,2);
  }
}
