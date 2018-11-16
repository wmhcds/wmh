package com.itheima.selenium;

import org.apache.commons.lang.StringUtils;
import org.mockito.internal.matchers.Null;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 根据linkTest选择器，选择到元素，然后定位元素的src，实现元素多个链接连续跳转
 */
public class SeleniumUtils {
    /**
     * 设置selenium超时时间
     *
     * @param driver           驱动
     * @param pageLoadTimeout  页面加载超时时间
     * @param implicitlyWait   识别对象时的超时时间
     * @param setScriptTimeout 异步脚本的超时时间
     */
    public static WebDriver setTimout(WebDriver driver, Integer pageLoadTimeout, Integer implicitlyWait, Integer setScriptTimeout) {
        if (pageLoadTimeout != null) {
            driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        }
        if (implicitlyWait != null) {
            driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        }
        if (setScriptTimeout != null) {
            driver.manage().timeouts().setScriptTimeout(setScriptTimeout, TimeUnit.SECONDS);
        }
        return driver;
    }

    /**
     * @param driver 浏览器对象
     * @param text   标签的文本内容
     * @return 返回最后一个页面对象
     */
    public static WebDriver getLastWebDriver(WebDriver driver, String... text) {

        List<WebElement> elements = null;
        try {
            Thread.sleep(500);
            for (String s : text) {
                elements = driver.findElements(By.xpath("//*[text()='" + s + "']"));
                int size = elements.size();
                if (size == 1) {
                    //移动到页面最底部
                    // ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                    driver.manage().window().maximize();
                    //移动到元素element对象的“底端”与当前窗口的“底部”对齐
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", elements.get(0));
                    //使用JS点击
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click()", elements.get(0));
                    //切换到最后一个窗口
                    driver = changeLastWindows(driver);
                } else {
                    System.out.println("页面中出现多个相同的文本，或文本元素不存在");
                    return null;
                }
            }
        } catch (Exception e) {
            System.out.println("异常了");
            e.printStackTrace();
            return null;
        }
        return driver;
    }

    /**
     * 切换到最后一个打开的窗口
     *
     * @param driver
     * @return
     */
    public static WebDriver changeLastWindows(WebDriver driver) {
        //获得所有的窗口
        Set<String> handles = driver.getWindowHandles();
        //将所有窗口的ID放入数组中
        Object[] array = handles.toArray();
        //System.out.println(Arrays.toString(array));
        //切换到最后一个窗口
        int lastIndex = array.length - 1;
        driver.switchTo().window(array[lastIndex].toString());
        return driver;
    }
}