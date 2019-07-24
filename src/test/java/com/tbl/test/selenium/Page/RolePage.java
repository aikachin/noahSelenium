package com.tbl.test.selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tbl.test.selenium.base.BasePage;

import static com.tbl.test.selenium.base.constantsOfNoah.*;
import static com.tbl.test.selenium.util.BaseUtils.*;
import static com.tbl.test.selenium.util.WebDriverUtil.waitForElementVisible;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Aikachin
 * @Date: 2019/2/20 16:34
 * @Description: 用户管理页面.
 * @Modified by AikaChin
 */
public class RolePage extends BasePage {

	@FindBy(xpath=ROLE_ADD_XP)
	@CacheLookup
    public WebElement addBtn;  // 添加
	
	@FindBy(xpath=ROLE_MODF_XP)
	@CacheLookup
	public WebElement modBtn;  // 编辑

	@FindBy(xpath=ROLE_DEL_XP)
	@CacheLookup
	public WebElement delBtn;  // 删除
    
	@FindBy(xpath=ROLE_QUR_XP)
	@CacheLookup
	public WebElement qurBtn;  // 查询

    WebElement roleAddSubmit;    // 添加角色弹框 提交按钮
    public WebElement roleAddSubmitConfirm;    // 添加角色弹框 提交后确认按钮


