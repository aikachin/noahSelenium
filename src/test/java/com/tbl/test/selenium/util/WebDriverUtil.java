package com.tbl.test.selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Auther: Aikachin
 * @Date: 2019/3/11 21:35
 * @Description: 判断元素是否存在，是否显示，是否隐藏
 * @Modified by {who Time}
 */
public class WebDriverUtil {

//    WebDriver webDriver;
//
//    public WebDriverUtil(WebDriver webDriver) {
//        this.webDriver = webDriver;
//    }

    /**
     * 判断元素是否在指定时间内存在。
     * 只要元素出现在dom结构中（不管属性是显示还是隐藏） 马上返回true
     * 在指定时间仍不存在与dom结构则返回false。
     * 适用于ajax
     *
     * @param by 元素
     * @param seconds 指定秒数
     * @return 出现返回true 否则返回false
     */
    public static boolean waitForElementPresence(WebDriver webDriver, final By by, int seconds) {
        try {
            new WebDriverWait(webDriver, seconds).until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断元素在指定时间是否显示
     * 元素是否在指定时间内显示（存在dom结构且属性为显示）马上返回true
     * 如果到指定时间仍未显示（不存在与dom结构 或者存在于dom结构但属性为‘隐藏’）则返回false
     * 适用于ajax
     *
     * @param by 元素
     * @param seconds 指定秒数
     * @return 出现返回true 否则返回false
     */
    public static boolean waitForElementVisible(WebDriver webDriver, final By by, int seconds) {
//        try {
            new WebDriverWait(webDriver, seconds).until(ExpectedConditions.visibilityOfElementLocated(by));

            return true;
//        } catch (Exception e) {
//            return false;
//        }
    }

    /**
     * 判断元素是否在指定时间内隐藏或者消失
     * 如果元素消失(不存在于dom结构 或者属性为 ‘隐藏’)则立刻返回true
     * 如果指定时间后元素仍然存在（存在于dom结构且属性为‘显示’）则返回false
     *
     * @param by 元素
     * @param seconds 秒数
     * @return
     */
    public static boolean waitForElementInvisible(WebDriver webDriver, final By by, int seconds) {
        try {
            new WebDriverWait(webDriver, seconds).until(ExpectedConditions.invisibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
//---------------------
//    作者：c_sen
//    来源：CSDN
//    原文：https://blog.csdn.net/xian312854159/article/details/43703551
//    版权声明：本文为博主原创文章，转载请附上博文链接！
}
