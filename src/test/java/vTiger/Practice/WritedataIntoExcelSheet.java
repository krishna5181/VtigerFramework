package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritedataIntoExcelSheet 
{
	public static void main(String[] args) throws IOException 
	{
		//Step1: Load file into FileInputStream - java readable format
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step2: Create a Workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3: Navigate to required Sheet
		Sheet sh = wb.getSheet("Organization");
		
		//Step4: Navigate to required Row
		Row r1 = sh.getRow(4);
		
		//Step5: Navigate to required Cell
		 Cell c1 = r1.createCell(5);
		 
		//Step6: SetCellValue into the cell c1
		 c1.setCellValue("Hyundai creta");
		 
		//Step7: Write into the file using FileOutputStream
		 FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		 wb.write(fos);
		 System.out.println("Data is creadted into ExcelSheet");
	}

}
