package com.tbl.test.api;

import com.jayway.jsonpath.JsonPath;
import com.tbl.test.selenium.base.BasePage;
import com.tbl.test.selenium.util.BaseUtils;
import com.tbl.test.selenium.util.JsonFormatUtil;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.JsonPatch;
import kong.unirest.Unirest;
import okhttp3.*;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.tbl.test.selenium.util.BaseUtils.print;


public class ApiTest extends BasePage {
    public static void main(String[] args) {
        BasicConfigurator.configure(); //自动快速地使用缺省Log4j环境。
        // 设置默认工厂类
        System.setProperty("org.apache.commons.logging.LogFactory", "org.apache.commons.logging.impl.LogFactoryImpl");
        // 设置日志打印类
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        //设置默认日志级别_error,关闭debug日志输出
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.simplelog.defaultlog", "error");
//        ---------------------
//                作者：寻梦的叶子
//        来源：CSDN
//        原文：https://blog.csdn.net/woyou6people/article/details/87856828
//        版权声明：本文为博主原创文章，转载请附上博文链接！
//        try {
//            apiTestOkHttpClient();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        apiTestUnirest();

        List<String> list = null;
        List<String> list2 = new ArrayList<>();

//        print(isNotNull(list));
//        print(isNotNull(list2));

        getProjectPath();
    }


    /**
     * test by OkHttpClient
     * @throws IOException
     */
    public static void apiTestOkHttpClient() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{}");
        Request request = new Request.Builder()
                .url("http://192.168.1.57:8081/noah_web/data/rfid/ireader")
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        print(response.body().string());

    }


    public static void apiTestUnirest() throws IOException {
        String rootUrl = "";
        rootUrl = (String) BaseUtils.getValue("URL_OF_NOAH");   // 取得基础url

        List<String> urls = new ArrayList<>();
        StringBuilder url = new StringBuilder("/data/rfid/");
        urls.add(rootUrl + url + "ireader");
        urls.add(rootUrl + url + "freader");
        urls.add(rootUrl + url + "recybox");
        for (int i = 0; i < urls.size(); i++) {

            HttpResponse<String> response = Unirest.post(urls.get(i))
                    .header("Content-Type", "application/json")
    //                .header("User-Agent", "PostmanRuntime/7.15.0")
    //                .header("Accept", "*/*")
    //                .header("Cache-Control", "no-cache")
    //                .header("Postman-Token", "386593b2-6095-40a5-81b3-57f0a309be83,789d92a3-4720-49d2-915f-aa3d897141f4")
    //                .header("Host", "192.168.1.57:8081")
    //                .header("cookie", "JSESSIONID=61C5D8912BFD2FAE9032BE4F43DD021E")
    //                .header("accept-encoding", "gzip, deflate")
    //                .header("content-length", "2")
    //                .header("Connection", "keep-alive")
    //                .header("cache-control", "no-cache")
                    .body("{}")
                    .asString();

            String jsonStr = response.getBody();
            analyseJson(urls.get(i), jsonStr);
        }
    }

    public static void analyseJson(String url, String jsonStr) {
        print(url + "的返回值为\n" + jsonStr + "\n下面开始对下列接口的响应体（body json串）进行解析：\n");
        print("Json format Body______ \n" + JsonFormatUtil.JsonFormart(jsonStr) + "\n");

//        List<String> result = JsonPath.read(jsonStr, "$.result");
//        print("接口响应体body中的result为：\n\t" + result);
        int code = JsonPath.read(jsonStr, "$.code");
//        print("接口响应体body中code：\n\t" + code);
        Assert.assertEquals(code, 200);
    }

    public static void getProjectPath() {
        File file = new File("");
        String rootPath = null;
        try {
            rootPath = file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        print(rootPath);
    }
}
