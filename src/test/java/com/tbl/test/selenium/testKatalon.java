//package com.tbl.test.selenium;
//
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.*;
//
//import static com.tbl.test.selenium.base.constantsOfNoah.CHROME_DRIVER;
//import static org.testng.Assert.*;
//import org.openqa.selenium.*;
//
//public class testKatalon {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();
//
//  @BeforeClass(alwaysRun = true)
//  public void setUp() throws Exception {
//    System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
//    driver = new ChromeDriver();
//    baseUrl = "https://www.katalon.com/";
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//  }
//
//  @Test
//  public void testUntitledTestCase() throws Exception {
//    driver.get("https://www.baidu.com/");
//    driver.manage().window().maximize();
//    driver.findElement(By.id("kw")).clear();
//    driver.findElement(By.id("kw")).sendKeys("掘金");
//    driver.findElement(By.id("su")).click();
//    driver.findElement(By.linkText("掘金- juejin.im - 一个帮助开发者成长的社区")).click();
//
//
//    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
//    // 切换窗口
//    Set<String> windowHandles = driver.getWindowHandles();
//    String windowHandle = driver.getWindowHandle();
//    for (String handle : windowHandles) {
//      if (!handle.equals(windowHandle)) {
//        driver.switchTo().window(handle);
//        break;
//      }
//    }
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='活动'])[1]/following::input[1]")).click();
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='活动'])[1]/following::input[1]")).clear();
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='活动'])[1]/following::input[1]")).sendKeys("我是如何重构整个研发项目，促进自动化运维DevOps的落地");
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='活动'])[1]/following::img[1]")).click();
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='三月内'])[1]/following::div[4]")).click();
//  }
//
//  @AfterClass(alwaysRun = true)
//  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
//  }
//
//  private boolean isElementPresent(By by) {
//    try {
//      driver.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      driver.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
//}
