package LearningTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNGPrioritization {

  @Test(priority = 1)

  public void Login(){
    System.out.println("Login");
    Assert.assertTrue(1>2);
  }


  @Test(priority = 2)

  public void Navigating(){
    System.out.println("Navigating");
  }



  @Test(priority = 3, dependsOnMethods = {"Login", "Navigating"})

  public void Logout(){
    System.out.println("Log out");
  }

}
