package com.tbl.test.selenium.base;

import com.tbl.test.selenium.Page.MainOperation;
import com.tbl.test.selenium.Page.MainPage;
import com.tbl.test.selenium.util.BaseUtils;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BasePage extends BaseUtils {
	//全局的webdirver
	protected static WebDriver driver = BaseUtils.getBrowser();
	
	protected static MainOperation mainOperation = new MainOperation();
	protected static MainPage mainPage = new MainPage();
	
	protected static int retCode;
	protected static String browserType;

	protected static String rootPath = null;

//	protected static Properties properties = new Properties();
//	
	static {
		try {
			// 获取项目根目录
			rootPath = new File("").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		print(rootPath);
	}
	
    /**
     * 取得配置文件中的值
    * @return String
     */
	public static String getValue(String property) {
		return properties.getProperty(property);
    }
}
