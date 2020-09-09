package com.gurucul.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.gurucul.qa.base.TestBase;
import com.gurucul.qa.util.testUtil;

public class HomePage extends TestBase{
	
	
	@FindBy(linkText="Log Promise")
	WebElement logLink;
	
	
	@FindBy(name="cboEmp")
	WebElement selectList;
	
	@FindBy(id="txtPromise")
	WebElement promiseText;
	
	@FindBy(name="btnSubmit")
	WebElement addBtn;
	
	@FindBy(name="btnSearch")
	WebElement searchBtn;
	
	@FindBy(name="txtStartDate")
	WebElement startDate;
	
	@FindBy(name="txtEndDate")
	WebElement endDate;
	
	@FindBy(xpath="//*[text()='Sonali test added by maya for test done']/preceding-sibling::td[text()='Sonali test']")
	WebElement promiseTextUI;
	

	public HomePage(){
		
		PageFactory.initElements(driver, this);
	}


	public static String getHomePageTitle(){
		String homepageTitle=driver.getTitle();
		System.out.println("homepageTitle >> "+homepageTitle);
		
		return homepageTitle;
	}


public void addPromise(String promiseName){
	logLink.click();
	selectPromise(promiseName);
	promiseText.sendKeys(promiseName+" added by maya for test done");
	addBtn.click();
}

public void selectPromise(String selectValue){
	
	Select sel = new Select(selectList);
	sel.selectByVisibleText(selectValue);
	

}


public void selectDate(String selectValue){
	
	Select sel = new Select(selectList);
	sel.selectByVisibleText(selectValue);
	

}

public void verifyPromise(String inputPromise){
	selectPromise(inputPromise);
	startDate.sendKeys("09-09-2020");
	endDate.sendKeys("09-09-2020");
	searchBtn.click();
	driver.manage().timeouts().pageLoadTimeout(testUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	String addedText=promiseTextUI.getText();
	System.out.println("addedText >> "+addedText);
	Assert.assertEquals(addedText,inputPromise,"Added promise verifed : "+inputPromise+" ");
}

}
