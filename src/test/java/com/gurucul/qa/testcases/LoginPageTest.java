package com.gurucul.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gurucul.qa.base.TestBase;
import com.gurucul.qa.pages.HomePage;
import com.gurucul.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void setup(){
		TestBase.initalization();
		loginPage=new LoginPage();
		
		
	}
	
	/*@Test
	public void loginPageTitle(){
		String title=loginPage.validatePageTitle();
		Assert.assertEquals(title, "Cteh soft");
	}*/
	
	
	@Test
	public void loginTest(){
		loginPage.loginWithCred(prop.getProperty("username"),prop.getProperty("password"));
		String homeTile=HomePage.getHomePageTitle();
		Assert.assertEquals(homeTile,"Promises Log","User Logged in with valid Username and password");
	}
	
	@Test
	public void blankValidation(){
		
		Assert.assertEquals(loginPage.getFieldValidation(),"Invalid Username/password","Validation message showing for empaty username and passwod");
	}
	
	
	@AfterMethod
	public void close(){
		driver.quit();
	}

}
