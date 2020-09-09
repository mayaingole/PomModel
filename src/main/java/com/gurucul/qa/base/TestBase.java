package com.gurucul.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gurucul.qa.util.testUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		
		prop=new Properties();
		//String location=System.getProperty("user.dir");
		//File file=new File(location+"/PomByMaya/src/main/java/com/gurucul/qa/config/config.properties");
		try {
			FileInputStream fis=new FileInputStream("E:/Maya_stuff/PomByMaya/src/main/java/com/gurucul/qa/config/config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initalization(){
		String browserName=prop.getProperty("browser");
		System.out.println("browserName --> "+browserName);
		if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Sachin/Downloads/chromedriver_win32/chromedriver.exe");	
		driver=new ChromeDriver();
		
		}else if(browserName.equals("Mozilla")){
			System.setProperty("WebDriver.gecko.driver", "D:/chromedriver.exe");	
			driver=new FirefoxDriver();
			
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(testUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
	
}
