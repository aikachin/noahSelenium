package com.tbl.test.selenium.test;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbl.test.selenium.base.BasePage;
import com.tbl.test.selenium.base.CaseModel;
import com.tbl.test.selenium.base.CaseType;
import com.tbl.test.selenium.base.ExcuteCase;


public class TestSystemManagement extends BasePage {
	
	@Test(dataProvider = "user")
	  public void userManagement(
			  CaseModel caseModel) {
		  print("执行用例：" + caseModel.getCaseName());
		  ExcuteCase.excuteCase(caseModel);
	  }
	  @Test(dataProvider = "role")
	  public void roleManagement(
			  CaseModel caseModel) {
		  print("执行用例：" + caseModel.getCaseName());
		  ExcuteCase.excuteCase(caseModel);
	  }
	  @Test(dataProvider = "department")
	  public void departManagement(
			  CaseModel caseModel) {
		  print("执行用例：" + caseModel.getCaseName());
		  ExcuteCase.excuteCase(caseModel);
	  }
	 
	  @DataProvider
	  public Object[] user() throws IOException {
		List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah-user.xlsx",CaseType.BUSINESS_CASE);
		int size = caseList.size();
		
		Object[] cases = new Object[size];
		for (int i = 0; i < size; i++) {
			cases[i] = caseList.get(i);
		}
		return cases;
	  }
	  
	  @DataProvider
	  public Object[] role() throws IOException {
		List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah-role.xlsx",CaseType.BUSINESS_CASE);
		int size = caseList.size();
		Object[] cases = new Object[size];
		for (int i = 0; i < size; i++) {
			cases[i] = caseList.get(i);
		}
		return cases;
	  }
	  @DataProvider
	  public Object[] department() throws IOException {
		List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah-department.xlsx",CaseType.BUSINESS_CASE);
		int size = caseList.size();
		Object[] cases = new Object[size];
		for (int i = 0; i < size; i++) {
			cases[i] = caseList.get(i);
		}
		return cases;
	  }
 
    @BeforeTest
    public void beforeTest() {
        System.out.println("Start to test...");
        ExcuteCase.setPublicCaseList(CaseModel.getCaseList("ref/case/noah-user.xlsx", CaseType.PUBLIC_CASE));

    }

 
    @AfterTest
    public void afterTest() {
        System.out.println("Test finished!");
        driver.close();
        driver.quit();
    }
  
  
}
