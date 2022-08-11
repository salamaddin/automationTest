package lib;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XL {
	String filePath = null;
	FileInputStream fis=null;
	XSSFWorkbook wb =null;
	XSSFSheet sheet=null;
	int sheetCount = 0;
	HashMap<String,Integer> colIndexes;

	public XL(String filePath) {
		this.filePath = filePath;
		colIndexes = new HashMap<String,Integer>();

		try {
			fis = new FileInputStream(filePath);
			wb = new XSSFWorkbook(fis);
			getSheetCount();
		} catch (Exception io) {
			io.printStackTrace();
		}
	}

	public int getSheetCount() {
		sheetCount = wb.getNumberOfSheets();
		return sheetCount;
	}
	
	public String getFirstSheet() {
		return wb.getSheetName(0);
	}
	
	public void openSheet(String sheetName) {
		sheet = wb.getSheet(sheetName);
		loadColNames();
	}
	
	public int getSheetRowCount() {
		int rowCount = sheet.getLastRowNum();
		return rowCount;
	}
	
	public String getCellData(int rowNumber, int cellNumber) {
		Row currRow = sheet.getRow(rowNumber);
		Cell currCell = currRow.getCell(cellNumber);
		String cellData = "";
		CellType type = currCell.getCellType();
		
		if (type.equals(CellType.STRING)) {
			cellData = currCell.getRichStringCellValue().toString();
		} else if (type.equals(CellType.NUMERIC)) {
			int cellvalue = (int) currCell.getNumericCellValue();
			cellData = cellvalue + "";
		}


		return cellData;
	}
	
	public String getCellData(int rowNumber, String colName) {
		int colNumber = colIndexes.get(colName);
		return getCellData(rowNumber,colNumber);
	}
	public void loadColNames() {
		Row rowZero = sheet.getRow(0);
		int colCount = rowZero.getLastCellNum();
		
		for (int i = 0; i < colCount; i++) {
			String colName = getCellData(0,i);
			colIndexes.put(colName, i);
		}
	}
	
	public void close() {
		try {
			if(wb!=null) {
				wb.close();
			}
		}catch(Exception io) {
			io.printStackTrace();
		}
	}

}
