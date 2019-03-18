package com.tbl.test.selenium.base;

/**
 * @Auther: Aikachin
 * @Date: 2018/11/9 13:58
 * @Description: 记录常量：主要包括Noah页面元素
 * @Modified by: Aikachin 2019/1/2
 */
public class constantsOfNoah {

    // Chrome driver路径
    public static final String CHROME_DRIVER = "f:/software/webdriver/chromedriver.exe";

    // Noah首页
//    public static final String URL_OF_NOAH = "http://localhost:18080/noah_web";
    public static final String URL_OF_NOAH = "http://192.168.1.57:8081/noah_web";
    // mainFrame（页面右侧主内容区）
    public static final String MAIN_FRM_ID = "mainFrame";

    // Noah登录页用户名输入框ID
    public static final String LOGIN_USER_ID = "loginname";
    // Noah登录页密码输入框ID
    public static final String LOGIN_PWD_ID = "password";
    // Noah登录页登录按钮 class
    public static final String LOGIN_BTN_CL = "submit_btn";
    // Noah用户名1
    public static final String USER = "noah";
    // Noah密码1
    public static final String PWD = "123456";
    // Noah用户名2
    public static final String USER_ADMIN = "admin";
    // Noah密码2
    public static final String PWD_ADMIN = "sonriku";

    // Noah首页导航栏ID
    public static final String NAV_ID = "navbar";
    // Noah首页导航栏配置
    public static final String CONF_XP = "/html/body/div[1]/div/div[2]/ul/li[3]/a";
    // Noah首页导航栏配置--退出登录
    public static final String LOGOUT_XP = "/html/body/div[1]/div/div[2]/ul/li[3]/ul/li[5]/a";



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
    // 角色管理--添加角色div class
    public static final String ROLE_ADD_DIV_CL = "idlg-content";
    // 角色管理--添加角色frame tag
    public static final String ROLE_ADD_FRM_TAG = "iframe";
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










}
