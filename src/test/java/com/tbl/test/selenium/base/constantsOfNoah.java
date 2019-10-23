package com.tbl.test.selenium.base;

import com.tbl.test.selenium.util.BaseUtils;

/**
 * @Auther: Aikachin
 * @Date: 2018/11/9 13:58
 * @Description: 记录常量：主要包括Noah页面元素
 * @Modified by: Aikachin 2019/1/2
 */
public class constantsOfNoah extends BaseUtils {

    // Chrome driver路径
//    public static final String CHROME_DRIVER = "/usr/java/apache-tomcat-8.5.30/webapps/jenkins/workspace/wms/ref/webdriver/chromedriver";
//    public static final String CHROME_DRIVER = "E:\\software\\Git-repo\\noahSelenium\\ref\\webdriver\\chromedriver.exe";
//    public static final String CHROME_DRIVER = "./ref/webdriver/chromedriver.exe";
	

//    public static final String CHROME_DRIVER = "../ref/webdriver/chromedriver.exe";	// jenkins用这个
	public static final String CHROME_DRIVER = getValue("CHROME_DRIVER_PATH");
    
    // chrome drvier和chrome浏览器版本对应关系参考：
    // https://blog.csdn.net/u013783095/article/details/79851194
    // 下载参考： http://npm.taobao.org/mirrors/chromedriver/

    // Firefox gecko driver路径
    public static final String GECKO_DRIVER = getValue("GECKO_DRIVER_PATH");
    
    // Microsoft Edge driver路径
    public static final String EDGE_DRIVER = getValue("EDGE_DRIVER_PATH");
    
    // driver get method
    public static final String DRIVER_GET_METHOD = "get";
    
    // driver navigate refresh__refresh method
    public static final String DRIVER_NAVIGATE_REFRESH = "refresh";
    
    // driver switchTo method - switchTo
    public static final String DRIVER_SWITCHTO = "switchTo";
    
    // driver switchTo -- defaultContent
    public static final String DRIVER_SWTH_DFLT_CONT = "defaultContent";
    
    // driver switchTo -- frame
    public static final String DRIVER_SWTH_FRAME = "frame";
    
    // driver switchTo -- frame by div_className
    public static final String DRIVER_SWTH_DIV_FRAME = "frameClassName";
    
    // Noah首页
//    public static final String URL_OF_NOAH = "http://localhost:18080/noah_web";
    public static final String URL_OF_NOAH = getValue("URL_OF_NOAH");
    // mainFrame（页面右侧主内容区）
    public static final String MAIN_FRM_ID = getValue("MAIN_FRM_ID");

    // Noah登录页用户名输入框ID
    public static final String LOGIN_USER_ID = "loginname";	//getValue("LOGIN_USER_ID");
    // Noah登录页密码输入框ID
    public static final String LOGIN_PWD_ID = "password";	//getValue("LOGIN_PWD_ID");
    // Noah登录页登录按钮 class
    public static final String LOGIN_BTN_CL = "submit_btn";
    // Noah用户名1
    public static final String USER = getValue("USER");
    // Noah密码1
    public static final String PWD = getValue("PWD");
    // Noah用户名2
    public static final String USER_ADMIN = getValue("USER_ADMIN");
    // Noah密码2
    public static final String PWD_ADMIN = getValue("PWD_ADMIN");

    
    // Noah登陆后首页的新设备提醒弹框
    public static final String NEWDEVICE_ALERT_XP = "(.//*[normalize-space(text()) and normalize-space(.)='Toggle sidebar'])[1]/preceding::span[1]";
    // Noah首页导航栏ID
    public static final String NAV_ID = getValue("NAV_ID");
    // Noah首页导航栏配置
    public static final String CONF_XP = "/html/body/div[1]/div/div[2]/ul/li[3]/a";	//getValue("CONF_XP");
    // Noah首页导航栏配置--退出登录
    public static final String LOGOUT_XP = "/html/body/div[1]/div/div[2]/ul/li[3]/ul/li[5]/a";	//getValue("LOGOUT_XP");

    

