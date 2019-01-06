package LearningTestNG;

import org.testng.annotations.*;

public class AnnotationsTestngClass_2 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Starting TestNG");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("Stopping TestNG");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Start Test Execution");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Initialize Selenium for Class 2");
    }

    @Test
    public void test3(){
        System.out.println("Inside Test 3");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Destroy Selenium for class 2");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Stop Test Execution");
    }
}
