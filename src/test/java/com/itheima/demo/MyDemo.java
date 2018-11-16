package com.itheima.demo;

import java.util.List;
import java.util.Random;

import com.itheima.http.HttpRequest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.bouncycastle.asn1.x500.style.RFC4519Style.l;

public class MyDemo {
    /*
    http测试
     */
	@Test
	public void test() throws InterruptedException {
	}

	/**
	 * 数据驱动
	 * @return 返回数据驱动
	 */
	@DataProvider(name="data")
    public Object[][] getData() {
        return new Object[][]{
                {"zhangsan", "14", "北京"},
                {"zhangsan", "15", "上海"},
                {"zhangsan", "16", "南京"},
                {"zhangsan", "17", "武汉"}
        };
    }
	@Test(dataProvider="data")
    public void dataprovider(String name,String age,String addr){
		System.out.println(name+age+addr);
	}

	@Test
	public void httpTest(){
		HttpRequest.post("https://www.baidu.com")
				.form("username", "zhangsan");
	}
}