    // 系统管理菜单xpath
    public static final String SYS_MNG_XP = "//*[@id=\"lm1\"]/a";
    // 系统管理--用户管理菜单xpath
    public static final String USER_MNG_XP = "//*[@id=\"z11\"]/a";
    // 用户管理--添加按钮xpath
    public static final String USER_ADD_XP = "//*[@id=\"__tb__01\"]/div[1]/div";
    // 用户管理--添加用户div class
    public static final String USER_ADD_DIV_CL = "idlg-content";
    // 用户管理--添加用户frame tag
    public static final String USER_ADD_FRM_TAG = "iframe";
    // 用户管理--添加用户弹框--用户名称
    public static final String USER_NAME_XP = "//*[@id=\"username\"]";
    // 用户管理--添加用户弹框--密码
    public static final String USER_PWD_XP = "//*[@id=\"password\"]";
    // 用户管理--添加用户弹框--确认密码
    public static final String CONFIRM_PWD_XP = "//*[@id=\"pwd_confirm\"]";
    // 用户管理--添加用户弹框--用户性别
    public static final String MALE_XP = "//*[@id=\"userForm\"]/ul/li[4]/div/div/label[1]/span";
    public static final String FEMALE_XP = "//*[@id=\"userForm\"]/ul/li[4]/div/div/label[2]/span";
    // 用户管理--添加用户弹框--真实姓名
    public static final String TRUE_NAME_XP = "//*[@id=\"name\"]";
    // 用户管理--添加用户弹框--所属部门
    public static final String DEPT_XP = "//*[@id=\"s2id_deptId\"]/a";
//    public static final String DEPT_ID = "s2id_deptId";
    // 用户管理--添加用户弹框--所属部门--下拉列表第一条
    public static final String DEPT_1st_XP = "//*[@id=\"deptId\"]/option[2]";
        //"//*[@id=\"deptId\"]/option[2]";
        // "//*[@id=\"select2-results-1\"]/li[2]";
    // 用户管理--添加用户弹框--所属角色
    public static final String USER_POP_ROLE_XP = "//*[@id=\"s2id_role_id\"]/a";
    // 用户管理--添加用户弹框--所属角色--下拉列表第一条
    public static final String USER_POP_ROLE_1st_XP = "//*[@id=\"role_id\"]/option[2]";
    ////*[@id="select2-results-1"]/li[2]
    //*[@id="role_id"]/option[2]
    // 用户管理--添加用户弹框--手机号
    public static final String USER_MBPH_NUM_XP = "//*[@id=\"phone\"]";
    public static final String USER_MBPH_NUM_ID = "phone";
    // 用户管理--添加用户弹框--Email
    public static final String USER_EMAIL_XP = "//*[@id=\"email\"]";
    public static final String USER_EMAIL_ID = "email";
    // 用户管理--添加用户弹框--备注
    public static final String USER_REMARK_XP = "//*[@id=\"email\"]";
    public static final String USER_REMARK_ID = "remark";


    // 用户管理--添加用户弹框--提交按钮
    public static final String USER_ADD_SBMT_XP = "//*[@id=\"userForm\"]/ul/li[11]/div/button";
    // 用户管理--添加用户弹框--取消按钮
    public static final String USER_ADD_CNCL_XP = "//*[@id=\"userForm\"]/ul/li[11]/div/div";
    // 用户管理--添加用户弹框--提交--确定按钮
    public static final String USER_ADD_CNFM_CL = "idlg-btn";



