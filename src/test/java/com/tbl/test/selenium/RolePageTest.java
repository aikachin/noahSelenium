package com.tbl.test.selenium;

import static com.tbl.test.selenium.base.constantsOfNoah.CHROME_DRIVER;
import static com.tbl.test.selenium.base.constantsOfNoah.URL_OF_NOAH;
import static com.tbl.test.selenium.util.BaseUtils.*;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbl.test.selenium.Page.MainOperation;
import com.tbl.test.selenium.base.BasePage;


/**
 * @Auther: Aikachin
 * @Date: 2019/2/21
 * @Description: 测试添加角色
 * @Modified by: Aikachin 添加测试用例 2019/2/21
 */
public class RolePageTest extends BasePage {

//    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception{
		browserType = getValue("BROWSER_TYPE");
		String url = getValue("URL_OF_NOAH");
		mainOperation.openMainPage(url);
    }
    
    @BeforeClass
    public void beforeClass() throws Exception{
		print("开始执行测试");

    }

//    @Test
    // Case1.添加角色成功
    public void test1AddRole() throws Exception {
        System.out.println("------Case1.开始测试添加角色...");
        // 使用账号密码进行登录
        int loginFlag = mainOperation.login("noah", "123456");
        if (loginFlag == 0) {
	        int retCode = mainOperation.addRoleAndVerify("测试角色G");
        	if (retCode == -1) {
                print("未知错误，Case1测试失败！");
                //如果添加失败，则终止程序 (预期的应该是能登录的，如果第一条case失败，则直接退出)
                driver.close();
                driver.quit();	        	
	        }
        	Assert.assertEquals(retCode, 0);
        } else {
        	print("未能进入登录页，Case1测试失败！");
            //如果添加失败，则终止程序 (预期的应该是能登录的，如果第一条case失败，则直接退出)
            driver.close();
            driver.quit();
        }
       
        Thread.sleep(2000);
    }

    //@Test
    // Case2.角色名重复，添加失败
    public void test2AddRoleFailed() throws Exception {
        print("------Case2.开始测试添加重复名称的角色...");

        // 使用账号密码进行登录
        if (mainOperation.login("noah", "123456") == 0) {
	        int retCode = mainOperation.addRole("测试角色F");
        	Assert.assertEquals(retCode, 1);
        } else {
        	print("未能进入登录页，Case2测试失败！");
        }
        sleep(2000);
    }

    //@Test
    // Case3.能查询到角色
    public void test3QueryRole() throws Exception {
    	print("------Case3.开始测试能查询到角色...");
//        MainOperation.openMainPage(URL_OF_NOAH);
        // 使用账号密码进行登录
        if (mainOperation.login("noah", "123456") == 0) {
	        int retCode = mainOperation.queryRoleAndVerify("测试角色F");
        	Assert.assertEquals(retCode, 0);
        } else {
        	print("未能进入登录页，Case3测试失败！");
        }
        sleep(2000);
    }

    //@Test
    // Case4.不能查询到角色
    public void test4QueryRole2() throws Exception {
    	print("------Case4.开始测试查询不到角色...");
//        MainOperation.openMainPage(URL_OF_NOAH);
        // 使用账号密码进行登录
        if (mainOperation.login("noah", "123456") == 0) {
	        int retCode = mainOperation.queryRoleAndVerify("测试角色G");
        	Assert.assertEquals(retCode, 1);
        } else {
        	print("未能进入登录页，Case4测试失败！");
        }
        sleep(2000);
    }
    
//    @Test
    // Case5.删除角色
    public void test5DeleteRole() throws Exception {
    	print("------Case5.开始测试 删除角色...");
//        MainOperation.openMainPage(URL_OF_NOAH);
        // 使用账号密码进行登录
        if (mainOperation.login("noah", "123456") == 0) {
	        int retCode = mainOperation.deleteRole("测试角色G");
        	Assert.assertEquals(retCode, 1);
        } else {
        	print("未能进入登录页，Case5测试失败！");
        }
        sleep(2000);
    }

    @Test
    // Case6.修改角色
    public void test6ModifyRole() throws Exception {
    	print("------Case6.开始测试 修改角色...");
//        MainOperation.openMainPage(URL_OF_NOAH);
        // 使用账号密码进行登录
        if (mainOperation.login("noah", "123456") == 0) {
	        int retCode = mainOperation.modifyRole("测试角色G");
        	Assert.assertEquals(retCode, 0);
        } else {
        	print("未能进入登录页，Case6测试失败！");
        }
        sleep(2000);
    }
    
    
    @AfterMethod
    public void tearDown() throws InterruptedException{
        sleep(1000);
        mainOperation.logout();
    }
    
    @AfterClass
    public void afterClass() throws InterruptedException{
        sleep(1000);
        driver.close();
//        driver.quit();
    }

//    @DataProvider(name = "Name")
//    public static Object[][] Name() {
//        return null;
//    }
}
