package com.cs.ReadPropertyFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static Properties prop = null;
	
	public static Properties readPropertyFile()
	{
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");
			prop  = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("unable to READ config.properties  file");
			
		} catch (IOException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("unable to LOAD config.properties  file");
		}
		return prop;
	}
}
