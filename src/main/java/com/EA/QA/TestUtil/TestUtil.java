package com.EA.QA.TestUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.EA.QA.TestBase.TestBase;

public class TestUtil extends TestBase{

	public TestUtil() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static long implicit_wait=15;
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static String testdatapath="C:\\Users\\User\\eclipse-workspace\\ECNew\\TestFeb1"
			+ "\\src\\main\\java\\com\\EA\\QA\\TestData\\EAData1.xlsx";
	
	public static Object[][] getData(String sheetname) throws Throwable
	{
		FileInputStream filestream=new FileInputStream(testdatapath);
		workbook=new XSSFWorkbook(filestream);
		sheet= workbook.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}
	
	public static void sendkeysExplicitWait(WebElement element, int timeout, String value)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	public static void clickExplicitWait(WebElement element, int timeout)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void takeScreenshotAtEndOfTest() throws Throwable {
		// TODO Auto-generated method stub
		File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File("C:\\Users\\User\\eclipse-workspace\\ECNew"
				+ "\\TestFeb1\\src\\main\\java\\com\\EA\\QA\\Screenshot\\" + "_" + ".jpg"));
	}

}
