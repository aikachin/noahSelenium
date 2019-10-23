package com.tbl.test.selenium.test;

import com.tbl.test.selenium.base.BasePage;
import com.tbl.test.selenium.base.CaseModel;
import com.tbl.test.selenium.base.CaseType;
import com.tbl.test.selenium.base.ExcuteCase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig extends BasePage {

    @BeforeSuite
    public void beforeSuite() {
    	ExcuteCase.setPublicCaseList(CaseModel.getCaseList("ref/case/noah-device.xlsx", CaseType.PUBLIC_CASE));
        System.out.println("开始执行测试套...");
    }
   
    @BeforeTest
    public void beforeTest() {
        System.out.println("开始执行测试用例...");
    }
 
    @AfterTest
    public void afterTest() {
        System.out.println("测试用例执行完毕...");
    }
    
    @AfterSuite
    public void afterSuite() {
    	driver.close();
        driver.quit();
        System.out.println("测试套执行完毕...");
    }

  
}

