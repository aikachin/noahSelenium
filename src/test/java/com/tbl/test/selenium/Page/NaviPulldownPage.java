package com.tbl.test.selenium.Page;

import static com.tbl.test.selenium.base.constantsOfNoah.LOGOUT_XP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tbl.test.selenium.base.BasePage;

public class NaviPulldownPage extends BasePage {
	
	@FindBy(xpath=LOGOUT_XP)
	@CacheLookup
    static WebElement logoutLink;  // 注销
	
	public NaviPulldownPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void logout() {
		logoutLink.click();
	}
}
