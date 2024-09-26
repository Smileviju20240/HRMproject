package utlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtlities {

	FileInputStream excel_File;
	FileOutputStream writing_In_Sheet;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
	XSSFRow rows;
	XSSFCell cell;
	String path;
	
	File xl_File;

	public ExcelUtlities(String path) {
		this.path = path;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		
		excel_File = new FileInputStream(path);
		workBook = new XSSFWorkbook(excel_File);
		sheet = workBook.getSheet(sheetName);
		int number_Of_Rows = sheet.getLastRowNum();
		workBook.close();
		excel_File.close();
		return number_Of_Rows;

	}

	public int getCellCount(String sheetName, int row_Num) throws IOException {

		excel_File = new FileInputStream(path);
		workBook = new XSSFWorkbook(excel_File);
		sheet = workBook.getSheet(sheetName);
		rows = sheet.getRow(row_Num);
		int number_Of_Columns = rows.getLastCellNum();
		workBook.close();
		excel_File.close();
		return number_Of_Columns;
		
	}

	public String getCellData(String sheetName, int row_Num, int column_Num) throws IOException {

		excel_File = new FileInputStream(path);
		workBook = new XSSFWorkbook(excel_File);
		sheet = workBook.getSheet(sheetName);
		rows = sheet.getRow(row_Num);
		cell = rows.getCell(column_Num);

		String cell_Data;
		DataFormatter formater = new DataFormatter();
		try {
			cell_Data = formater.formatCellValue(cell);
		} catch (Exception e) {
			cell_Data = "";
		}
		workBook.close();
		excel_File.close();
		return cell_Data;
	}
	/*
	private void setCellData(String sheetName, int row_Num, int column_Num, String cell_Data) throws IOException {

		xl_File = new File(path);
		if(!xl_File.exists()) {
			workBook = new XSSFWorkbook(excel_File);
			writing_In_Sheet = new FileOutputStream(path);
			workBook.write(writing_In_Sheet);
		}
		
		if(workBook.getSheetIndex(sheetName)==-1)
			workBook.createSheet(sheetName);
		
		sheet = workBook.getSheet(sheetName);
		
		if(sheet.getRow(row_Num)==null)
			sheet.createRow(row_Num);
		
		rows = sheet.getRow(row_Num);
		cell = rows.createCell(column_Num);
		cell.setCellValue(cell_Data);
		writing_In_Sheet = new FileOutputStream(path);
		workBook.close();
		excel_File.close();
		writing_In_Sheet.close();

	}
	*/
}
