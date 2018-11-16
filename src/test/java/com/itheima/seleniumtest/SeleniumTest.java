package com.itheima.seleniumtest;

import com.itheima.selenium.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SeleniumTest {
    /**
     * 百度首页UI自动化测试
     */
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(1000);
        WebElement element = driver
                .findElement(By.xpath("//div[@id='TANGRAM__PSP_10__QrcodeMain']/img[@class='tang-pass-qrcode-img']"));
        driver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn")).click();
        Thread.sleep(1000);
        // 输入账号密码
        driver.findElement(
                By.xpath("//input[@autocomplete='off' and @class='pass-text-input pass-text-input-userName']"))
                .sendKeys("18570479964");
//        driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys("18570479964");
        driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys("z363728125");
        ;
        // 点击登录
        driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
        // String src = element.getAttribute("src");
        // System.out.println(src);

        // 关闭浏览器
        Thread.sleep(6000);
        driver.quit();
    }

    @Test
    public void test02() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.hao123.com/");
            driver = SeleniumUtils.setTimout(driver, 30, 10, 10);
            //driver.manage().window().maximize();
            WebDriver lastWebDriver = SeleniumUtils.getLastWebDriver(driver, "易车网", "帕萨特", "贷款");
            //WebDriver webDriver = SeleniumUtils.changeLastWindows(driver);
            System.out.println(lastWebDriver.getTitle());
            System.out.println(lastWebDriver.getCurrentUrl());

            // 关闭浏览器
            Thread.sleep(1000);
            driver.quit();
        }

    }

    @Test
    public void test03() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.hao123.com/");
            driver = SeleniumUtils.setTimout(driver, 30, 10, 10);
            List<WebElement> elements = driver.findElements(By.xpath("//a[text()='易车网']"));
            if (elements.size() > 0) {
                elements.get(0).click();
            }
            System.out.println(elements.size());
            System.out.println("感觉这个键盘也太小了把~~~");
            Thread.sleep(2000);
            driver.quit();
        }

    }

    @Test
    public void test04() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.hao123.com/");
            driver = SeleniumUtils.setTimout(driver, 30, 10, 10);
            List<WebElement> elements = driver.findElements(By.xpath("//a[text()='易车网']"));
            new Select(elements.get(0));
            System.out.println(elements.size());
            Thread.sleep(2000);
            driver.quit();

    }

    @Test
    public void test05() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hao123.com/");
        //隐式等待
        driver = SeleniumUtils.setTimout(driver, 30, 10, 10);
        SeleniumUtils.getLastWebDriver(driver,"百度","hao123");
        Thread.sleep(3000);
        driver.quit();

    }
}
