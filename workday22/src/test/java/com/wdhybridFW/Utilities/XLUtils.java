package com.wdhybridFW.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static void setExcelfile(String xlfile, String xlsheet) throws Exception
	{
		try {
			FileInputStream ExcelFile = new FileInputStream(xlfile);
			wb= new XSSFWorkbook(ExcelFile);
			ws = wb.getSheet(xlsheet);
			
		}catch(Exception e) {
			throw(e);
		}
		
	}
	
	public static int getRowCount(String xlfile,String xlsheet) throws Exception
	{
		fis = new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}
	
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws Exception
	{
		fis = new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellcount; 
	}
	
	public static String getCellData(String path, String xlsheet, int rownum, int cellnum) throws Exception
	{
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlsheet);
		cell = ws.getRow(rownum).getCell(cellnum);
		DataFormatter  formatter = new DataFormatter();
		String celldata = formatter.formatCellValue(cell);
		return celldata;
		
	}

}
