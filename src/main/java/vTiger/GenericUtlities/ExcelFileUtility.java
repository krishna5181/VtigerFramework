package vTiger.GenericUtlities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of Generic methods related to Excel Sheet
 * @author balar
 *
 */

public class ExcelFileUtility {
	
	/**
	 * This method will read data from Excel sheet and return the value
	 * @param Sheet
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExelSheet(String Sheet,int rowNo, int cellNo) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(IConstantsUtilitity.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet);
		Row rw = sh.getRow(rowNo);
		Cell ce = rw.getCell(cellNo);
		String value = ce.getStringCellValue();
		wb.close();
		return value;
	}
	
	/**
	 * This method will provide the row count when the specific sheet is provided
	 * @param Sheet
	 * @return
	 * @throws IOException
	 */
	public int getRowCount(String Sheet) throws IOException 
	{
		FileInputStream fis = new FileInputStream(IConstantsUtilitity.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet);
		int rowcount = sh.getLastRowNum();
		return rowcount;
	}
	
	/**
	 * This method will write data into ExcelSheet
	 * @param Sheet
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String Sheet, int rowNo, int cellNo, String value) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(IConstantsUtilitity.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet);
		Row rw = sh.getRow(rowNo);
		Cell ce = rw.createCell(cellNo);
		ce.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantsUtilitity.ExcelFilePath);
		wb.write(fos);
		wb.close();
	}
	/**
	 * This method will read multiple data from excel sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(IConstantsUtilitity.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0; j<lastCell; j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue(); 
			}
		}
		return data;
		
	}

}
