package com.tbl.test.selenium.test;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tbl.test.selenium.base.CaseModel;
import com.tbl.test.selenium.base.CaseType;
import com.tbl.test.selenium.base.ExcuteCase;


public class TestSystemManagement extends SuiteConfig {
	
	@Test(dataProvider = "user")
	  public void userManagement(
			  CaseModel caseModel) {
		  print("执行用例：" + caseModel.getCaseName());
		  Assert.assertEquals(ExcuteCase.excuteCase(caseModel), 0);
	  }
	  @Test(dataProvider = "role")
	  public void roleManagement(
			  CaseModel caseModel) {
		  print("执行用例：" + caseModel.getCaseName());
		  Assert.assertEquals(ExcuteCase.excuteCase(caseModel), 0);
	  }
	  @Test(dataProvider = "department")
	  public void departManagement(
			  CaseModel caseModel) {
		  print("执行用例：" + caseModel.getCaseName());
		  Assert.assertEquals(ExcuteCase.excuteCase(caseModel), 0);
	  }
	 
	  @DataProvider
	  public Object[] user() throws IOException {
		List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah-system.xlsx",CaseType.USER_CASE);
		int size = caseList.size();
		Object[] cases = new Object[size];
		for (int i = 0; i < size; i++) {
			cases[i] = caseList.get(i);
		}
		return cases;
	  }
	  
	  @DataProvider
	  public Object[] role() throws IOException {
		List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah-system.xlsx",CaseType.ROLE_CASE);
		int size = caseList.size();
		Object[] cases = new Object[size];
		for (int i = 0; i < size; i++) {
			cases[i] = caseList.get(i);
		}
		return cases;
	  }
	  
	  @DataProvider
	  public Object[] department() throws IOException {
		List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah-system.xlsx",CaseType.DEPARTMENT_CASE);
		int size = caseList.size();
		Object[] cases = new Object[size];
		for (int i = 0; i < size; i++) {
			cases[i] = caseList.get(i);
		}
		return cases;
	  }
 }
