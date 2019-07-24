package com.tbl.test.selenium.base;

import static com.tbl.test.selenium.base.constantsOfNoah.DRIVER_GET_METHOD;
import static com.tbl.test.selenium.base.constantsOfNoah.DRIVER_NAVIGATE_REFRESH;
import static com.tbl.test.selenium.base.constantsOfNoah.DRIVER_SWTH_DFLT_CONT;
import static com.tbl.test.selenium.base.constantsOfNoah.DRIVER_SWTH_FRAME;

import org.openqa.selenium.By;

import static com.tbl.test.selenium.base.constantsOfNoah.DRIVER_SWITCHTO;

public class DriverOperation extends BasePage {
	
	public static void get(String url) {
		driver.get(url);
	}
	
	public static void refresh() {
		driver.navigate().refresh();
	}
	
	/**
	 * 
	 * @param type	switchTo 类型，基本分为defaultContent和frame,frameClassName'
	 * 				frameClassName先获取到相应className的元素，然后获取tag为iframe的frame
	 * @param element
	 */
	public static void switchTo(String type, String element) {
		if (isNull(type)) {
			print("switchTo执行失败！type为空！");
		}
		if (DRIVER_SWTH_DFLT_CONT.equals(type)) {
			driver.switchTo().defaultContent();
		} else if (DRIVER_SWTH_FRAME.equals(type)) {
			driver.switchTo().frame(element);
		} else if ("iframe".equals(type)) {
			driver.switchTo().frame(driver.findElement(By.xpath(element)));
		}
	}
	
	
	public static void action (StepModel step) {
		if (isNull(step.getAction())) {
			printErr("action为空！请确认！");
		}
		
		if (DRIVER_GET_METHOD.equals(step.getAction())) {
			get(step.getElement());
		} else if (DRIVER_NAVIGATE_REFRESH.equals(step.getAction())) {
			refresh();
		} else if (DRIVER_SWITCHTO.equals(step.getAction())) {
			switchTo(step.getType(), step.getElement());
		} else {
				printErr("无法识别的action: " + step.getAction());
		}
	}
}
