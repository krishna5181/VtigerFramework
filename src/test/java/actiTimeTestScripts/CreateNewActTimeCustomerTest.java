package actiTimeTestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vTiger.GenericUtlities.ExcelFileUtility;


public class CreateNewActTimeCustomerTest extends BaseClassActiTime
{	
	@Test(dataProvider = "allcustomers")
	public void createCustomer(String CustomerName, String Description) throws EncryptedDocumentException, IOException  
	{
//		ExcelFileUtil eUtil = new ExcelFileUtil();
//		String CustomerName = eUtil.ReadDataFromExcelSheet("CustomerDetails", 1, 0);
//		String Description = eUtil.ReadDataFromExcelSheet("CustomerDetails", 1, 1);
		
		ActiTimeElements act = new ActiTimeElements(driver);
		act.createCustomer(CustomerName, Description);		
	}

	@DataProvider(name = "allcustomers")
	public Object[][] createMultCust() throws EncryptedDocumentException, IOException
	{
		ExcelFileUtility EUTIL = new ExcelFileUtility();
	    Object[][] allcustomers = EUTIL.readMultipleData("CustomerDetails");
		return allcustomers;
	}
}
