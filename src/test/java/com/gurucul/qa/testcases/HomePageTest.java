package com.gurucul.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gurucul.qa.base.TestBase;
import com.gurucul.qa.pages.HomePage;
import com.gurucul.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	
	public HomePageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void setup(){
		TestBase.initalization();
		loginPage=new LoginPage();
		homepage=loginPage.loginWithCred(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}
	
	/*@Test
	public void loginPageTitle(){
		String title=loginPage.validatePageTitle();
		Assert.assertEquals(title, "Cteh soft");
	}*/
	
	
	@Test
	public void homeTest(){
		homepage.addPromise("Sonali test");
		homepage.verifyPromise("Sonali test");
	}
	
	
	@AfterMethod
	public void close(){
		driver.quit();
	}

}
