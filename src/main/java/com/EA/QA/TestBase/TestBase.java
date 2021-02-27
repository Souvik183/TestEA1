package com.EA.QA.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.EA.QA.TestUtil.TestUtil;
import com.EA.QA.TestUtil.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static SoftAssert soft;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistner;
	
	public TestBase() throws Exception
	{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\ECNew\\TestFeb1"
				+ "\\src\\main\\java\\com\\EA\\QA\\config\\config.properties");
		prop.load(ip);
	}
	
	public static void initialization() throws Throwable
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		e_driver= new EventFiringWebDriver(driver);
		eventlistner=new WebEventListener();
		e_driver.register(eventlistner);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
