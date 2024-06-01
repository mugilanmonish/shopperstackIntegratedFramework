package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

//	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws Throwable {
//		FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
//		Workbook wb = WorkbookFactory.create(fi);
//		Sheet sh = wb.getSheet(sheetName);
//		Row r = sh.getRow(rowNo);
//		Cell c = r.getCell(cellNo);
//		DataFormatter format = new DataFormatter();
//		String value = format.formatCellValue(c);
//		return value;
//		String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
//		return value;
	}
//	public int getTotalRowCount(String sheetName) throws Throwable {
//		FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
//		Workbook wb = WorkbookFactory.create(fi);
//		Sheet sh = wb.getSheet(sheetName);
//		int rowCount = sh.getLastRowNum();
//		return rowCount;
//	}

//	public void writeDataIntoExcel(String sheetName,int rowNo, int cellNo, String data) throws Throwable {
//		FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
//		Workbook wb = WorkbookFactory.create(fi);
//		Sheet sh = wb.getSheet(sheetName);
//		sh.createRow(rowNo).createCell(cellNo).setCellValue(data);
//		FileOutputStream fOut = new FileOutputStream(IPathConstant.ExcelPath);
//		wb.write(fOut);
//		wb.close();
//	}
	
//	public Map<String, String> readMultipleData(String sheetName,int cellNo) throws Throwable {
//		FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
//		Workbook wb = WorkbookFactory.create(fi);
//		Sheet sh = wb.getSheet(sheetName);
//		int rowCount = sh.getLastRowNum();
//		
//		Map<String, String> map = new HashMap<>();
//		for (int i = 0; i <= rowCount; i++) {
//			String key = sh.getRow(i).getCell(cellNo).getStringCellValue();
//			String value = sh.getRow(i).getCell(cellNo+1).getStringCellValue();
//			map.put(key, value);
//		}
//		return map;
//	}
	
//}