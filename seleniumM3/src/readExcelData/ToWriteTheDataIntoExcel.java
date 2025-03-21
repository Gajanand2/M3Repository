package readExcelData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToWriteTheDataIntoExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// To specify the path of the file
		FileInputStream fis = new FileInputStream("./testData/testdata.xlsx");

		// To make the file ready to read
		Workbook wb = WorkbookFactory.create(fis);

		// To go to the desired sheet
		Sheet sheet = wb.getSheet("ipl");

		Row row = sheet.getRow(2);// To get into the row
		Row row1 = sheet.createRow(10);
		Cell cell = row.createCell(2);// To create a new column
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("PK");
		cell.setCellValue("PUNE");// To set the value of a column

		FileOutputStream fos = new FileOutputStream("./testData/testdata.xlsx");
		wb.write(fos);// To write the data in excel sheet
	}
}