package readExcelData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleData2 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {	
	FileInputStream fis = new FileInputStream("./testData/testdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("ipl");
	int row = sheet.getPhysicalNumberOfRows();
	int cell = sheet.getRow(1).getPhysicalNumberOfCells();
	String[][] iplArr = new String[row][cell];
	for (int i = 0; i <row; i++) {
		for (int j = 0; j <cell; j++) {
			iplArr[i][j]=sheet.getRow(i).getCell(j).toString();
			
		}
	}
	for (String[] arr2 : iplArr) {
		for (String data : arr2) {
			System.out.print(data+" ");
		}
		System.out.println();
	}
	
}
}