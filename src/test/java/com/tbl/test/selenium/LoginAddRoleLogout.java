//package com.tbl.test.selenium;
//
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//
//import static com.tbl.test.selenium.base.constantsOfNoah.*;
//import static org.testng.Assert.fail;
//
///**
// * @Auther: Aikachin
// * @Date: 2019/3/11 20:52
// * @Description: Say something to describe your file.
// * @Modified by {who Time}
// */
//public class LoginAddRoleLogout {
//    private WebDriver driver;
//    private String baseUrl;
//    private boolean acceptNextAlert = true;
//    private StringBuffer verificationErrors = new StringBuffer();
//
//    @BeforeClass(alwaysRun = true)
//    public void setUp() throws Exception {
//        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
//        driver = new ChromeDriver();
//        baseUrl = "https://www.katalon.com/";
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void testLoginAddRoleLogout() throws Exception {
//        driver.get("http://localhost:8080/noah_web/");
//        driver.manage().window().maximize();
//        driver.findElement(By.id("loginname")).click();
//        driver.findElement(By.id("loginname")).clear();
//        driver.findElement(By.id("loginname")).sendKeys("noah");
//        driver.findElement(By.id("password")).click();
//        driver.findElement(By.id("password")).clear();
//        driver.findElement(By.id("password")).sendKeys("123456");
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='记住密码'])[1]/following::input[1]")).click();
//        driver.findElement(By.linkText("系统管理")).click();
//        driver.findElement(By.linkText("角色管理")).click();
//        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
//        // 切换到mainFrame
//        driver.switchTo().frame(MAIN_FRM_ID);
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='编辑'])[1]/preceding::span[1]")).click();
//        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
//        // 返回主内容
//        driver.switchTo().defaultContent();
//
//        Thread.sleep(2000);
//        //添加角色div class
//        WebElement roleAddDiv = driver.findElement(By.className(ROLE_ADD_DIV_CL));
//        //添加角色frame tag
//        WebElement roleAddFrame = roleAddDiv.findElement(By.tagName(ROLE_ADD_FRM_TAG));
//        driver.switchTo().frame(roleAddFrame);
//        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
//        driver.findElement(By.id("roleName")).clear();
//        driver.findElement(By.id("roleName")).sendKeys("测试员B");
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[1]/following::span[2]")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='新增权限'])[1]/following::span[1]")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='编辑权限'])[1]/following::span[1]")).click();
//        driver.findElement(By.id("itree-checkbox-menu_1")).click();
//        driver.findElement(By.id("itree-checkbox-menu_2")).click();
//        driver.findElement(By.id("itree-checkbox-menu_3")).click();
//        driver.findElement(By.id("itree-checkbox-menu_8")).click();
//        driver.findElement(By.id("itree-checkbox-menu_7")).click();
//        driver.findElement(By.id("itree-checkbox-menu_5")).click();
//        driver.findElement(By.id("itree-checkbox-menu_4")).click();
//        driver.findElement(By.id("itree-checkbox-menu_10")).click();
//        driver.findElement(By.id("itree-checkbox-menu_6")).click();
//        driver.findElement(By.id("itree-checkbox-menu_9")).click();
//        driver.findElement(By.id("itree-checkbox-menu_10")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='设备固件'])[1]/following::div[3]")).click();
//        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
//        // 返回主内容
//        driver.switchTo().defaultContent();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='添加成功!'])[1]/following::span[1]")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='个人设置'])[1]/preceding::span[1]")).click();
//        driver.findElement(By.linkText("退出")).click();
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDown() throws Exception {
//        driver.quit();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
//    }
//
//    private boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
//
//    private String closeAlertAndGetItsText() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = alert.getText();
//            if (acceptNextAlert) {
//                alert.accept();
//            } else {
//                alert.dismiss();
//            }
//            return alertText;
//        } finally {
//            acceptNextAlert = true;
//        }
//    }
//}
