package com.tbl.test.selenium.test;

import static com.tbl.test.selenium.base.constantsOfNoah.CHROME_DRIVER;
import static com.tbl.test.selenium.base.constantsOfNoah.MAIN_FRM_ID;
import static com.tbl.test.selenium.util.WebDriverUtil.isDisplay;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Addrfid {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  }

  @Test
  public void testAddrfid() throws Exception {
    driver.get("http://192.168.1.57:8081/noah_web/login/main/index.do");
    driver.findElement(By.id("loginname")).sendKeys("noah");
    driver.findElement(By.id("password")).sendKeys("123456");
    driver.findElement(By.className("submit_btn")).sendKeys(Keys.ENTER);
    
    driver.findElement(By.linkText("设备管理")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='设备管理'])[1]/following::a[1]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
    driver.switchTo().frame(MAIN_FRM_ID);
    
    
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='设备添加'])[1]/following::button[1]")).click();
    driver.findElement(By.className("device_import")).click();
    
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
    driver.switchTo().defaultContent();
//    WebElement daoruDiv = driver.findElement(By.className("idlg-content"));
    
    WebElement daoruIframe = driver.findElement(By.xpath("//iframe[contains(@id,\"idlg-ifrm\")]"));
    driver.switchTo().frame(daoruIframe);
//    if (isDisplay(driver, "/html/body/div/div[2]/div[2]", "点击上传文件")) {
////      daoruIframe.findElement(By.xpath("/html/body/div/div[2]/div[2]")).click();
//    	daoruIframe.findElement(By.linkText("点击上传文件")).click();
//    }
    
    
//    daoruIframe.findElement(By.xpath("/html/body/div/div[3]/button[2]")).click();	//	取消按钮
    
//    driver.findElement(By.id("fileUploadAdd")).click();
    driver.findElement(By.id("fileUploadAdd")).clear();
    driver.findElement(By.id("fileUploadAdd")).sendKeys("E:\\software\\Git-repo\\noahSelenium\\ref\\device.xlsx");
    // /html/body/div/div[3]/button[1] 导入按钮
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='已上传'])[1]/following::button[1]")).click();	
    driver.switchTo().defaultContent();
//    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
//    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='删除'])[3]/following::span[1]")).click();
//    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='设备管理'])[1]/following::a[1]")).click();
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='设备管理'])[1]/following::a[1]")).click();
    driver.findElement(By.linkText("noah")).click();
    driver.findElement(By.linkText("退出")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
