package com.tbl.test.selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tbl.test.selenium.base.BasePage;

import static com.tbl.test.selenium.base.constantsOfNoah.*;

import java.util.List;

public class MainPage extends BasePage {
	
	@FindBy(xpath=CONF_XP)
//	@CacheLookup
	public static WebElement configLink;  // 个人配置
	
	@FindBy(xpath=SYS_MNG_XP)
//	@CacheLookup
	public static WebElement sysManage;   // 系统管理
	
	@FindBy(xpath=USER_MNG_XP)
//	@CacheLookup
	public static WebElement userManage;  // 用户管理
	
	@FindBy(xpath=ROLE_MNG_XP)
//	@CacheLookup
	public static WebElement roleManage;  // 角色管理
	
	
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * 打开用户管理页面
	 * @return 0：正常；	-1：异常
	 */
	public int openUserPage() {
		try {
	        // 点击系统管理
	        sysManage.click();
	        // 点击用户管理
	        userManage.click();
	        // 切换到mainFrame
	        driver.switchTo().frame(MAIN_FRM_ID);
		} catch (Exception e) {
			throw e;
		}
		return 0;
	}
	
	
    /**
     * 打开角色管理页面
     * @return 0：正常；	-1：异常
     */
    public int openRolePage() {
    	try {
	        // 点击系统管理
	        sysManage.click();
	        // 点击角色管理
	        roleManage.click();
	        // 切换到mainFrame
	        driver.switchTo().frame(MAIN_FRM_ID);
    	} catch (Exception e) {
			throw e;
    	}
        return 0;
    }
	
	
    // 退出登录
    public int logout() {
    	try {
	        configLink.click();
	        NaviPulldownPage naviPulldownPage = new NaviPulldownPage();
	        naviPulldownPage.logout();

            driver.findElement(By.id(LOGIN_USER_ID));
        } catch (NoSuchElementException ex) {
            print("注销失败！");
//            ex.printStackTrace();
            throw ex;
        }
        print("注销成功！");
    	return 0;
    }
    
    

    
//    /**
//     * @Description    角色查询
//     * @param roleName 角色名称
//     * @return	0:存在; 1:不存在; -1:异常返回
//     * @throws Exception
//     */
//    public int queryRoleAndVerify(String roleName) throws Exception {
//        int retCode = openRolePage();
//        if (0 == retCode) {
//	    	RolePage rolePage = new RolePage();
//	    	int queryRoleRet = rolePage.queryRole(roleName);
//	    	if (queryRoleRet == 0) {
//	    		return rolePage.ifRoleExists(roleName);
//	    	}
//	    	return queryRoleRet; 
//        } else {
//        	return retCode;
//        }
//    }
}