    public RolePage() {
        PageFactory.initElements(driver, this);
    }
    

    
    /**
     * @Description    添加角色
     * @param roleName 角色名称
     * @return  0：正常
     *          1：角色名称不符合规范——已存在
     *          -1：异常返回
     * @throws Exception
     */
    @SuppressWarnings("null")
	public int addRole(String roleName) throws Exception{
        // 点击添加
        addBtn.click();
        // 返回主内容
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        //添加角色div class
        WebElement roleAddDiv = driver.findElement(By.className(ROLE_ADD_DIV_CL));
        //添加角色frame tag
        WebElement roleAddFrame = roleAddDiv.findElement(By.tagName(WEB_ELE_TAG_FRM));
        driver.switchTo().frame(roleAddFrame);
        // 添加角色弹框--角色名称
        WebElement roleAddRoleName = driver.findElement(By.xpath(ROLE_NAME_XP));
        //检查是否有错误
        try {
            //角色名称输入框check
            driver.findElement(By.className("has-error"));
            //刚打开添加弹框时，就找到错误元素，表示发生未知错误，返回-1
            return -1;

        //找不到表示正常，继续执行
        } catch (NoSuchElementException e) {
            // 填写角色信息
            roleAddRoleName.sendKeys(roleName);
            // 添加角色弹框--新增权限checkbox
            WebElement roleAddCreCheckbox = driver.findElement(By.xpath(ROLE_ADD_CKBX_ADD_XP));
            // 添加角色弹框 新增checkbox
            roleAddCreCheckbox.click();
            //输入角色名称后，再次检查是否有错误
            try {
                //角色名称输入框check
                driver.findElement(By.className("has-error"));
                //找得到，表示角色输入内容不符合规范，返回1
                return 1;

            //找不到检查报错的输入框,表示角色名称可用，继续执行
            } catch (NoSuchElementException e2) {

                // 添加角色弹框--编辑权限checkbox
                WebElement roleAddModCheckbox = driver.findElement(By.xpath(ROLE_ADD_CKBX_MODF_XP));
                roleAddModCheckbox.click();
                // 添加角色弹框--删除权限checkbox
                WebElement roleAddDelCheckbox = driver.findElement(By.xpath(ROLE_ADD_CKBX_DEL_XP));
                roleAddDelCheckbox.click();

//                List<String> idList = null;
//                idList.add(ROLE_SYS_MNG_ID);
//                idList.add(ROLE_DEV_MNG_ID);
//                idList.add(ROLE_VIS_OPS_ID);
//                idList.add(ROLE_DATA_REPO_ID);
//                idList.add(ROLE_EXPA_BUSI_ID);
//                idList.add(ROLE_DATA_BAK_ID);
//                idList.add(ROLE_MESH_PREV_ID);
//                idList.add(ROLE_RUL_ENG_ID);
//                idList.add(ROLE_SYS_TOOL_ID);
//                idList.add(ROLE_SYS_LOG_ANAL_ID);
//                
//                for (String id : idList) {
//                	driver.findElement(By.id(id)).click();
//                }
                // 定义 添加角色弹框--菜单元素列表
//                List<WebElement> eleLists = null;
                // 添加角色弹框--系统管理勾选框id
                driver.findElement(By.id(ROLE_SYS_MNG_ID)).click();
//                eleLists.add(driver.findElement(By.id(ROLE_SYS_MNG_ID)));
                
                // 添加角色弹框--设备管理勾选框id
                driver.findElement(By.id(ROLE_DEV_MNG_ID)).click();
//                eleLists.add(driver.findElement(By.id(ROLE_DEV_MNG_ID)));
                // 添加角色弹框--可视化运维勾选框id
                driver.findElement(By.id(ROLE_VIS_OPS_ID)).click();
//                eleLists.add(driver.findElement(By.id(ROLE_VIS_OPS_ID)));
                // 添加角色弹框--数据报表勾选框id
                driver.findElement(By.id(ROLE_DATA_REPO_ID)).click();
//                eleLists.add(driver.findElement(By.id(ROLE_DATA_REPO_ID)));
                // 添加角色弹框--扩展业务勾选框id
                driver.findElement(By.id(ROLE_EXPA_BUSI_ID)).click();
//                eleLists.add(driver.findElement(By.id(ROLE_EXPA_BUSI_ID)));
                // 添加角色弹框--数据备份勾选框id
                driver.findElement(By.id(ROLE_DATA_BAK_ID)).click();
//                eleLists.add(driver.findElement(By.id(ROLE_DATA_BAK_ID)));
                // 添加角色弹框--MESH预览勾选框id
                driver.findElement(By.id(ROLE_MESH_PREV_ID)).click();
//                eleLists.add(driver.findElement(By.id(ROLE_MESH_PREV_ID)));
                // 添加角色弹框--规则引擎勾选框id
                driver.findElement(By.id(ROLE_RUL_ENG_ID)).click();
//                eleLists.add(driver.findElement(By.id(ROLE_RUL_ENG_ID)));
                // 添加角色弹框--系统工具勾选框id
                driver.findElement(By.id(ROLE_SYS_TOOL_ID)).click();
//                eleLists.add(driver.findElement(By.id(ROLE_SYS_TOOL_ID)));
                // 添加角色弹框--系统日志分析勾选框id
//                driver.findElement(By.id(ROLE_SYS_LOG_ANAL_ID)).click();
//                eleLists.add(driver.findElement(By.id(ROLE_SYS_LOG_ANAL_ID)));
                // 遍历勾选菜单checkbox
//                for ( WebElement element : eleLists ) {
//                    element.click();
//                }

                // 添加角色弹框--提交xp
                roleAddSubmit = driver.findElement(By.xpath(ROLE_ADD_SBMT_XP));
                // 添加角色弹框 提交按钮
                roleAddSubmit.click();

                // 返回主内容
                driver.switchTo().defaultContent();
                // 添加角色弹框--提交确认xp
                roleAddSubmitConfirm = driver.findElement(By.className(ROLE_ADD_SBMT_CFM_CL));
                // 添加角色弹框 提交按钮
                roleAddSubmitConfirm.click();
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            }
        }
        return 0;
    }
    
    
    
    /**
     * @Description    角色查询
     * @param roleName 角色名称
     * @return 0：正常返回; -1：异常返回
     * @throws Exception
     */
    public int queryRole(String roleName) throws Exception{
    	qurBtn.click();	// 点击查询按钮
    	driver.switchTo().defaultContent();
    	
    	try {
	    	// 角色查询div
	    	WebElement roleQueryDiv = driver.findElement(By.className(ROLE_QUR_DIV_CL));
	    	// 角色查询div下的frame tag
	    	driver.switchTo().frame(roleQueryDiv.findElement(By.tagName(WEB_ELE_TAG_FRM)));
	    	// 输入角色名称
	    	WebElement roleQueryRoleName = driver.findElement(By.id(ROLE_QUR_NAME_ID));
	    	roleQueryRoleName.clear();
	    	roleQueryRoleName.sendKeys(roleName);
	    	// 点击确认
	    	driver.findElement(By.xpath(ROLE_QUR_CFM_XP)).click();

            // 返回主内容
            driver.switchTo().defaultContent();
            // 切换到mainFrame
            driver.switchTo().frame(MAIN_FRM_ID);
//	    	return ifRoleExists(roleName);
	    
    	} catch (NoSuchElementException e) {
    		e.printStackTrace();
    		return -1; 

    	}
    	return 0;
    }
    
    
    
