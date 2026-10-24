package com.tests;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cs.Driver.Driver;
import com.cs.ReadPropertyFile.ReadPropertyFile;


public class BaseTest {
 
	public Properties prop;
	
	@BeforeSuite
	public void suiteMethod()
	{
		prop = ReadPropertyFile.readPropertyFile();
	}
	
	
	@BeforeMethod
	public void tearUp()
	{
		Driver.initDriver();
	}
	
	@AfterMethod
	public void tearDown()
	{
		Driver.quitBrowser();
	}
}
