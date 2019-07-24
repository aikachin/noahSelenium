package com.tbl.test.selenium.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.tbl.test.selenium.util.BaseUtils.*;

public class ExcuteCase {

    // 公共用例（比如登陆操作等）
    static List<CaseModel> publicCaseList;

    static String recoverSql = "";
    static StepModel step;

    /**
    * 执行case的主要方法
     * 
     * @param caseModel
     * @return
     */
    public static Object[] excuteCase(CaseModel caseModel) {
        for (int i = 0; i < caseModel.getStepModels().size(); i++) {
            StepModel stepModel = caseModel.getStepModels().get(i);
            String object = stepModel.getObject();
            if (isNotNull(stepModel.getPrecondition())) {
                for (CaseModel caseModel2 : publicCaseList) {
                    if (stepModel.getPrecondition().equals(caseModel2.getCaseName())) {
                        excuteCase(caseModel2);
                    }
                }
            }

            if ("driver".equals(object)) {
                // 如果是driver，则执行浏览器驱动动作
                DriverOperation.action(stepModel);
            } else if ("element".equals(object)) {
                // 如果是element，则执行测试用例的元素操作
                WebElementOperation.elementAction(stepModel);
            } else if ("elementAvailable".equals(object)) {
                int retCode = WebElementOperation.ifElementAvailable(stepModel);
                if (1 == retCode) {
                    // 1:如果不存在元素，则执行excel case中接下来的一行内容（视情况而定）
                    continue;
                } else if (0 == retCode) {
                    // 0:如果存在元素，则跳过excel case中接下来的一行内容（视情况而定）
                    i++;
                } else {
                    // -1:异常返回，终止测试
                    printErr("WebElementOperation.ifElementAvailable(StepModel stepModels) 发生异常, 返回-1!");
                }
            } else if ("sleep".equals(object)) {
                try {
                    sleep(Integer.parseInt(stepModel.getValue()));
                } catch (NumberFormatException e) {
                    print("caseName：" + caseModel.getCaseName());
                    print("step:" + stepModel.getStep());
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    print("caseName：" + caseModel.getCaseName());
                    print("step:" + stepModel.getStep());
                    e.printStackTrace();
                }
                // 如果类型是"backupData"，则开始备份数据库
            } else if ("backupData".equals(object)) {
                try {
                    backupMysql(stepModel);
                } catch (Exception e) {
                    print("caseName：" + caseModel.getCaseName());
                    print("step:" + stepModel.getStep());
                    e.printStackTrace();
                }

                // 如果类型是"recoverData"，则开始还原上面备份的数据库
            } else if ("recoverData".equals(object)) {
                try {
                    recoverMysql(stepModel);
                } catch (Exception e) {
                    print("caseName：" + caseModel.getCaseName());
                    print("step:" + stepModel.getStep());
                    e.printStackTrace();
                }
            }

        }
        return null;

    }

    /**
     * 数据库备份
     * 
     * @param stepModel 测试步骤stepModel中记录需要备份的数据库服务器信息，数据库和表对象，以及sql脚本存放目录
     * @throws Exception
     */
    public static void backupMysql(StepModel stepModel) throws Exception {
        Runtime rt = Runtime.getRuntime();
        Process pro = rt.exec(getBackupCommand(stepModel));
        BufferedReader br = new BufferedReader(new InputStreamReader(pro.getErrorStream()));
        String errorLine = null;
        while ((errorLine = br.readLine()) != null) {
            print(errorLine);
        }
        br.close();
        int result = pro.waitFor();
        if (result != 0) {
//			print("caseName：" + caseModel.getCaseName());
            print("step:" + stepModel.getStep());
            throw new Exception("数据库备份失败！");
        }
        // 保留数据库备份信息，方便在还原时可以获取到
        step = stepModel;
    }

    /**
     * 数据库还原
     * 
     * @throws Exception
     */
    public static void recoverMysql(StepModel stepModel) throws Exception {
        Runtime rt = Runtime.getRuntime();
        Process pro = rt.exec(getRecoverCommand(stepModel));
        BufferedReader br = new BufferedReader(new InputStreamReader(pro.getErrorStream()));
        String errorLine = null;
        while ((errorLine = br.readLine()) != null) {
            print(errorLine);
        }
        br.close();
        int result = pro.waitFor();
        if (result != 0) {
//			print("caseName：" + caseModel.getCaseName());
            print("step:" + stepModel.getStep());
            throw new Exception("数据库还原失败！");
        }
    }

