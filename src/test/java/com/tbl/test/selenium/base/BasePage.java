package com.tbl.test.selenium.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.tbl.test.selenium.Page.MainOperation;
import com.tbl.test.selenium.Page.MainPage;
import com.tbl.test.selenium.util.BaseUtils;;

public class BasePage extends BaseUtils{
	//全局的webdirver
	protected static WebDriver driver = BaseUtils.getBrowser();
	
	protected static MainOperation mainOperation = new MainOperation();
	protected static MainPage mainPage = new MainPage();
	
	protected static int retCode;
	protected static String browserType;

//	protected static Properties properties = new Properties();
//	
//	static {
//		try {
//			//读取配置文件
//			properties.load(new FileInputStream("ref/config.properties"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
    /**
     * 取得配置文件中的值
     * @throws IOException 
     * @throws FileNotFoundException 
     * @return String
     */
	public static String getValue(String property) throws FileNotFoundException, IOException {
//    	Properties properties = new Properties();
//    	properties.load(new FileInputStream("ref/config.properties"));
    	String value = properties.getProperty(property);
    	return value;
    }
}
