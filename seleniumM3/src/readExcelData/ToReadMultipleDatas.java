package readExcelData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadMultipleDatas {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis1 = new FileInputStream("./testData/testdata.xlsx");		
		Workbook wb1 = WorkbookFactory.create(fis1);		
		Sheet sheet1 = wb1.getSheet("ipl");
    	int rc = sheet1.getLastRowNum();
		
		for (int i = 1; i <= rc; i++) {
			FileInputStream fis = new FileInputStream("./testData/testdata.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("ipl");
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(1);
			String data = cell.getStringCellValue();
			System.out.println(data);
			Thread.sleep(500);
		}
	}

}
