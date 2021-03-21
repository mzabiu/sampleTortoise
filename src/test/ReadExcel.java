package test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;

	private FileInputStream fis;

	private String excelPath, sheetName;

	public ReadExcel(String excelPath, String sheetName) {
		this.excelPath = excelPath;
		this.sheetName = sheetName;
	}

	/**
	 * this method will read the excel data and return the data for
	 * dataparameterization
	 * 
	 * @author Zabi
	 * @param path
	 * @param sheetName
	 * @return
	 */

	public Object[][] excelData() {

		Object[][] data = null;

		try {
			fis = new FileInputStream(this.excelPath);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(this.sheetName);

			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

			System.out.println("Row count " + rowCount + " col coutn is " + colCount);

			data = new Object[rowCount][colCount];
			for (int excelRow = 1; excelRow < rowCount; excelRow++) {
				for (int excelCol = 0; excelCol < sheet.getRow(excelRow).getPhysicalNumberOfCells(); excelCol++) {
					data[excelRow][excelCol] = getCellValue(excelRow, excelCol);
					System.out.println("The value is " + data[excelRow][excelCol]);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	private Object getCellValue(int excelRow, int excelCol) {
		row = sheet.getRow(excelRow); // Jabesh, Password
		return row.getCell(excelCol).getStringCellValue();
	}

	public static void main(String[] args) {
		ReadExcel excel = new ReadExcel("./TestData.xlsx", "Data");

		excel.excelData();
	}

}
