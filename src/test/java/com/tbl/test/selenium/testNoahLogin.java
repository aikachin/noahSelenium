//package com.tbl.test.selenium;
//
//import static com.tbl.test.selenium.base.constantsOfNoah.*;
//import com.tbl.test.selenium.MainPage;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
///**
// * @Auther: Aikachin
// * @Date: 2018/11/9 13:50
// * @Description: 测试Noah登录、注销操作
// * @Modified by: Aikachin 2019/1/2
// */
//public class testNoahLogin {
//    public static void main(String args[]) throws Exception {
//        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize(); // 最大化浏览器窗口
//        MainPage mainPage = new MainPage(driver);
//
//        // 打开Noah首页
//        System.out.println("---打开Noah首页...");
//        mainPage.openMainPage(URL_OF_NOAH);
//
//        // 使用账号密码进行登录
//        mainPage.login(USER, PWD);
//
//        // 注销
//        mainPage.logout();
//
//        Thread.sleep(3000);
//
////        LoginTest loginTest = new LoginTest();
////        loginTest.setUp();
////        loginTest.testLogin();
////        loginTest.tearDown();
//        driver.close();
//
//    }
//}
