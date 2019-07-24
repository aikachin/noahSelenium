package com.tbl.test.selenium.test;

import com.tbl.test.selenium.base.StepModel;
import static com.tbl.test.selenium.util.BaseUtils.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest2 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest2( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest2.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public static void main(String args[]) {
//    	testF();
    	print(File.separator);
    	String value = "test+random(1000)";
    	print(getRandomNum(value));

    	print(File.separator);
//    	test2();
    }
    
    
    /**
     * 获取随机名或数字
     * @param value 原始参数，格式可以是：【test+random(1000)】；random(1000)
     * @return 返回带有随机数的字符串
     */
    public static String getRandomNum(String value) {
    	String retValue = null;
    	if (value.contains("random(")) {
    		print("【value】包含 ‘random(’");
    		int randomNum = 0;
    		int index = value.indexOf("random(") + 7;
    		try {
	    		int range = Integer.parseInt(value.substring(index, value.length() - 1));
	    		randomNum = (int) (Math.random()*range/10*9 + range/10);
	        	print(randomNum);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}

        	if (!value.startsWith("random")) {
//        		int type = 1;	// 1: 带前缀字符串，比如test+random(1000)
       			retValue = value.substring(0, value.indexOf("random(") - 1) + String.valueOf(randomNum);
           	} else {
           		retValue = String.valueOf(randomNum);
           	}
    	} else {
    		print("【value】不符合格式！因为它不包含‘random’");
    	}
    	return retValue;
    }
    
    
    public static void testF() {

    	print("\n开始执行testF()...");
//        System.err.println("未找到元素, type: " +   ", value: " );
//    	StepModel step = new StepModel();
//    	step.setAction("refresh");
//    	print(step.getAction());
    	StepModel stepModel = new StepModel();
    	String action = stepModel.getAction();
    	if ("click".equals(action)) {
    		print(123);
    	} else {
    		printErr("ng");
    	}
    	try {
	    	if (action.equals("click")) {
	    		print(321);
	    	}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	try {
    		print(action.isEmpty());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	print(isNotNull(action));
    	
    	
    	if (isNull(stepModel.getValue())) {
    		stepModel.setValue("-1");
    	}
    	// String 转 int
    	int i = Integer.parseInt(stepModel.getValue());
    	if (1 == i) {
    		print("ok");
    	} else {
    		printErr("ng");
    	}
    	
    	print("\ntestF()执行结束");
    	
    }
    
    public static void test2() {
    	  Date d = new Date();
      	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      	  String formatD = sdf.format(d);
//      	  print("formatD : " + formatD);
      	  // 取得年月日yyyyMMdd格式日期
      	  String date = formatD.substring(0, 10).replaceAll("-", "");
//      	  print("date : " + date);
      	  // 取得时分HHmm格式时间（24小时制）
      	  String time = formatD.substring(11,17).replaceAll(":", "");
//      	  print("time : " + time);
      	  
      	  String backDir = "E:/backupSql/";
      	  File file = new File(backDir);
      	  if (!file.exists()) {
      		  file.mkdirs();
      	  }
      	  
      	  // 设置mysql数据库保存的sql脚本文件名称
      	  String savePath = backDir + "backup-" + date + time + ".sql";
//      	  print("savePath : " + savePath);
    }
    
    
    /**
     * 备份数据库
     * @throws Exception
     */
    public static void backUp(StepModel stepModel) throws Exception {
    	
    	String object = stepModel.getObject();
    	if ("backupData".equals(object)) {
    		Runtime rt = Runtime.getRuntime();
        	Process pro = rt.exec(getCommand(stepModel));
        	BufferedReader br = new BufferedReader(new InputStreamReader(pro.getErrorStream()));
        	String errorLine = null;
        	while ((errorLine = br.readLine()) != null) {
        		print(errorLine);
        	}
        	br.close();
        	int result = pro.waitFor();
        	if (result != 0) {
        		throw new Exception("数据库备份失败！");
        	}
    	}
    	
    }
    
    
    /**
     * 获取MySQL备份的命令
     * @param StepModel 测试步骤
     * @return
     */
    private static String[] getCommand(StepModel stepModel) {

    	// 获取需要备份的表名
    	String tables = stepModel.getValue();
//    	String[] tables = value.split(" ");
    	// 获取备份目录
    	String backupDir = stepModel.getExpectation();
    	File file = new File(backupDir);
    	if (!file.exists()) {	// 如果目录不存在
    		file.mkdirs();	// 创建目录
    	}
    	if (!backupDir.endsWith(File.separator)) {	// 如果备份目录不包括“/”，则添加“/”
    		backupDir = backupDir + File.separator;
    	}
    	String[] cmd = new String[3];
    	String time = new SimpleDateFormat("yyMMddHHmm").format(new Date().toString());
    	// 获取操作系统名称
    	String os = System.getProperties().getProperty("os.name");
    	print(os);
    	if (os.startsWith("Win")) {
    		// 如果操作系统是Windows，使用cmd.exe程序执行命令
    		cmd[0] = "cmd.exe";
    		cmd[1] = "/c";
    	} else {
    		// 如果操作系统是Linux，使用shell程序执行命令
    		cmd[0] = "/bin/bash";
    		cmd[1] = "-c";
    	}
    	StringBuilder arg = new StringBuilder();
    	// 拼接mysqldump备份数据库的命令，注意空格" "
    	arg.append("mysqldump ");
    	// 服务器地址-h
    	String[] serverConn = stepModel.getElement().split(",");	// 获取服务器地址，服务器地址信息包括IP，账号，密码，和数据库名，
    																// 格式为：[192.168.1.64,root,123456,noah_v4.2]
    	arg.append("-h" + serverConn[0] + " ");
    	// 端口号-P，默认3306
    	arg.append("-P3306 ");
    	// 账号-u
    	arg.append("-u" + serverConn[1] + " ");
    	// 密码-p
    	arg.append("-p" + serverConn[2] + " ");
    	// 指定字符集--default-character=
    	arg.append("--default-character=utf8 ");
    	// 禁用将结果存入内存，否则大表会出现问题
    	arg.append("--skip-opt ");
    	// 在CREATE DATABASE之前加 drop语句
    	arg.append("--add-drop-database ");
    	// 禁用将结果存入内存，否则大表会出现问题；禁用--opt选项
    	arg.append("--skip-opt ");
    	// 转储数据库中的函数和程序，同-R
    	arg.append("--routines ");
    	// 导出触发器。该选项默认启用
    	arg.append("--triggers ");
    	// 压缩传输的信息
    	arg.append("--compress ");
    	// 指定需要导出的数据库名称，可以空格隔开
    	arg.append("-B ");
    	arg.append(serverConn[3] + " ");
    	
    	// 当表内容非空时，导出指定表
    	if (isNotNull(tables)) {
        	// 覆盖--databases (-B)参数，指定需要导出的表名
        	arg.append("--tables ");
        	arg.append(tables + " ");
        	// 设置备份路径
        	arg.append("-r");
        	arg.append(backupDir);
        	arg.append(tables  + "_");
        	arg.append(time);
        	arg.append(".sql");
        	
        // 否则，导出数据库
    	} else {
	    	// 设置备份路径
	    	arg.append("-r");
	    	arg.append(backupDir);
	    	arg.append(serverConn[3] + "_");
	    	arg.append(time);
	    	arg.append(".sql");
    	}
    	
    	return cmd;
    }
}
