package com.tbl.test.selenium.Page;

import static com.tbl.test.selenium.base.constantsOfNoah.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tbl.test.selenium.base.BasePage;


public class RoleAddPage extends BasePage {
	
	@FindBy(className=ROLE_ADD_DIV_CL)
	public WebElement roleAddDiv;	//添加角色div class
	
	@FindBy(xpath=ROLE_NAME_XP)
	public WebElement roleAddRoleName;	// 添加角色弹框--角色名称
	
	@FindBy(xpath=ROLE_ADD_CKBX_ADD_XP)
	public WebElement roleAddCreCheckbox;	// 添加角色弹框--新增权限checkbox
}
