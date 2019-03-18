package com.tbl.test.selenium;

import com.tbl.test.selenium.systemMenu.RolePage;
import com.tbl.test.selenium.systemMenu.UserPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.tbl.test.selenium.base.constantsOfNoah.*;
import static com.tbl.test.selenium.sysPrint.print;
import static com.tbl.test.selenium.util.WebDriverUtil.waitForElementVisible;

/**
 * @Auther: Aikachin
 * @Date: 2018/11/9 13:32
 * @Description: 打开首页http://localhost:8080/noah_web
 * @Modified by Aikachin 2019/1/2
 */
public class MainPage {
    static WebDriver driver;
    //WebElement loginLink;
    static WebElement configLink;  // 个人配置
    static WebElement logoutLink;  // 注销
    static WebElement sysManage;   // 系统管理
    static WebElement userManage;  // 用户管理
    static WebElement roleManage;  // 角色管理

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage(String url) {
        driver.get(url);
    }

    public static boolean ifLoginPage() {
        // 根据用户名输入框是否存在判断页面是否正常打开
        // print("开始判断是否进入登录页");
        return waitForElementVisible(driver, By.id(LOGIN_USER_ID), 5);
    }

    
    /**
     * description 如果未能进入登录页面直接返回-1；
     * 				如果进入登录页面，使用用户名、密码登录，然后判断是否登录成功
     * @param userName 用户名
     * @param passWord 密码
     * @return -1：未能进入登录页面
     * 			1：登录失败
     * 			0：登录成功
     * @throws Exception
     */
    public static int login(String userName, String passWord) {
    	// 判断是否能进入登录页
    	if (ifLoginPage()) {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login(userName, passWord);
	        try {
	            WebElement navbar = driver.findElement(By.id(NAV_ID));
		        print("登录成功！");
	        } catch (NoSuchElementException ex) {
	            // print("未找到id为：‘" + NAV_ID + "’ 的元素");
	            print("登录失败！");
	            return 1;
	        }
    	} else {
    		return -1;
    	}
    	return 0;
    }

    // 退出登录
    public static void logout() {
        configLink = driver.findElement(By.xpath(CONF_XP));
        configLink.click();
        logoutLink = driver.findElement(By.xpath(LOGOUT_XP));
        logoutLink.click();
        try {
            // WebElement uname = driver.findElement(By.id(LOGIN_USER_ID));
            driver.findElement(By.id(LOGIN_USER_ID));
        } catch (NoSuchElementException ex) {
            print("注销失败！");
            ex.printStackTrace();
        }
        print("注销成功！");
    }


    // 打开用户管理页面
    public static int userPage(List<String> userInfo) throws Exception{
        // 点击系统管理
        sysManage = driver.findElement(By.xpath(SYS_MNG_XP));
        sysManage.click();
        // 点击用户管理
        userManage = driver.findElement(By.xpath(USER_MNG_XP));
        userManage.click();
        // 切换到mainFrame
        driver.switchTo().frame(MAIN_FRM_ID);
        UserPage userPage = new UserPage(driver);
        return userPage.addUser(userInfo);
    }


    // 打开角色管理页面
    public static void rolePage() throws Exception{
        // 点击系统管理
        sysManage = driver.findElement(By.xpath(SYS_MNG_XP));
        sysManage.click();
        // 点击角色管理
        roleManage = driver.findElement(By.xpath(ROLE_MNG_XP));
        roleManage.click();
        // 切换到mainFrame
        driver.switchTo().frame(MAIN_FRM_ID);
    }
    
    // 添加角色
    public static int addRole(String roleName) throws Exception {
//    	rolePage();
        RolePage rolePage = new RolePage(driver);
        return rolePage.addRole(roleName);
			    	
    }
    
}
