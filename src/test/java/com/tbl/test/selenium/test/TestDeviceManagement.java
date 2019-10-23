package com.tbl.test.selenium.test;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tbl.test.selenium.base.CaseModel;
import com.tbl.test.selenium.base.CaseType;
import com.tbl.test.selenium.base.ExcuteCase;

public class TestDeviceManagement extends SuiteConfig {

  // rfid设备
  @Test(dataProvider = "rfid")
  public void device_RFID(
		  CaseModel caseModel) {
	  print("执行用例：" + caseModel.getCaseName());
	  Assert.assertEquals(ExcuteCase.excuteCase(caseModel), 0);
  }

	// 导入rfid设备
//	@Test(dataProvider = "import_rfid")
	public void device_RFID_import(
			CaseModel caseModel) {
		print("执行用例：" + caseModel.getCaseName());
		Assert.assertEquals(ExcuteCase.excuteCase(caseModel), 0);
	}

  // 低速mesh设备
//  @Test(dataProvider = "lmesh")
  public void device_LMESH(
		  CaseModel caseModel) {
	  print("执行用例：" + caseModel.getCaseName());
	  Assert.assertEquals(ExcuteCase.excuteCase(caseModel), 0);
  }

  // PTL+X设备
  @Test(dataProvider = "ptl")
  public void device_PTL(
		  CaseModel caseModel) {
	  print("执行用例：" + caseModel.getCaseName());
	  Assert.assertEquals(ExcuteCase.excuteCase(caseModel), 0);
  }

  // 高速mesh设备
  @Test(dataProvider = "hmesh")
  public void device_HMESH(
		  CaseModel caseModel) {
	  print("执行用例：" + caseModel.getCaseName());
	  Assert.assertEquals(ExcuteCase.excuteCase(caseModel), 0);
  }

  // UWB设备
  @Test(dataProvider = "uwb")
  public void device_UWB(
		  CaseModel caseModel) {
	  print("执行用例：" + caseModel.getCaseName());
	  Assert.assertEquals(ExcuteCase.excuteCase(caseModel), 0);
  }

  // 第三方设备
  @Test(dataProvider = "other")
  public void device_OTHER(
		  CaseModel caseModel) {
	  print("执行用例：" + caseModel.getCaseName());
	  Assert.assertEquals(ExcuteCase.excuteCase(caseModel), 0);
  }


  // rfid设备
  @DataProvider
  public Object[] rfid() throws IOException {
	List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah-device.xlsx",CaseType.DEVICE_RFID);
	int size = caseList.size();
	Object[] cases = new Object[size];
	for (int i = 0; i < size; i++) {
		cases[i] = caseList.get(i);
	}
	return cases;
  }

	// 导入rfid设备
	@DataProvider
	public Object[] import_rfid() throws IOException {
		List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah-device-rfid-import.xlsx",CaseType.DEVICE_RFID);
		int size = caseList.size();
		Object[] cases = new Object[size];
		for (int i = 0; i < size; i++) {
			cases[i] = caseList.get(i);
		}
		return cases;
	}

  // 低速mesh设备
  @DataProvider
  public Object[] lmesh() throws IOException {
	List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah-device.xlsx",CaseType.DEVICE_LMESH);
	int size = caseList.size();
	Object[] cases = new Object[size];
	for (int i = 0; i < size; i++) {
		cases[i] = caseList.get(i);
	}
	return cases;
  }

  // PTL+X设备
  @DataProvider
  public Object[] ptl() throws IOException {
	List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah-device.xlsx",CaseType.DEVICE_PTL);
	int size = caseList.size();
	Object[] cases = new Object[size];
	for (int i = 0; i < size; i++) {
		cases[i] = caseList.get(i);
	}
	return cases;
  }

  // 高速mesh设备
  @DataProvider
  public Object[] hmesh() throws IOException {
	List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah-device.xlsx",CaseType.DEVICE_HMESH);
	int size = caseList.size();
	Object[] cases = new Object[size];
	for (int i = 0; i < size; i++) {
		cases[i] = caseList.get(i);
	}
	return cases;
  }

  // UWB设备
  @DataProvider
  public Object[] uwb() throws IOException {
	List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah-device.xlsx",CaseType.DEVICE_UWB);
	int size = caseList.size();
	Object[] cases = new Object[size];
	for (int i = 0; i < size; i++) {
		cases[i] = caseList.get(i);
	}
	return cases;
  }

  // 第三方设备
  @DataProvider
  public Object[] other() throws IOException {
	List<CaseModel> caseList = CaseModel.getCaseList("ref/case/noah-device.xlsx",CaseType.DEVICE_OTHER);
	int size = caseList.size();
	Object[] cases = new Object[size];
	for (int i = 0; i < size; i++) {
		cases[i] = caseList.get(i);
	}
	return cases;
  } 
}

 