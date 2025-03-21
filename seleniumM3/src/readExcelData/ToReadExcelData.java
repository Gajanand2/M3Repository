package readExcelData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
   //To specify the path of the file
	FileInputStream fis = new FileInputStream("./testData/testdata.xlsx");
    
	//To make the file ready to read
    Workbook wb = WorkbookFactory.create(fis);
    
    //To go to the desired sheet
   Sheet sheet = wb.getSheet("ipl");
   
   //To go to the desired row
    Row row = sheet.getRow(4);
  
    //To go to the desired cell / column
    Cell cell = row.getCell(1);
  
    //To read the data from desired cell / column
    String data = cell.getStringCellValue();
    
    System.out.println(data);
	}

}
