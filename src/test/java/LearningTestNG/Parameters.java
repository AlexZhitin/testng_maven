package LearningTestNG;

import org.testng.annotations.Test;

public class Parameters {

  @org.testng.annotations.Parameters("email")
  @Test

  public void Login(String email){
    System.out.println("Inside login");
    System.out.println(email);
  }
}
