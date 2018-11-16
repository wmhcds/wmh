package com.itheima.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class MyAppium {
	public void appiumInfo() throws MalformedURLException {
		/*
		 	查看当前设备名字
		 	adb dervers
			查看当前app的包名和activity名
			adb shell dumpsys window w |findstr \/ |findstr name=
		*/
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//deviceName：启动哪种设备，是真机还是模拟器？iPhone Simulator，iPad Simulator，iPhone Retina 4-inch，Android Emulator，Galaxy S4…
		capabilities.setCapability("deviceName", "93119519");
		//automationName：使用哪种自动化引擎。appium（默认）还是Selendroid。
		capabilities.setCapability("automationName", "Appium");
		//platformName：使用哪种移动平台。iOS, Android, orFirefoxOS。
		capabilities.setCapability("platformName", "Android");
		//版本号
		capabilities.setCapability("platformVersion", "8.0.0");
		//软件的包名
		capabilities.setCapability("appPackage", "com.miui.calculator");
		//appActivity：软件的appActivity名
		capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		//appium service服务器地址
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		//获取当前页面元素
		driver.findElementById("com.miui.calculator:id/btn_1_s").click();
		driver.quit();
		}
}
