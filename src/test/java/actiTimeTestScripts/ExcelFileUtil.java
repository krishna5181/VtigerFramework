package actiTimeTestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import vTiger.GenericUtlities.IConstantsUtilitity;

public class ExcelFileUtil 
{
	public String ReadDataFromExcelSheet(String SheetName, int rowNo, int cellNO) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(IConstantsUtilitity.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		String value = sh.getRow(rowNo).getCell(cellNO).getStringCellValue();
		return value;
		
	}
	
	

}
