package LearningTestNG;

import org.testng.annotations.*;

public class AnnotationsTestngClass_1 {


    @BeforeClass
    public void BeforeClass(){
        System.out.println("Initialize Selenium for Class 1");
    }

    /*Method annotated with @BeforeMethod is going to be executed before every test following the thread */
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("Open browser");
    }

    @Test
    public void Test1() {
        System.out.println("Test 1 inside");
    }

    @Test
    public void Test2() {
        System.out.println("Test 2 inside");
    }


    /*Opposite to @BeforeMethod annotation*/
    @AfterMethod

    public void AfterMethod(){
        System.out.println("Close browser");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("Destroy Selenium for class 1");
    }
}
