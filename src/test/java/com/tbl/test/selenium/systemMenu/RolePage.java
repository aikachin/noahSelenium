package com.tbl.test.selenium.systemMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.tbl.test.selenium.base.constantsOfNoah.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Aikachin
 * @Date: 2019/2/20 16:34
 * @Description: 用户管理页面.
 * @Modified by {who Time}
 */
public class RolePage {
    WebDriver driver;
    WebElement addBtn;  // 添加
    WebElement modBtn;  // 编辑
    WebElement delBtn;  // 删除
    WebElement disBtn;  // 禁用
    WebElement ablBtn;  // 启用
    WebElement SchBtn;  // 查询

    WebElement roleAddSubmit;    // 添加角色弹框 提交按钮
    WebElement roleAddSubmitConfirm;    // 添加角色弹框 提交按钮


    public RolePage(WebDriver driver) {
        this.driver = driver;
        // 添加按钮
        addBtn = driver.findElement(By.xpath(ROLE_ADD_XP));

    }

    /**
     * @Description    添加角色
     * @param roleName 角色名称
     * @return  0：正常
     *          1：角色名称不符合规范
     *          -1：未知异常
     * @throws Exception
     */
    @SuppressWarnings("null")
	public int addRole( String roleName) throws Exception{
        // 点击添加
        addBtn.click();
        // 返回主内容
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        //添加角色div class
        WebElement roleAddDiv = driver.findElement(By.className(ROLE_ADD_DIV_CL));
        //添加角色frame tag
        WebElement roleAddFrame = roleAddDiv.findElement(By.tagName(ROLE_ADD_FRM_TAG));
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
        
        // TODO 缺少添加角色后的验证
        // 尝试使用页面列表角色名称的text是否存在角色名称来验证
        
        return 0;
    }
}
