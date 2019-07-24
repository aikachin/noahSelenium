package com.tbl.test.selenium.Page;

import static com.tbl.test.selenium.base.constantsOfNoah.*;
import static com.tbl.test.selenium.util.WebDriverUtil.waitForElementVisible;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.tbl.test.selenium.base.BasePage;
import com.tbl.test.selenium.util.WebDriverUtil;

/**
 * @Auther: Aikachin
 * @Date: 2018/11/9 13:32
 * @Description: 打开首页http://localhost:8080/noah_web
 * @Modified by Aikachin 2019/1/2
 */
public class MainOperation extends BasePage {

	
	static WebElement configLink;  // 个人配置
    static WebElement logoutLink;  // 注销
    static WebElement sysManage;   // 系统管理
    static WebElement userManage;  // 用户管理
    static WebElement roleManage;  // 角色管理

    

    public void openMainPage(String url) {
        driver.get(url);
    }

	// 根据用户名输入框是否存在判断页面是否正常打开
    public boolean ifLoginPage() {
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
    public int login(String userName, String passWord) {
    	// 判断是否能进入登录页
    	if (ifLoginPage()) {
	        LoginPage loginPage = new LoginPage();
	        loginPage.login(userName, passWord);
	        
	        try {
	        	// 获取导航栏，如果能获取到，则登录成功
	        	driver.findElement(By.id(NAV_ID));
		        print("登录成功！");
		        loginInitial(); // 登录后特殊处理，手动关闭新设备提醒框
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
    
    
    
    // 进入登录后的初始化首页面
    public boolean loginInitial() {
    	boolean flag = WebDriverUtil.waitForElementVisible(driver, By.xpath(NEWDEVICE_ALERT_XP), 1);
    	if (flag) {
        	driver.findElement(By.xpath(NEWDEVICE_ALERT_XP)).click();
        }
    	
    	return true;
    }
    
    
    // 退出登录
    public void logout() {
    	if(!waitForElementVisible(driver, By.id(NAV_ID), 1)) {
    		driver.switchTo().defaultContent();
    	}
//    	mainPage = new MainPage();
    	mainPage.logout();

    }



	/**
	 * 打开用户管理页面，添加用户
	 * @param userInfo
	 * @return 0：添加成功
     *         1：添加失败
     *         -1：异常返回
	 * @throws Exception
	 */
	public int addUser(List<String> userInfo) throws Exception {
//		mainPage = new MainPage();
        mainPage.openUserPage();
        UserPage userPage = new UserPage();
        return userPage.addUser(userInfo);
		
	}

  
    
    /**
     * @Description    添加角色
     * @param roleName 角色名称
     * @return 0：正常; 1：角色名称不符合规范; -1：未知异常
     * @throws Exception
     */
    public int addRole(String roleName) throws Exception {
        mainPage.openRolePage();
        RolePage rolePage = new RolePage();
        return rolePage.addRole(roleName);

    }
    
    
    /**
     * @Description    添加角色然后加以验证是否添加成功
     * @param roleName 角色名称
     * @return 0：正常; 1：角色名称不符合规范; -1：未知异常
     * @throws Exception
     */
    public int addRoleAndVerify(String roleName) throws Exception {
        RolePage rolePage = new RolePage();
        int queryRoleFlag;
        int addRoleFlag = addRole(roleName);
        if (addRoleFlag == 0) {
        	Thread.sleep(3000);
            // 切换到mainFrame
            driver.switchTo().frame(MAIN_FRM_ID);
            queryRoleFlag = rolePage.queryRole(roleName);

        	if (queryRoleFlag == 0) {
        		return rolePage.ifRoleExists(roleName);
        	} 
        	return queryRoleFlag;
        }
        return addRoleFlag;
        
    }
    
    
    /**
     * @Description    角色查询
     * @param roleName 角色名称
     * @return	0:存在; 1:不存在; -1:异常返回
     * @throws Exception
     */
    public int queryRoleAndVerify(String roleName) throws Exception {
        mainPage.openRolePage();
    	RolePage rolePage = new RolePage();
    	int queryRoleRet = rolePage.queryRole(roleName);
    	if (queryRoleRet == 0) {
    		return rolePage.ifRoleExists(roleName);
    	}
    	return queryRoleRet; 

    }
    
    
    /**
     * @Description    验证角色是否存在于当前角色列表中
     * @param roleName 角色名称
     * @return 0：存在；
 	 *		   1：不存在；
 	 *		   -1：输入的roleName为空
     * @throws Exception
     */
    public static int verifyRole(String roleName) throws Exception {
    	RolePage rolePage = new RolePage();
    	int queryRoleRet = rolePage.queryRole(roleName);
    	if (queryRoleRet == 0) {
    		return rolePage.ifRoleExists(roleName);
    	}
    	return -1;
    }
    
    
    /**
     * @Description    删除角色并验证是否删除成功
     * @param roleName
     * @return 1:删除成功; 0:删除失败; -1:异常返回
     * @throws Exception
     */
    public int deleteRole(String roleName) throws Exception {
    	int queryRoleRet = queryRoleAndVerify(roleName);
    	if (queryRoleRet == 0) {
    		RolePage rolePage = new RolePage();
    		int deleteRet = rolePage.deleteRole();
    		
    		if (deleteRet == 0) {
//    			queryRoleRet = rolePage.queryRole(roleName);
//    			if (queryRoleRet == 0) {
//    				return rolePage.ifRoleExists(roleName);
//    			}
    			return verifyRole(roleName);
    		}
    	} else {
    		print("删除角色【" + roleName + "]失败！查询不到该角色！");

    	}
    	return -1;
    }
    
    

    /**
     * @Description    修改角色
     * @param roleName
     * @return 1:修改成功; 0:修改失败; -1:异常返回
     * @throws Exception
     */
    public int modifyRole(String roleName) throws Exception {
    	int queryRoleRet = queryRoleAndVerify(roleName);
    	if (queryRoleRet == 0) {
    		RolePage rolePage = new RolePage();
    		int modifyRet = rolePage.modifyRole(roleName);
    		
    		if (modifyRet == 0) {
//    			queryRoleRet = rolePage.queryRole(roleName);
//    			if (queryRoleRet == 0) {
//    				return rolePage.ifRoleExists(roleName);
//    			}
    			return verifyRole(roleName);
    		}
    	} else {
    		print("修改角色【" + roleName + "】失败！查询不到该角色！");

    	}
    	return -1;
    }
    
}
