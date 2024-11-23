package Scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class L01DataSet {

	String filePath = "E:\\CapstoneLiveProject\\OrangeHrmProject\\TestData\\Data.xlsx";
	XSSFWorkbook wb;
	XSSFSheet sheet;

	@DataProvider(name = "Data")
	public Object[][] getLoginData() throws IOException {
		initializeSheet();

		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalCells = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[totalRows - 1][totalCells];

		for (int i = 0; i < totalRows - 1; i++) {
			XSSFRow row = sheet.getRow(i + 1); 
			if (row != null) { 
				for (int j = 0; j < totalCells; j++) {
					if (row.getCell(j) != null) { 
						switch (row.getCell(j).getCellType()) {
						case STRING:
							data[i][j] = row.getCell(j).getStringCellValue();
							break;
						case NUMERIC:
							data[i][j] = row.getCell(j).getNumericCellValue();
							break;
						default:
							data[i][j] = ""; 
						}
					} else {
						data[i][j] = ""; 
					}
				}
			} else {
				for (int j = 0; j < totalCells; j++) {
					data[i][j] = ""; 
				}
			}
		}
		return data;
	}

	private void initializeSheet() throws IOException {
		if (sheet == null) { 
			// Ensure sheet is only initialized once
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet("userdata");
			fis.close();
		}
	}
}

