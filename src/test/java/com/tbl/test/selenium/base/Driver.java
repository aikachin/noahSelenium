package com.tbl.test.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.tbl.test.selenium.base.constantsOfNoah.*;

import java.util.concurrent.TimeUnit;

public class Driver {
	
	public static WebDriver driver;
	
	
	public static synchronized WebDriver getBrowserDriver() {
		if (null == driver) {
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//			String url = URL_OF_NOAH;
//			driver.get(url);
		}
		return driver;
	}
	
	public static void get(String url) {
		getBrowserDriver().get(url);
	}
	
	public static void refresh() {
		getBrowserDriver().navigate().refresh();
	}
	
	public static void switchTo(String type, String element) {
		if (isNull(type)) {
			print("switchTo执行失败！type为空！");
		}
		if ("defaultContent".equals(type)) {
			getBrowserDriver().switchTo().defaultContent();
		} else if ("frame".equals(type)) {
			getBrowserDriver().switchTo().frame(element);
		}
	}
	
	public static void action(StepModel step) {
		if ("get".equals(step.getAction())) {
			get(step.getElement());
		} else if ("refresh".equals(step.getAction())) {
			refresh();
		} else if ("swtichTo".equals(step.getAction())) {
			switchTo(step.getType(), step.getElement());
			print("switchTo excuted!");
		} else {
			printErr("action为空！请确认！");
		}
	}
	
	public static void drvieClose() {
		getBrowserDriver().close();
		getBrowserDriver().quit();
	}
	
}
