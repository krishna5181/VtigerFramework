package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataDFromExcelSheet 
{
	public static void main(String[] args) throws IOException {
		
	//Step1: Load the file into the FileInputStream - java readable format
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	
	//Step2: Craete Workbook
	Workbook wb = WorkbookFactory.create(fis);
	
	//Step3: Navigate to required sheet
	Sheet sh = wb.getSheet("Organization");
	
	//Step4: Navigate to required row
	Row rw = sh.getRow(1);
	
	//Step5: Navigate to required cell
	Cell ce = rw.getCell(2);
	Cell ce1 = rw.getCell(1);
	
	//Step6: Capture the date present inside the cell
	String value = ce.getStringCellValue();
	System.out.println(value);
	System.out.println(ce1.getStringCellValue());
//	System.out.println(sh.getRow(7).getCell(3));  
	
	}
}
