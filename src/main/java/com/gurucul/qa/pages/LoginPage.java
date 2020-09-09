package com.gurucul.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gurucul.qa.base.TestBase;
import com.gurucul.qa.util.testUtil;

public class LoginPage extends TestBase{
	
	
	//object repository or page factory
	
@FindBy(name="txtUsername")
WebElement username;

@FindBy(name="txtPassword")
WebElement password;

@FindBy(name="submit1")
WebElement loginBtn;


@FindBy(xpath="//*[text()='Invalid Username/password']")
WebElement validationText;

public LoginPage(){
	
	PageFactory.initElements(driver, this);
}


public String validatePageTitle(){
	return driver.getTitle();
}

public String validatePageLogo(){
	return driver.getTitle();
}


public HomePage loginWithCred(String uname,String pwd){
	
	username.sendKeys(uname);
	password.sendKeys(pwd);
	loginBtn.click();
	driver.manage().timeouts().pageLoadTimeout(testUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	
	return new HomePage();
}


public String getFieldValidation(){
loginBtn.click();
driver.manage().timeouts().pageLoadTimeout(testUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
String validationMsg =validationText.getText();
return validationMsg;
}


}