    /**
     * @Description    判断角色名称是否存在
     * @param roleName
     * @return 0：存在；
 	 *		   1：不存在；
 	 *		   -1：输入的roleName为空
     */
    public int ifRoleExists(String roleName) {
    	if (isNull(roleName)) {
    		print("输入的roleName为空");
    		return -1;
    	} else {
    		// 判断列表第一条是否存在
	    	boolean flag = waitForElementVisible(driver, By.xpath(ROLE_LIST_NAME_1ST_XP), 5);
	        if (flag) {
	        	// 获取第一条记录的角色名称text内容
	        	String roleNameTxt = driver.findElement(By.xpath(ROLE_LIST_NAME_1ST_XP)).getText();
	        	if (roleName.equals(roleNameTxt)) {
	        		return 0;
	        	}
	        }
    	}
    	return 1;
    	
    }
    
    
    /**
     * @Description    删除查询到的某个角色
     * @return 0:删除成功; -1:异常返回
     * @throws Exception
     */
    public int deleteRole() throws Exception {
    	// 勾选第一条记录的checkbox，点击删除按钮
    	driver.findElement(By.xpath(ROLE_LIST_CHKBX_1ST_XP)).click();
    	delBtn.click();
    	driver.switchTo().defaultContent();
    	try {
	    	// 角色删除div
	    	WebElement roleQueryDiv = driver.findElement(By.className(ROLE_DEL_DIV_CL));
	    	// 点击确认
	    	driver.findElement(By.className(ROLE_DEL_CFM_CL)).click();
	    	sleep(3000);
            // 返回主内容
//            driver.switchTo().defaultContent();
            // 切换到mainFrame
            driver.switchTo().frame(MAIN_FRM_ID);
    	} catch (NoSuchElementException e) {
    		e.printStackTrace();
    		return -1; 
    	}
    	return 0;
    
    }
    
    
    /**
     * @Description    修改查询到的某个角色
     * @return 0:修改成功; -1:异常返回
     * @throws Exception
     */
    public int modifyRole(String roleName) throws Exception {
    	// 勾选第一条记录的checkbox，点击删除按钮
    	driver.findElement(By.xpath(ROLE_LIST_CHKBX_1ST_XP)).click();
    	modBtn.click();
    	driver.switchTo().defaultContent();
    	sleep(2000);
    	try {
            //添加角色div class
            WebElement roleAddDiv = driver.findElement(By.className(ROLE_ADD_DIV_CL));
            //添加角色frame tag
            WebElement roleAddFrame = roleAddDiv.findElement(By.tagName(WEB_ELE_TAG_FRM));
            driver.switchTo().frame(roleAddFrame);
            // 添加角色弹框--角色名称
            WebElement roleAddRoleName = driver.findElement(By.xpath(ROLE_NAME_XP));
            
            // 填写角色信息
            roleAddRoleName.sendKeys(roleName + "123");
            // 添加角色弹框--新增权限checkbox
            WebElement roleAddCreCheckbox = driver.findElement(By.xpath(ROLE_ADD_CKBX_ADD_XP));
            // 点击 添加角色弹框 新增checkbox
            roleAddCreCheckbox.click();
            
            // 添加角色弹框--提交xp
            roleAddSubmit = driver.findElement(By.xpath(ROLE_ADD_SBMT_XP));
            // 添加角色弹框 提交按钮
            roleAddSubmit.click();

            // 返回主内容
            driver.switchTo().defaultContent();
            // 添加角色弹框--提交确认xp
            roleAddSubmitConfirm = driver.findElement(By.className(ROLE_ADD_SBMT_CFM_CL));
            // 添加角色弹框 提交按钮
            roleAddSubmitConfirm.click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            
            //检查是否有错误
	    	// 角色删除div
//	    	WebElement roleQueryDiv = driver.findElement(By.className(ROLE_DEL_DIV_CL));
	    	// 点击确认
//	    	driver.findElement(By.className(ROLE_DEL_CFM_CL)).click();
//	    	sleep(3000);
//            // 返回主内容
////            driver.switchTo().defaultContent();
            // 切换到mainFrame
            driver.switchTo().frame(MAIN_FRM_ID);
    	} catch (NoSuchElementException e) {
    		e.printStackTrace();
    		return -1; 
    	}
    	return 0;
    
    }
}
