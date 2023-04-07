package actiTimeTestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile 
{
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\PropertyFileActiTime.properties");
		Properties poj = new Properties();
		poj.load(fis);
		return poj.getProperty(key);
	}
}
