package com.EA.QA.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.EA.QA.TestBase.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="UserName")
	WebElement username;
	
	@FindBy(name="Password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	

	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public void loginPageTitle()
	{
		soft=new SoftAssert();
		String actualpageTitle=driver.getTitle();
		String expectedPageTitle="EA Automation1";
		soft.assertEquals(actualpageTitle, expectedPageTitle);
		soft.assertAll();
	}
	
	
	public HomePage login(String un, String pw) throws Throwable
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		loginbtn.click();
		return new HomePage();
	}

}
