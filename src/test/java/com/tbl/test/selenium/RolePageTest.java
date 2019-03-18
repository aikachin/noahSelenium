package com.tbl.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.tbl.test.selenium.base.constantsOfNoah.CHROME_DRIVER;
import static com.tbl.test.selenium.base.constantsOfNoah.URL_OF_NOAH;
import static com.tbl.test.selenium.sysPrint.print;


/**
 * @Auther: Aikachin
 * @Date: 2019/2/21
 * @Description: 测试添加角色
 * @Modified by: Aikachin 添加测试用例 2019/2/21
 */
public class RolePageTest {

    WebDriver driver;

//    @BeforeMethod
//    public void setUp() throws Exception{
//        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        MainPage mainPage = new MainPage(driver);
//        mainPage.openMainPage(URL_OF_NOAH);
//    }
    
    @BeforeClass
    public void beforeClass() throws Exception{
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage(URL_OF_NOAH);
    }

    @Test
    // Case1.添加角色成功
    public void testAddRole() throws Exception {
        System.out.println("------Case1.开始测试添加角色...");
        // 使用账号密码进行登录
        if (MainPage.login("noah", "123456") == 0) {
        	MainPage.rolePage();
	        int retCode = MainPage.addRole("测试角色E");
	        if (retCode == 0) {
	            print("Case1测试成功！");
	            // 注销
//	            MainPage.logout();
	        } else if (retCode == 1) {
        		print("Case1测试失败");
                // 注销
                MainPage.logout();
        	} else if (retCode == -1) {
                print("未知错误，Case1测试失败！");
                //如果添加失败，则终止程序 (预期的应该是能登录的，如果第一条case失败，则直接退出)
                driver.close();
                driver.quit();	        	
	        }
        } else {
        	print("未能进入登录页，Case1测试失败！");
            //如果添加失败，则终止程序 (预期的应该是能登录的，如果第一条case失败，则直接退出)
            driver.close();
            driver.quit();
        }
       
        Thread.sleep(2000);
    }

    @Test
    // Case2.角色名重复，添加失败
    public void testAddRoleFailed() throws Exception {

        System.out.println("------Case2.开始测试添加重复名称的角色...");
        // 使用账号密码进行登录
//        if (MainPage.login("noah", "123456") == 0) {
        MainPage.rolePage();
	        int retCode = MainPage.addRole("测试角色E");
	        if (retCode == 0) {
	            print("Case2测试失败！");//不允许添加重复名称的角色
	        } else if (retCode == 1) {
        		print("Case2测试成功！");
        	} else if (retCode == -1) {
                print("未知错误，Case2测试失败！");
        	}
	        
//        } else {
//        	print("未能进入登录页，Case2测试失败！");
//        }
        Thread.sleep(2000);
    }


//    @AfterMethod
//    public void tearDown() throws InterruptedException{
//        Thread.sleep(1000);
//        driver.close();
//        driver.quit();
//    }
    
    @AfterClass
    public void afterClass() throws InterruptedException{
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

//    @DataProvider(name = "Name")
//    public static Object[][] Name() {
//        return null;
//    }
}
