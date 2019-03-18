package com.tbl.test.selenium;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static com.tbl.test.selenium.base.constantsOfNoah.CHROME_DRIVER;
import static com.tbl.test.selenium.base.constantsOfNoah.URL_OF_NOAH;
import static com.tbl.test.selenium.sysPrint.print;


/**
 * @Auther: Aikachin
 * @Date: 2018/11/9 15:29
 * @Description: 测试登录
 * @Modified by: Aikachin 添加测试用例 2019/2/11
 */
public class LoginTest {

    WebDriver driver;

    //@BeforeMethod
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage(URL_OF_NOAH);
    }

    @BeforeClass
    public void beforeClass() throws Exception{
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage(URL_OF_NOAH);
    }

    @Test
    // Case1.成功
    public void testLogin() throws Exception {
    	/* 已放到BeforeClass中执行 
      	MainPage mainPage = new MainPage(driver);
      	mainPage.openMainPage(URL_OF_NOAH);
    	*/
    	 
        System.out.println("------Case1.开始测试登录成功...");
        // 使用账号密码进行登录
        int retCode = MainPage.login("noah", "123456");
        if (retCode == 0) {
            print("Case1测试成功！");
            // 注销
            MainPage.logout();
        } else {
        	if (retCode == 1) {
        		print("Case1测试失败！");
        	
        	// 返回-1时
        	} else {
            	print("未能进入登录页，Case1测试失败！");
        	}
            //如果登录失败，则终止程序 (预期的应该是能登录的，如果第一条case失败，则直接退出)
            driver.close();
            driver.quit();
        }
        
        Thread.sleep(2000);
    }

    @Test
    // Case2.密码错误，登录失败
    public void testLoginFailed() throws Exception {
        System.out.println("------Case2.开始测试密码错误，登录失败...");
        // 使用账号密码进行登录
        int retCode = MainPage.login("admin", "hqks-admi");
        if (retCode == 0) {
            print("Case2测试失败！");
            // 注销
            MainPage.logout();
        } else {
        	if (retCode == 1) {
                print("Case2测试成功！");
        	} else {
        		print("未能进入登录页，Case2测试失败！");
        	}
        }
        
        Thread.sleep(2000);
    }

    @Test
    // Case3.不输入密码，登录失败
    public void testLoginFailed2() throws Exception {
    	System.out.println("------Case3.开始测试不输入密码，登录失败..");
        // 使用账号密码进行登录
        int retCode = MainPage.login("admin", "");
        if (retCode == 0) {
            print("Case3测试失败！");
            // 注销
            MainPage.logout();
        } else {
        	if (retCode == 1) {
                print("Case3测试成功！");
        	} else {
        		print("未能进入登录页，Case3测试失败！");
        	}
        }
        Thread.sleep(2000);
    }

    @Test
    // Case4.用户名错误，登录失败
    public void testLoginFailed3() throws Exception {
    	System.out.println("------Case4.开始测试用户名错误，登录失败..");
        // 使用账号密码进行登录
        int retCode = MainPage.login("admin1", "sonriku");
        if (retCode == 0) {
            print("Case4测试失败！");
            // 注销
            MainPage.logout();
        } else {
        	if (retCode == 1) {
                print("Case4测试成功！");
        	} else {
        		print("未能进入登录页，Case4测试失败！");
        	}
        }
        Thread.sleep(2000);
    }

    @Test
    // Case5.用户名为空，登录失败
    public void testLoginFailed4() throws Exception {
    	System.out.println("------Case5.开始测试用户名为空，登录失败..");
        // 使用账号密码进行登录
        int retCode = MainPage.login("", "sonriku");
        if (retCode == 0) {
            print("Case5测试失败！");
            // 注销
            MainPage.logout();
        } else {
        	if (retCode == 1) {
                print("Case5测试成功！");
        	} else {
        		print("未能进入登录页，Case5测试失败！");
        	}
        }
        Thread.sleep(2000);
    }

    @Test
    // Case6.用户名为空，登录失败
    public void testLoginFailed5() throws Exception {
    	System.out.println("------Case6.开始测试用户名密码为空，登录失败..");
        // 使用账号密码进行登录
        int retCode = MainPage.login("", "");
        if (retCode == 0) {
            print("Case6测试失败！");
            // 注销
            MainPage.logout();
        } else {
        	if (retCode == 1) {
                print("Case6测试成功！");
        	} else {
        		print("未能进入登录页，Case6测试失败！");
        	}
        }
        Thread.sleep(2000);
    }

    //@AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

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
