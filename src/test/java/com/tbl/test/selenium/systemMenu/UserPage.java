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
public class UserPage {

    WebDriver driver;

    WebElement addBtn;  // 添加
    WebElement modBtn;  // 编辑
    WebElement delBtn;  // 删除
    WebElement disBtn;  // 禁用
    WebElement ablBtn;  // 启用
    WebElement SchBtn;  // 查询


    public UserPage(WebDriver driver) {
        this.driver = driver;
        // 添加按钮
        addBtn = driver.findElement(By.xpath(USER_ADD_XP));

    }


    /**
     * @Description    添加用户
     * @param userInfo  String[],用户信息，包括用户名，密码，确认密码，性别，手机号，Email，备注等
     * @return 0：正常
     *         1：用户名不符合规范
     *         -1：未知异常
     * @throws Exception
     */
    public int addUser(List<String> userInfo) throws Exception{
        // 点击添加按钮
        addBtn.click();
        // 返回主内容
        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        //添加用户div class
        WebElement userAddDiv = driver.findElement(By.className(USER_ADD_DIV_CL));
        //添加用户frame tag
        WebElement userAddFrame = userAddDiv.findElement(By.tagName(USER_ADD_FRM_TAG));
        driver.switchTo().frame(userAddFrame);
        // 添加用户弹框--用户名称
        WebElement userAddUserName = driver.findElement(By.xpath(USER_NAME_XP));
        //检查是否有错误
        try {
            //检查是否存在报错的元素
            driver.findElement(By.className("has-error"));
            //刚打开添加弹框时，就找到错误元素，表示发生未知错误，返回-1
            return -1;

        //找不到表示正常，继续执行，输入用户信息
        } catch (NoSuchElementException e) {
            // 用户名
            userAddUserName.sendKeys(userInfo.get(0));
            // 密码
            driver.findElement(By.xpath(USER_PWD_XP)).sendKeys(userInfo.get(1));

            //输入用户名称后，再次检查是否有错误
            try {
                //检查是否存在报错的元素
                driver.findElement(By.className("has-error"));
                //找得到，表示用户输入内容不符合规范，返回1
                return 1;

                //找不到检查报错的输入框,表示用户名称可用，继续执行
            } catch (NoSuchElementException e2) {
                // 确认密码
                driver.findElement(By.xpath(CONFIRM_PWD_XP)).sendKeys(userInfo.get(2));
                // 性别
                if ("男".equals(userInfo.get(3))) {
                    //选择男
                    driver.findElement(By.xpath(MALE_XP)).click();
                } else {
                    //选择女
                    driver.findElement(By.xpath(FEMALE_XP)).click();
                }
                // 真实姓名
                driver.findElement(By.xpath(TRUE_NAME_XP)).sendKeys(userInfo.get(4));

                // 所属部门
                driver.findElement(By.xpath(DEPT_XP)).click();
//                List<WebElement> dept_list = driver.findElements(By.tagName("li"));
//                System.out.println(dept_list.size());
                // 部门选择第一个下拉选项
                WebElement dept = driver.findElement(By.cssSelector("#select2-results-1 > li:nth-child(2)"));
//                System.out.println("#select2-results-1 > li:nth-child(2)的getText()返回： " + dept.getText());
                dept.click();
//                driver.findElement(By.xpath(DEPT_1st_XP)).click();

                // 角色
                driver.findElement(By.xpath(USER_POP_ROLE_XP)).click();
//                List<WebElement> role_list = driver.findElements(By.tagName("li"));
//                System.out.println(role_list.size());
                // 角色选择第一个下拉选项
                WebElement role = driver.findElement(By.cssSelector("#select2-results-2 > li:nth-child(3)"));
//                System.out.println("#select2-results-2 > li:nth-child(3)的getText()返回： " + role.getText());
                role.click();
//                driver.findElement(By.xpath(USER_POP_ROLE_1st_XP)).click();

                // 手机号
                driver.findElement(By.id(USER_MBPH_NUM_ID)).sendKeys(userInfo.get(5));
                // Email
                driver.findElement(By.id(USER_EMAIL_ID)).sendKeys(userInfo.get(6));
                // 备注
                driver.findElement(By.id(USER_REMARK_ID)).sendKeys(userInfo.get(7));
                // 添加用户弹框--提交按钮
                driver.findElement(By.xpath(USER_ADD_SBMT_XP)).click();

                // 返回主内容
                driver.switchTo().defaultContent();
                // 添加用户弹框--提交确定按钮
                driver.findElement(By.className(USER_ADD_CNFM_CL)).click();

                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            }
        }

        return 0;
    }
}
