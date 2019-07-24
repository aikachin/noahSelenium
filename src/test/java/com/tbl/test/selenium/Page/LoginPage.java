package com.tbl.test.selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tbl.test.selenium.base.BasePage;

import static com.tbl.test.selenium.base.constantsOfNoah.*;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Aikachin
 * @Description: 登录页面
 *                       根据输入的用户名、密码，点击登录按钮来登录账号
 *                       或用cookies来获取登录信息
 * @Date: Created in 13:50 2018/11/9 0001.
 * @Modified by : Aikachin 2019/1/2
 */
public class LoginPage extends BasePage {
       
    @FindBy(id=LOGIN_USER_ID)
    @CacheLookup
    public WebElement username;    // 用户名
    
    @FindBy(id=LOGIN_PWD_ID)
    @CacheLookup
    public WebElement password;    // 密码
    
    @FindBy(className=LOGIN_BTN_CL)
    @CacheLookup
    public WebElement loginBtn;    //登录按钮

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    /**
     * 登录
     * @param userName
     * @param passWord
     */
    public void login(String userName, String passWord) {
    	username.clear();
        username.sendKeys(userName);
        password.clear();
        password.sendKeys(passWord);
        loginBtn.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
