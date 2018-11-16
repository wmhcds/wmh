package com.itheima.demo;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBConfig {

    @DataProvider(name = "data")
    public Object[][] getData() {
        return new Object[][]{
                {"zhangsan", "lisi",""}
        };
    }
    @Test
    public void json() {
        String str = "192.168.225.255";
        String pattern = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.start());
    }
}
