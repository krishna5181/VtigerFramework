package vTiger.GenericUtlities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility 
{
	public String readDataFromPropertyFile(String key) throws IOException 
	{
		FileInputStream fisp = new FileInputStream(IConstantsUtilitity.PropertyFilePath);
		Properties pobj = new Properties();
		pobj.load(fisp);
		String value = pobj.getProperty(key);
		return value;
	}
}
