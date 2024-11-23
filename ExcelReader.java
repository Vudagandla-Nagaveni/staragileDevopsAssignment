package Scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {

	@Test
	public void dataRead() throws IOException {

		// Define the file path
		String filePath =System.getProperty("user.dir")+"\\TestData\\Data.xlsx";

		// Initialize FileInputStream and Workbook objects
		FileInputStream fis = new FileInputStream(new File(filePath));
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Access the sheet by name
		XSSFSheet sheet = wb.getSheet("userdata");

		// Get the number of rows and cells in the sheet
		int rows = sheet.getPhysicalNumberOfRows(); // Total rows
		int cells = sheet.getRow(0).getPhysicalNumberOfCells(); // Total columns


		//Array of same size like file
		Object data[][]=new Object[rows-1][cells];

		for (int i = 0; i < rows; i++) { // Start from 0 to include the first row
		    if (sheet.getRow(i) != null) { 
		        // Check if the row is not null
		        for (int j = 0; j < cells; j++) {
		            if (sheet.getRow(i).getCell(j) != null) { 
		                // Check if the cell is not null
		                data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
		                System.out.print(data[i][j] + " ");
		            } else {
		                data[i][j] = ""; 
		                // Handle empty cells
		                System.out.print("EMPTY ");
		            }
		        }
		    }
		    System.out.println(); 
		    // Move to the next line after each row
		}

		// Close resources
		wb.close();
		fis.close();
	}
}


