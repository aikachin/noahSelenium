package com.tbl.test.api;

import com.jayway.jsonpath.JsonPath;
import com.tbl.test.selenium.util.BaseUtils;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TestRfidAPI extends BaseUtils {

    private static String rooturl = null;

    @BeforeMethod
    public void setUp() {
        BasicConfigurator.configure(); //自动快速地使用缺省Log4j环境。

        // 设置默认工厂类
        System.setProperty("org.apache.commons.logging.LogFactory", "org.apache.commons.logging.impl.LogFactoryImpl");
        // 设置日志打印类
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        //设置默认日志级别_error,关闭debug日志输出
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.simplelog.defaultlog", "error");
    }

    @AfterMethod
    public void tearDown() {
    }



    // 四通道读写器数据取得
    @Test
    public void testRfidFreader() {
        HttpResponse<String> response = Unirest.post("http://192.168.1.57:8081/noah_web/data/rfid/freader")
                .header("Content-Type", "application/json")
                .body("{}")
                .asString();

        String result = response.getBody();
//        int code = JsonPath.read(result, "$.code");
//        Assert.assertEquals(code, 200);
        checkRfidDataResults(result);
    }


    // 一体式读写器数据取得
    @Test
    public void testRfidIreader() {
        HttpResponse<String> response = Unirest.post("http://192.168.1.57:8081/noah_web/data/rfid/ireader")
                .header("Content-Type", "application/json")
                .body("{}")
                .asString();

        String result = response.getBody();
//        int code = JsonPath.read(result, "$.code");
//        Assert.assertEquals(code, 200);
        checkRfidDataResults(result);
    }


    // 回收箱读写器数据取得
    @Test
    public void testRfidRecybox() {
        HttpResponse<String> response = Unirest.post("http://192.168.1.57:8081/noah_web/data/rfid/recybox")
                .header("Content-Type", "application/json")
                .body("{}")
                .asString();

        String result = response.getBody();
        checkRfidDataResults(result);
//        Assert.assertEquals(code, 200);

    }


    // 塔灯控制
    @Test
    public void testRfidReaderCtrl() {
        String rooturl = "http://localhost:8080/noah_web/";
        HttpResponse<String> response = Unirest.post("http://192.168.1.57:8081/noah_web/operation/rfid/doout/192.168.11.23/1/1/1")
//                .header("Content-Type", "application/json")
                .body("{}")
                .asString();

        String result = response.getBody();
        print(result);
        if ("false".equals(result)) {
            Assert.assertEquals(response.getBody().toString(), "false");
        } else {
            Assert.assertEquals(response.getBody().toString(), "true");
        }
    }


    // 塔灯控制
    @Test
    public void testDooutCtrl() {
        String rooturl = "http://localhost:8080/noah_web/";
        HttpResponse<String> response = Unirest.post("http://192.168.1.57:8081/noah_web/operation/rfid/doout/192.168.11.23/1/1/1")
//                .header("Content-Type", "application/json")
                .body("{}")
                .asString();

        String result = response.getBody();
        print(result);
        if ("false".equals(result)) {
            Assert.assertEquals(response.getBody().toString(), "false");
        } else {
            Assert.assertEquals(response.getBody().toString(), "true");
        }
    }



    /**
     * 验证rfid读取数据接口的返回值
     * @param result 访问接口后的响应体（String型json串）
     */
    public static void checkRfidDataResults(String result) {
        print(result);
        List<Map> results = new ArrayList<>();
        int code = JsonPath.read(result, "$.code");
        // 设置接口返回code校验，200表示访问成功
        Assert.assertEquals(code, 200);

        results = JsonPath.read(result, "$.result");
//        if (!isNotNull(results)) {
//            Assert.assertEquals(results.size(), 0);
//        }

        if (!isNotNull(results)) {
            // 如果没有数据，则大小为0
            print(results);
            Assert.assertEquals(results.size(), 0);
        } else {
            print(results);
            print(results.get(0));
            Map map = results.get(0);
            print(map);
            String data = JsonPath.read(results.get(0), "$.data");
            String add_time = JsonPath.read(results.get(0), "$.add_time");
            String ip = JsonPath.read(results.get(0), "$.ip");
            String name = JsonPath.read(results.get(0), "$.name");
            Assert.assertEquals(isNotNull(data), true);
            Assert.assertEquals(isNotNull(add_time), true);
            Assert.assertEquals(isNotNull(ip), true);
            Assert.assertEquals(isNotNull(name), true);
        }
    }



}