    // 系统管理--角色管理菜单xpath
    public static final String ROLE_MNG_XP = "//*[@id=\"z12\"]/a";
    // 角色管理--添加按钮xpath
    public static final String ROLE_ADD_XP = "//*[@id=\"__tb__01\"]/div[1]/div";
    // 角色管理--编辑按钮xpath
    public static final String ROLE_MODF_XP = "//*[@id=\"__tb__01\"]/div[2]/div";
    // 角色管理--删除按钮xpath
    public static final String ROLE_DEL_XP = "//*[@id=\"__tb__01\"]/div[3]/div";
    // 角色管理--查询按钮xpath
    public static final String ROLE_QUR_XP = "//*[@id=\"__tb__01\"]/div[4]/div";
    
  
    // 角色管理--添加角色div class
    public static final String ROLE_ADD_DIV_CL = "idlg-content";
    // web element frame tag
    public static final String WEB_ELE_TAG_FRM = "iframe";
    // 角色管理--添加角色弹框--角色名称
    public static final String ROLE_NAME_XP = "//*[@id=\"roleName\"]";
    // 角色管理--添加角色弹框--新增权限checkbox
    public static final String ROLE_ADD_CKBX_ADD_XP = "//*[@id=\"qxDiv\"]/label[1]/span";
    // 角色管理--添加角色弹框--编辑权限checkbox
    public static final String ROLE_ADD_CKBX_MODF_XP = "//*[@id=\"qxDiv\"]/label[2]/span";
    // 角色管理--添加角色弹框--删除权限checkbox
    public static final String ROLE_ADD_CKBX_DEL_XP = "//*[@id=\"qxDiv\"]/label[3]/span";
    // 角色管理--添加角色弹框--系统管理勾选框id
    public static final String ROLE_SYS_MNG_ID = "itree-checkbox-menu_1";
    // 角色管理--添加角色弹框--设备管理勾选框id
    public static final String ROLE_DEV_MNG_ID = "itree-checkbox-menu_2";
    // 角色管理--添加角色弹框--可视化运维勾选框id
    public static final String ROLE_VIS_OPS_ID = "itree-checkbox-menu_3";
    // 角色管理--添加角色弹框--数据报表勾选框id
    public static final String ROLE_DATA_REPO_ID = "itree-checkbox-menu_4";
    // 角色管理--添加角色弹框--扩展业务勾选框id
    public static final String ROLE_EXPA_BUSI_ID = "itree-checkbox-menu_5";
    // 角色管理--添加角色弹框--数据备份勾选框id
    public static final String ROLE_DATA_BAK_ID = "itree-checkbox-menu_6";
    // 角色管理--添加角色弹框--MESH预览勾选框id
    public static final String ROLE_MESH_PREV_ID = "itree-checkbox-menu_7";
    // 角色管理--添加角色弹框--规则引擎勾选框id
    public static final String ROLE_RUL_ENG_ID = "itree-checkbox-menu_8";
    // 角色管理--添加角色弹框--系统工具勾选框id
    public static final String ROLE_SYS_TOOL_ID = "itree-checkbox-menu_9";
    // 角色管理--添加角色弹框--系统日志分析勾选框id
    public static final String ROLE_SYS_LOG_ANAL_ID = "itree-checkbox-menu_10";
    // 角色管理--添加角色弹框--提交xp
    public static final String ROLE_ADD_SBMT_XP = "//*[@id=\"roleForm\"]/div[2]/div[1]";
    // 角色管理--添加角色弹框--提交确认class
    public static final String ROLE_ADD_SBMT_CFM_CL = "idlg-btn";


    // 角色管理--角色查询div class
    public static final String ROLE_QUR_DIV_CL = "idlg-content";
    // 角色管理--角色查询弹框--角色名称id
    public static final String ROLE_QUR_NAME_ID = "roleName";
    // 角色管理--角色查询弹框--确定按钮xp
    public static final String ROLE_QUR_CFM_XP = "//*[@id=\"queryForm\"]/ul/li[2]/div/div[1]";

    
    // 角色管理--角色删除div class
    public static final String ROLE_DEL_DIV_CL = "fui-idialog";
    // 角色管理--角色删除弹框--确定按钮xp
    public static final String ROLE_DEL_CFM_CL = "idlg-btn-focus";
    
    
    // 角色管理--列表字段--第一条checkbox xpath
    public static final String ROLE_LIST_CHKBX_1ST_XP = "//*[@id=\"1\"]/td[1]";
    // 角色管理--列表字段--第一条角色名称xpath
    public static final String ROLE_LIST_NAME_1ST_XP = "//*[@id=\"1\"]/td[2]";
    
//    roleName
  //*[@id="queryForm"]/ul/li[2]/div/div[1]

    public static String getValue(String property) {
    	String value = properties.getProperty(property);
    	return value;
    }

}
