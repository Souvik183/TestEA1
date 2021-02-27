package com.EA.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EA.QA.TestBase.TestBase;
import com.EA.QA.TestUtil.TestUtil;

public class HomePage extends TestBase {
	
	@FindBy(name="FirstName")
	
	WebElement firstname;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement savebtn; 
	
	@FindBy(name="Initial")
	WebElement initial;

	public HomePage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public void firstnameInsert(String first)
	{
		TestUtil.sendkeysExplicitWait(firstname, 10, first);
	}
	
	public void initialCheck(String ini)
	{
		TestUtil.sendkeysExplicitWait(initial, 10, ini);
	}
	
	public void savebtnClick()
	{
		TestUtil.clickExplicitWait(savebtn, 5);
	}

}
