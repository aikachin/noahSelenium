package com.tbl.test.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.tbl.test.selenium.util.BaseUtils.*;
import static org.testng.Assert.assertEquals;
import static com.tbl.test.selenium.util.WebDriverUtil.waitForElementVisible;

import java.rmi.RemoteException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebElementOperation extends BasePage {
	
	public static WebElement getElement(String type, String element) {
		if (isNull(type) || isNull(element)) {
			printErr("元素类型为空或元素值为空！");
			return null;
		}
		WebElement webElement = null;
//		WebDriverWait wait = new WebDriverWait(driver, 10);
		if (type.equals("Id")) {
			webElement = driver.findElement(By.id(element));
		} else if (type.equals("XPath")) {
			webElement = driver.findElement(By.xpath(element));
		} else if (type.equals("ClassName")) {
			webElement = driver.findElement(By.className(element));
		} else if (type.equals("CssSelector")) {
			webElement = driver.findElement(By.cssSelector(element));
		} else if (type.equals("TagName")) {
			webElement = driver.findElement(By.tagName(element));
		} else if (type.equals("PartialLinkText")) {
			webElement = driver.findElement(By.partialLinkText(element));
		} else if (type.equals("Name")) {
			webElement = driver.findElement(By.name(element));
		} else if (type.equals("LinkText")) {
			webElement = driver.findElement(By.linkText(element));
		} else {
			try {
				printErr("未找到元素, type: " + type + ", element: " + element);
				throw new RemoteException();
			} catch (RemoteException e ) {
				e.printStackTrace();
			}
		} 
		
		// 等待元素出现
//		wait.until(ExpectedConditions.visibilityOf(webElement));

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return webElement;
		
	}
	
	
	public static By getElementBy(String type, String element) {
		if (isNull(type) || isNull(element)) {
			printErr("元素类型为空或元素值为空！");
			return null;
		}
		By by = null;
//		WebDriverWait wait = new WebDriverWait(driver, 10);
		if (type.equals("Id")) {
			by = By.id(element);
		} else if (type.equals("XPath")) {
			by = By.xpath(element);
		} else if (type.equals("ClassName")) {
			by = By.className(element);
		} else if (type.equals("CssSelector")) {
			by = By.cssSelector(element);
		} else if (type.equals("TagName")) {
			by = By.tagName(element);
		} else if (type.equals("PartialLinkText")) {
			by = By.partialLinkText(element);
		} else if (type.equals("Name")) {
			by = By.name(element);
		} else if (type.equals("LinkText")) {
			by = By.linkText(element);
		} else {
			try {
				printErr("未找到元素, type: " + type + ", element: " + element);
				throw new RemoteException();
			} catch (RemoteException e ) {
				e.printStackTrace();
			}
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return by; 
	}
	
	
	public static int elementAction(StepModel stepModel) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
		String action = stepModel.getAction();
		String value = stepModel.getValue();
		String type = stepModel.getType();
		String element = stepModel.getElement();
		String expectation = stepModel.getExpectation();
		WebElement webElement = getElement(type, element);
		if (isNull(action)) {
			printErr("action为空！");
			return -1;
		}
		if ("click".equals(action)) {
			webElement.click();
		} else if ("sendKeys".equals(action)) {
			webElement.clear();
//			webElement.click();	//sendKeys感觉不需要click操作，暂且去除。起因：在使用导入rfid设备时无法点击该元素，只需直接上传文件即可。
			
			//如果包括random，则进行随机数拼接处理
	    	if (value.contains("random(")) {
	    		value = getRandomNum(value);
	    	}
			webElement.sendKeys(value);
		} else if("keyboard".equals(action)) {
			switch (value) {  // 未补充完整
			case "Keys.ENTER":
				webElement.sendKeys(Keys.ENTER);
				break;
			case "Keys.UP":
				webElement.sendKeys(Keys.UP);
				break;
			case "Keys.DOWN":
				webElement.sendKeys(Keys.DOWN);
				break; 
			case "Keys.SPACE":
				webElement.sendKeys(Keys.SPACE);
				break; 
			case "Keys.BACK_SPACE":
				webElement.sendKeys(Keys.BACK_SPACE);
				break; 
			}
				
		}else if ("submit".equals(action)) {
			webElement.submit();
		} else if ("getText".equals(action)) {
			String actual = webElement.getText();
			assertEquals(actual, expectation);
		} else if ("moveToElement".equals(action)) {
			Actions actions = new Actions(driver);
			actions.moveToElement(webElement).perform();
		} else if ("moveToElementClick".equals(action)) {
			Actions actions = new Actions(driver);
			actions.moveToElement(webElement).build().perform();
			actions.click(webElement).perform();
		}else if("countLi".equals(action)) {  //用来验证权限菜单内容和个数，暂时用xpath写死
			List<WebElement> lis  = webElement.findElements(By.xpath("li"));
			int num = lis.size();
			String totalmenu = "";
			for(int i=0;i<num;i++) {
				String menu = lis.get(i).getText();
				totalmenu = totalmenu+","+ menu ;
			}
//			print(totalmenu);
			String strnum =  String.valueOf(num);
			String actual = strnum+totalmenu;
//			print(actual);
			assertEquals(actual, expectation);
			
		}else if("getAttributeValue".equals(action)) {
			//查找元素属性值
			String attributevalue=webElement.getAttribute(value);
			assertEquals(attributevalue, expectation);
		}

//		try {
//			sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return 0;
	}
	
	
	/**
	 * 判断元素是否显示
	 * @param stepModel
	 * @return 0: 元素显示；
	 *		   1: 元素不显示；
	 *		   -1: 异常返回
	 */
	public static int ifElementAvailable(StepModel stepModel) {
		String type = stepModel.getType();
		String element = stepModel.getElement();
		int time = -1;
		int retCode = -1;
		boolean flag = false;
		try {
			time = Integer.parseInt(stepModel.getValue());
			flag = waitForElementVisible(driver, getElementBy(type, element), time);
			print("element:" + element);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			// 元素存在，表示正常，返回0
			retCode = 0;
		} else {
			// 元素不存在，表示出错，返回1
			retCode = 1;
		}
		
		return retCode;
	}
	
	
    /**
     * 获取随机名或数字
     * @param value 原始参数，格式可以是：【test+random(1000)】，则返回[test123]格式的内容；random(1000)返回100-999的随机数
     * @return 返回带有随机数的字符串
     */
    public static String getRandomNum(String value) {

    	String retValue = null;
		int randomNum = 0;
		int index = value.indexOf("random(") + 7;
		try {
			// 获取()括号内的随机数范围
    		int range = Integer.parseInt(value.substring(index, value.length() - 1));
    		randomNum = (int) (Math.random()*range/10*9 + range/10);
//        	print(randomNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

    	if (!value.startsWith("random")) {
   			retValue = value.substring(0, value.indexOf("random(") - 1) + String.valueOf(randomNum);
       	} else {
       		retValue = String.valueOf(randomNum);
       	}
    	return retValue;
    	
    }
}
