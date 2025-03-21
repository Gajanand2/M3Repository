package readExcelData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToGetTheNumberOfRows {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		   //To specify the path of the file
			FileInputStream fis = new FileInputStream("./testData/testdata.xlsx");
		    
			//To make the file ready to read
		    Workbook wb = WorkbookFactory.create(fis);
		    
		    //To go to the desired sheet
		   Sheet sheet = wb.getSheet("ipl");
		  
		   int rc=sheet.getLastRowNum();//To count the no. of rows
		   System.out.println(rc);
}
}