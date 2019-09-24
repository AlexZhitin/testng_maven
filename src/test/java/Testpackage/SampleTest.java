package Testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {

  @Test (groups = {"1"})

  public void Test1() {
    System.out.println("Test 1");
  }

  @Test (groups = {"2"})

  public void Test2() {
    System.out.println("Test 2");
    Assert.assertEquals("2", "1");
  }

  @Test (groups = {"3"})

  public void Test3() {
    System.out.println("Test 3");
  }
}
//test comment
