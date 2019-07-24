package com.tbl.test.selenium.test;

import static com.tbl.test.selenium.util.BaseUtils.print;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestByMysqlDrive {
  //@Test
  public void f() {
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @Test(dataProvider="mysql_data")
  public void testMysql(String str1, String str2, String str3, String str4) {
	  print("str1: " + str1);
	  print("str2: " + str2);
	  print("str3: " + str3);
	  print("str4: " + str4 +  "\n");
  }
  
  @DataProvider(name="mysql_data")
  public Object[][] getData() {
	  return getDataByMysql("testdata");
	  
  }

  
  /**
   * @discription 从MySQL中取得数据
   * @param tableName	表名
   * @return
   */
  private Object[][] getDataByMysql(String tableName) {
	  // 声明MySQL数据库驱动
	  String mysqlDrive = "com.mysql.jdbc.Driver";
	  // 配置数据库的IP地址，端口，数据库名称，账号，密码等
	  String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/test";
	  String user = "root";
	  String pwd = "123456";
	  
	  List<Object[]> records = new ArrayList<Object[]>();
	  
	  try {
		  // 设定驱动
		  Class.forName(mysqlDrive);
		  // 声明连接数据库的链接对象，使用数据库服务器的地址，用户名和密码作为参数
		  Connection conn = DriverManager.getConnection(mysqlUrl, user, pwd);
		  if (!conn.isClosed()) {
			  print("MySQL数据库连接成功");
		  }
		  
		  // 创建StateMent对象
		  Statement sm = conn.createStatement();
		  // 使用函数参数拼接要执行的sql语句，此语句用来获取数据表的所有数据行
		  String sql = "select * from " + tableName;
		  
		  // 声明ResultSet对象，存取执行sql语句后返回的数据结果集
		  ResultSet rs = sm.executeQuery(sql);
		  // 声明一个ResultSetMetaData对象
		  ResultSetMetaData rsMetaData = rs.getMetaData();
		  // 获取数据行的列数
		  int cols = rsMetaData.getColumnCount();
		  
		  // 使用next方法遍历数据结果集中的所有数据行
		  while (rs.next()) {
			  String data[] = new String[cols];
			  for (int i = 0; i < cols; i++) {
				  // 取得每一行的数据
				  data[i] = rs.getString(i + 1);
			  }
			  // 将每行数据加入records中
			  records.add(data);
		  }
		  // 关闭数据库连接
		  rs.close();
		  conn.close();
		  
	  } catch (ClassNotFoundException e) {
		  e.printStackTrace();
	  } catch (SQLException e) {
		  e.printStackTrace();
	  }
	  
	  Object[][] results = new Object[records.size()][];
	  // 将list转为二维数组
	  for (int i = 0; i < records.size(); i++) {
		  results[i] = records.get(i);
	  }
	  return results;
  }
}
