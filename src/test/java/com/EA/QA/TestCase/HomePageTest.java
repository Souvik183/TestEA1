package com.EA.QA.TestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.EA.QA.TestBase.TestBase;
import com.EA.QA.TestUtil.TestUtil;
import com.EA.QA.pages.HomePage;
import com.EA.QA.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	String sheetname="Cred";

	public HomePageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setup() throws Throwable
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@DataProvider
	public Object[][] getTestData() throws Throwable
	{
		Object[][] data = TestUtil.getData(sheetname);
		return data;
	}
	
	@Test(dataProvider = "getTestData")
	public void firstnameInsertTest(String firstnam, String initial)               
	{
		homepage.firstnameInsert(firstnam);
		homepage.initialCheck(initial);
		homepage.savebtnClick();
	}
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}


}
