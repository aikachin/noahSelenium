package com.tbl.test.selenium.test;

import static com.tbl.test.selenium.base.constantsOfNoah.*;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestRoleQuery {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRoleQuery() throws Exception {
    driver.get("http://192.168.1.57:8081/noah_web/login/main/index.do");
    driver.findElement(By.linkText("角色管理")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
    driver.switchTo().frame(MAIN_FRM_ID);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='删除'])[1]/following::span[1]")).click();
    driver.switchTo().defaultContent();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
    driver.findElement(By.id("roleName")).click();
    driver.findElement(By.id("roleName")).clear();
    driver.findElement(By.id("roleName")).sendKeys("测试角色E");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='角色名称：'])[1]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='角色名称：'])[1]/following::div[2]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='备注'])[1]/following::label[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='添加'])[1]/following::span[1]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=2 | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='编辑权限'])[1]/following::span[1]")).click();
    driver.findElement(By.id("remark")).click();
    driver.findElement(By.id("remark")).clear();
    driver.findElement(By.id("remark")).sendKeys("fine");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='设备固件'])[1]/following::div[3]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='编辑成功！'])[1]/following::span[1]")).click();
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
