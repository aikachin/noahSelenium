package com.tbl.test.selenium.base;

import static com.tbl.test.selenium.util.BaseUtils.print;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CaseModel {
	// 用例名称
	String caseName;
	// 测试步骤列表
	List<StepModel> stepModels;
	
	/**
	 * @return the caseName
	 */
	public String getCaseName() {
		return caseName;
	}
	
	/**
	 * @param caseName the caseName to set
	 */
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	
	/**
	 * @return the stepModels
	 */
	public List<StepModel> getStepModels() {
		return stepModels;
	}
	
	/**
	 * @param stepModels the stepModels to set
	 */
	public void setStepModels(List<StepModel> stepModels) {
		this.stepModels = stepModels;
	}

	
	@SuppressWarnings({ "deprecation", "resource" })
	public static List<CaseModel> getCaseList(String path, CaseType caseType) {
		String fileType = path.substring(path.lastIndexOf("."));
		List<CaseModel> caseModels = new ArrayList<CaseModel>();
		List<StepModel> stepModels = new ArrayList<StepModel>();
		// 读取Excel文件
		InputStream is = null;
		try {
			// 获取文件输入流
			is = new FileInputStream(path);
			// 获取工作簿
			Workbook wb = null;
			if (fileType.equals(".xls")) {
				// 获取excel工作簿对象
				wb = new HSSFWorkbook(is);
			} else if (fileType.equals(".xlsx")) {
				wb = new XSSFWorkbook(is);
			} else {
				print("文件【" + fileType + "】不是Excel文件！");
				return null;
			}
			
			CaseModel caseModel = new CaseModel();
			int sheetIndex = 0;
			// 设定第一页为公共用例，后面为普通用例
			if(path.indexOf("device")!=-1) {
				switch (caseType) {
				case PUBLIC_CASE:
					sheetIndex = 0;
					break;
				case BUSINESS_CASE:
					sheetIndex = 1;
					break;
				case DEVICE_RFID:   //适用于noah-device
					sheetIndex = 3;
					break;
				case DEVICE_LMESH:
					sheetIndex = 4;
					break;
				case DEVICE_PTL:
					sheetIndex = 5;
					break;
				case DEVICE_HMESH:
					sheetIndex = 6;
					break;
				case DEVICE_UWB:
					sheetIndex = 7;
					break;
				case DEVICE_OTHER:
					sheetIndex = 8;
					break;
				default:
					break;
				}
			}
			if(path.indexOf("system")!=-1) {
				switch (caseType) {
				case PUBLIC_CASE:
					sheetIndex = 0;
					break;
				case BUSINESS_CASE:
					sheetIndex = 1;
					break;
				case USER_CASE:   //适用于noah-system
					sheetIndex = 3;
					break;
				case ROLE_CASE:
					sheetIndex = 4;
					break;
				case DEPARTMENT_CASE:
					sheetIndex = 5;
					break;
				default:
					break;
				}
			}
			
			
		  // 获取excel工作表对象
			Sheet sheet = wb.getSheetAt(sheetIndex);
			// 获取行数，因以空行作为记号，所以+1
			int lastRow = sheet.getLastRowNum() + 1;
			// 获取（所在行）列数
			int lastCell = sheet.getRow(0).getLastCellNum();
			// 因第一行为列标题，所以从下标1（即第2行）开始获取数据
			for ( int i = 1; i <= lastRow; i++) {
				Row row = sheet.getRow(i);
				StepModel stepModel = new StepModel();
				
				// 如遇空行，即表示一条case结束，
				if (row == null) {
					// 将stepModels交给caseModel
					caseModel.setStepModels(stepModels);
					
					// list添加一条case，初始化caseModel
					caseModels.add(caseModel);
					caseModel = new CaseModel();
					stepModels = new ArrayList<StepModel>();
					
					continue;	// 继续下一行
				}
				
				for (int j = 0; j < lastCell; j++) {
					String valueStr = "";
					Cell cell = row.getCell(j);
					if (cell == null) {
						valueStr = null;
					
					} else {
						// 将cell中的内容转化为字符串
						cell.setCellType(CellType.STRING);
						valueStr = cell.getStringCellValue();
//						print("(" +i+","+j+"):" + valueStr);
					}
					// 根据cellIndex添加对应参数值
					switch (j) {
					case 0:
						if (valueStr != null) {
							if (valueStr.length() > 0) {
								caseModel.setCaseName(valueStr);
							}
						}
						break;
					case 1:
						stepModel.setPrecondition(valueStr);
						break;
					case 2:
						stepModel.setStep(valueStr);
						break;
					case 4:
						stepModel.setObject(valueStr);
						break;
					case 5:
						stepModel.setType(valueStr);
						break;
					case 6:
						stepModel.setElement(valueStr);
						break;
					case 7:
						stepModel.setAction(valueStr);
						break;
					case 8:
						stepModel.setValue(valueStr);
						break;
					case 9:
						stepModel.setExpectation(valueStr);
						break;
					default:
						break;
					}
				}
//				print("stepModel:" + stepModel);
				
				// 下面的代码会报空指针异常，所以将stepModel先放到stepModels列表中，
				// 待一条case结束后，再将stepModels放进caseModels
//				caseModel.stepModels.add(stepModel);
				
				// 将获取到的stepModel添加到stepModels列表中
				stepModels.add(stepModel);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is !=null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return caseModels;
		
	}
}
