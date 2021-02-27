package com.EA.QA.TestCase;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.EA.QA.TestBase.TestBase;
import com.EA.QA.pages.HomePage;
import com.EA.QA.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() throws Exception {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		
	}
	
	@Test
	public void loginPageTitleTest()
	{
		loginpage.loginPageTitle();
	}
	
	@Test
	public void logintest() throws Throwable
	{
		
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
