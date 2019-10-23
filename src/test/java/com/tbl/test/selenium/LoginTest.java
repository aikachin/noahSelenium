package com.tbl.test.selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbl.test.selenium.base.BasePage;

/**
 * @Auther: Aikachin
 * @Date: 2018/11/9 15:29
 * @Description: 测试登录
 * @Modified by: Aikachin 添加测试用例 2019/2/11
 */
public class LoginTest extends BasePage {

	@BeforeMethod
	public void setUp() throws Exception {
//		#print("开始执行测试");
		browserType = getValue("BROWSER_TYPE");
		String url = getValue("URL_OF_NOAH");
		mainOperation.openMainPage(url);
	}

	
	 @BeforeClass
	 public void beforeClass() throws Exception{
		print("开始执行测试");
//		browserType = getValue("BROWSER_TYPE");
//		String url = getValue("URL_OF_NOAH");
//		mainOperation.openMainPage(url);
		
	 }
	 

	@Test
	// Case1.成功
	public void testLogin() throws Exception {
		if ("2".equals(browserType)) {
			// Firefox不兼容，需要处理默认弹出框
			driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='安装'])[1]/following::span[1]"))
					.click();
		}
		System.out.println("------Case1.开始测试登录成功...");
		// 使用账号密码进行登录
		retCode = mainOperation.login("noah", "123456");
		if ( retCode == -1) {
			print("无法进入登录页，测试终止！");
			driver.quit();
		}
		Assert.assertEquals(retCode, 0);

		Thread.sleep(2000);
	}

	@Test
	// Case2.密码错误，登录失败
	public void testLoginFailed() throws Exception {
		System.out.println("------Case2.开始测试密码错误，登录失败...");
		if ("2".equals(browserType)) {
			// Firefox不兼容，需要处理默认弹出框
			driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='安装'])[1]/following::span[1]"))
					.click();
		}
		// 使用账号密码进行登录
		retCode = mainOperation.login("admin", "sonriku1");
		Assert.assertEquals(retCode, 1);

		Thread.sleep(2000);
	}

	// @Test
	// Case3.不输入密码，登录失败
	public void testLoginFailed2() throws Exception {
		System.out.println("------Case3.开始测试不输入密码，登录失败..");
		if ("2".equals(browserType)) {
			// Firefox不兼容，需要处理默认弹出框
			driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='安装'])[1]/following::span[1]"))
					.click();
		}
		// 使用账号密码进行登录
		retCode = mainOperation.login("admin", "");
		Assert.assertEquals(retCode, 1);
		Thread.sleep(2000);
	}

	// @Test
	// Case4.用户名错误，登录失败
	public void testLoginFailed3() throws Exception {
		System.out.println("------Case4.开始测试用户名错误，登录失败..");
		if ("2".equals(browserType)) {
			// Firefox不兼容，需要处理默认弹出框
			driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='安装'])[1]/following::span[1]"))
					.click();
		}
		// 使用账号密码进行登录
		retCode = mainOperation.login("admin1", "sonriku");
		Assert.assertEquals(retCode, 1);
		Thread.sleep(2000);
	}

//	@Test
	// Case5.用户名为空，登录失败
	public void testLoginFailed4() throws Exception {
		System.out.println("------Case5.开始测试用户名为空，登录失败..");
		if ("2".equals(browserType)) {
			// Firefox不兼容，需要处理默认弹出框
			driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='安装'])[1]/following::span[1]"))
					.click();
		}
		// 使用账号密码进行登录
		retCode = mainOperation.login("", "sonriku");
		Assert.assertEquals(retCode, 1);
		Thread.sleep(2000);
	}

	@Test
	// Case6.用户名为空，登录失败
	public void testLoginFailed5() throws Exception {
		System.out.println("------Case6.开始测试用户名密码为空，登录失败..");
		if ("2".equals(browserType)) {
			// Firefox不兼容，需要处理默认弹出框
			driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='安装'])[1]/following::span[1]"))
					.click();
		}

		// 使用账号密码进行登录
		retCode = mainOperation.login("", "");
		Assert.assertEquals(retCode, 1);
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		if (retCode == 0) {
			// 注销
			mainOperation.logout();
		}
//		Thread.sleep(1000);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		print("开始退出并关闭driver");
		Thread.sleep(1000);
//		driver.close();		// 单独执行时建议开启，表示执行完毕后关闭浏览器
//		driver.quit();
	}

//    @DataProvider(name = "Name")
//    public static Object[][] Name() {
//        return null;
//    }
}
