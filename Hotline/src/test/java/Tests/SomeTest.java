package Tests;

import Base.ExtentTestManager;
import Base.TestBase;
import Pages.HomePage;
import Pages.MobilePage;
import Pages.mobilnye_telefony_i_smartfony;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class SomeTest extends TestBase {
  private WebDriver driver;
  private String sectionMobile = "mobile";
  private String categorySmarthonesMobile = "Смартфоны и мобильные телефоны";
  private String subcategorySmarthonesMobile = "Смартфоны и мобильные телефоны";
  private String filterPop = "Игровой телефон[609557]";
  private String filterType = "Смартфон[133]";
  private String filterBrand = "Xiaomi[294391]";
  private String filterDisplay = "6,01-6,39[586796]";
  private String filterRam = "6[384897]";
  private String filterMemory = "128[116870]";
  private String filterYear = "2018[573866]";
  private String model = "Xiaomi Mi 9T Pro 6/128GB Black";
  private String priceFrom = "5000";
  private String priceTill = "12000";




  @BeforeMethod
  public void setUp() {
    driver = getDriver();
  }

  @Test

  public void sectionMobile() throws InterruptedException, AWTException {

    HomePage home_page = new HomePage(driver);
    MobilePage mobile_page = new MobilePage(driver);
    mobilnye_telefony_i_smartfony mobile_smartphone_page = new mobilnye_telefony_i_smartfony(driver);
    mobilnye_telefony_i_smartfony button = new mobilnye_telefony_i_smartfony(driver);

    String error = "Unexpected phone model";
    String test = "Testcase";

    home_page.clickSection(sectionMobile);
    mobile_page.clickCategory(categorySmarthonesMobile);
    mobile_page.clickSubcategory(subcategorySmarthonesMobile);
    mobile_smartphone_page.slider();
    /*mobile_smartphone_page.selectFilter(filterPop);
    mobile_smartphone_page.selectFilter(filterType);
    mobile_smartphone_page.selectFilter(filterBrand);
    mobile_smartphone_page.selectFilter(filterDisplay);
    mobile_smartphone_page.selectFilter(filterRam);
    mobile_smartphone_page.selectFilter(filterMemory);
    mobile_smartphone_page.selectFilter(filterYear);*//*
    */
    mobile_smartphone_page.inputPriceFrom(priceFrom);
    Thread.sleep(3000);
    mobile_smartphone_page.inputPriceTill(priceTill);
    Thread.sleep(3000);


    mobile_smartphone_page.clickSwitcherCapacity();
    Thread.sleep(10000);



    
    if (mobile_smartphone_page.checkPhone(model)) {
      Assert.assertTrue(true);
    } else {
      System.out.println(error);
      ExtentTestManager.getTest().log(Status.INFO, error);
      Assert.fail();
    }
    ExtentTestManager.getTest().log(Status.INFO, test);
  }
}