    /**
     * 获取MySQL备份的命令
     * 
     * @param StepModel 测试步骤
     * @return
     */
    private static String[] getBackupCommand(StepModel stepModel) {
        // 获取需要备份的表名
        String tables = stepModel.getValue();
//		String[] tables = value.split(" ");
        // 获取备份目录，例如：E:\\backupDir
        String backupDir = stepModel.getExpectation();
        File file = new File(backupDir);
        if (!file.exists()) { // 如果目录不存在
            file.mkdirs(); // 创建目录
        }
        if (!backupDir.endsWith(File.separator)) { // 如果备份目录不包括“/”，则添加“/”
            backupDir = backupDir + File.separator;
        }
        String[] cmd = new String[3];
        String time = new SimpleDateFormat("yyMMddHHmm").format(new Date()).toString();
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
        String[] serverConn = stepModel.getElement().split(","); // 获取数据库服务器信息，包括IP，账号，密码，和数据库名。全部写在element中，“,”隔开
                                                                 // eg：192.168.1.64,root,123456,noah_v4.2
        arg.append("-h" + serverConn[0] + " ");
        // 端口号-P，默认3306
        arg.append("-P3306 ");
        // 账号-u
        arg.append("-u" + serverConn[1] + " ");
        // 密码-p
        arg.append("-p" + serverConn[2] + " ");
        // 指定字符集--default-character-set=
        arg.append("--default-character-set=utf8 ");

        // 指定需要导出的数据库名称，可以空格隔开
        arg.append("-B ");
        arg.append(serverConn[3] + " ");

        // 当表内容非空时，导出指定表——可以导出多个表到同一sql脚本中，table间默认是用“,”隔开的
        if (isNotNull(tables)) {
            // 覆盖--databases (-B)参数，指定需要导出的表名
            arg.append("--tables ");
            tables = tables.replaceAll(",", " "); // 将多个table之间的“,”用空格隔开，用作导出命令间的table间隔
            arg.append(tables + " ");
            // 设置备份路径
            arg.append("-r");
            arg.append(backupDir);
            tables = tables.replaceAll(" ", "+"); // 将多个table之间的空格用“&”隔开，用作保存的sql文件名
            arg.append(tables + "_");
            arg.append(time);
            arg.append(".sql");
            recoverSql = backupDir + tables + "_" + time + ".sql";

            // 否则，导出数据库——暂时只支持导出单个数据库
        } else {

            // 禁用将结果存入内存，否则大表会出现问题
            arg.append("--skip-opt ");
            // 在CREATE DATABASE之前加 drop语句
            arg.append("--add-drop-database ");
            // 禁用将结果存入内存，否则大表会出现问题；禁用--opt选项
            arg.append("--skip-opt ");
            // 转储数据库中的函数和程序，同-R
            arg.append("--routines ");
            // 导出触发器。该选项默认启用
//			arg.append("--triggers ");
            // 压缩传输的信息
//			arg.append("--compress ");
            // 指定需要导出的数据库名称，可以空格隔开
//			arg.append("-B ");
//			arg.append(serverConn[3] + " ");
            // 设置备份路径
            arg.append("-r");
            arg.append(backupDir);
            arg.append(serverConn[3] + "_");
            arg.append(time);
            arg.append(".sql");

            recoverSql = backupDir + serverConn[3] + "_" + time + ".sql";
            print(recoverSql);
        }
        cmd[2] = arg.toString();
        for (String str : cmd) {
            print(str);
        }
        return cmd;
    }

    /**
     * 获取MySQL恢复的命令
     * 
     * @param StepModel 测试步骤
     * @return
     */
    public static String[] getRecoverCommand(StepModel stepModel) {
        //
        String[] cmd = new String[3];
        String os = System.getProperties().getProperty("os.name");
        if (os.startsWith("Win")) {
            cmd[0] = "cmd";
            cmd[1] = "/c";
        } else {
            cmd[0] = "/bin/bash";
            cmd[1] = "-c";
        }
        StringBuilder arg = new StringBuilder();

        arg.append("mysql ");
        // 服务器地址-h
        String[] serverConn = stepModel.getElement().split(","); // 获取数据库服务器信息，包括IP，账号，密码，和数据库名。全部写在element中，“,”隔开
                                                                 // eg：192.168.1.64,root,123456,noah_v4.2
        arg.append("-h" + serverConn[0] + " ");
        // 端口号-P，默认3306
        arg.append("-P3306 ");
        // 账号-u
        arg.append("-u" + serverConn[1] + " ");
        // 密码-p
        arg.append("-p" + serverConn[2] + " ");
        // 目标数据库名称
        arg.append(serverConn[3] + " ");
        arg.append("< ");
        arg.append(recoverSql);
        cmd[2] = arg.toString();
        for (String str : cmd) {
            print(str);
        }
        return cmd;
    }
    
    

    /**
     * @return the publicCaseList
     */
    public static List<CaseModel> getPublicCaseList() {
        return publicCaseList;
    }

    /**
     * @param publicCaseList the publicCaseList to set
     */
    public static void setPublicCaseList(List<CaseModel> publicCaseList) {
        ExcuteCase.publicCaseList = publicCaseList;
    }
}
