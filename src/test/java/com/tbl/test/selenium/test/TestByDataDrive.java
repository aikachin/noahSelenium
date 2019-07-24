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


public class TestByDataDrive extends BasePage {

    @Test(dataProvider = "dp")
    public void f(CaseModel caseModel) {
        print("执行用例：" + caseModel.getCaseName());
        ExcuteCase.excuteCase(caseModel);
    }

    @DataProvider
    public Object[] dp() throws IOException {
        List<CaseModel> caseList = CaseModel.getCaseList("ref/noah-device-rfid-import.xlsx", CaseType.BUSINESS_CASE);
    //  List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah.xlsx", CaseType.BUSINESS_CASE);
        int size = caseList.size();

        Object[] cases = new Object[size];
        for (int i = 0; i < size; i++) {
            cases[i] = caseList.get(i);
        }

//    	for (CaseModel caseModel : caseList) {
//    		print("caseName:" + caseModel.getCaseName());
//    		for (StepModel stepModel : caseModel.getStepModels()) {
//    			print("stepModel:" + stepModel);
//    		}
//    		
//    	}

        return cases;
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Start to test...");
        ExcuteCase.setPublicCaseList(CaseModel.getCaseList("ref/noah-device-rfid-import.xlsx", CaseType.PUBLIC_CASE));

    }

 
//    @AfterMethod
//    public void afterMethod() {
//        driver.navigate().refresh();
//        try {
//            sleep(2000);
//    	} catch (InterruptedException e) {
//    		// TODO Auto-generated catch block
//    		e.printStackTrace();
//    	}
//    }


    @AfterTest
    public void afterTest() {
        System.out.println("Test finished!");
        driver.close();
        driver.quit();
    }
  
  
}
