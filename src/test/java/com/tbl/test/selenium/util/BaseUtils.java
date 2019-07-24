package com.tbl.test.selenium.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @Auther: Aikachin
 * @Date: 2018/11/9 14:08
 * @Description:
 * @Modified by:
 */
public class BaseUtils {
	
	protected static WebDriver driver = null;
	
	protected static Properties properties = new Properties();
	
	static {
		try {
			//读取配置文件
			
			properties.load(new FileInputStream("ref/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 取得浏览器driver类型
	 * @return WebDriver
	 */
	public static WebDriver getBrowser() {
		try {
//			properties.load(new FileInputStream("ref/config.properties"));
			String browserType = (String) getValue("BROWSER_TYPE");
//			print("browserType: " + browserType);
			if ("1".equals(browserType)) {
				// 1：Chrome
				String driverPath = (String) getValue("CHROME_DRIVER_PATH");
				System.setProperty("webdriver.chrome.driver", driverPath);
		        ChromeOptions options = new ChromeOptions();
		        options.addArguments("disable-infobars");
		        driver = new ChromeDriver(options);
			} else if ("2".equals(browserType)) {
				// 2：Firefox
				String driverPath = (String) getValue("GECKO_DRIVER_PATH"); 
				System.setProperty("webdriver.gecko.driver", driverPath);
		        driver = new FirefoxDriver();
			} else if ("3".equals(browserType)) {
				// 3：edge
				String driverPath = (String) getValue("EDGE_DRIVER_PATH");
		        System.setProperty("webdrvier.edge.driver", driverPath);
		        driver = new EdgeDriver();
			} else {
				// 4：chrome隐式模式
				String driverPath = (String) getValue("CHROME_DRIVER_PATH");
				System.setProperty("webdriver.chrome.driver", driverPath);
		        ChromeOptions options = new ChromeOptions();
		        options.addArguments("disable-infobars");
		        options.addArguments("--headless");
//		        options.addArguments("--no-sandbox");
//		        
//		        //options.setExperimentalOption("useAutomationExtension", false);
//
//		        options.addArguments("--disable-extensions"); // disabling extensions
//		        options.addArguments("--disable-gpu"); // applicable to windows os only
//		        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		        driver = new ChromeDriver(options);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	
	/**
	 * 打印，输出到控制台
	 * @param obj
	 */
    public static void print(Object obj) {
        System.out.println(obj);
    }
    

	/**
	 * 打印，输出错误到控制台
	 * @param obj
	 */
    public static void printErr(Object obj) {
        System.err.println(obj);
    }
    
    
    /**
     * 判断String类型参数是否为空
     * @param str
     * @return boolean
     */
    public static boolean isNull(String str) {
    	return str == null || str.trim().isEmpty();
    }
    
    
    /**
     * 判断String类型参数是否非空
     * @param str
     * @return boolean
     */
    public static boolean isNotNull(String str) {
    	if (str == null || "".equals(str)) {
    		return false; 
    	} else {
    		return true;
    	}
    }
    
    
    /**
     * 线程睡眠一段时间
     * @param milliseconds
     * @throws InterruptedException
     */
    public static void sleep(long milliseconds) throws InterruptedException{
    	Thread.sleep(milliseconds);
    }
    
    
    /**
     * 取得配置文件中的值
     * @throws IOException 
     * @throws FileNotFoundException 
     */
	public static Object getValue(String property) throws FileNotFoundException, IOException {
    	String value = properties.getProperty(property);
    	return value;
    }
}
