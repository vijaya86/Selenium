package com.demo.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readPropertyFile {
	public static String[][] readXL(String filepath) throws FileNotFoundException {
		String xData[][] = null;
		int xRows,xCols;
		String cellValue;
		DataFormatter dataformater=new DataFormatter();
		File myxl=new File(filepath);
		FileInputStream file= new FileInputStream(myxl);
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet ws=wb.getSheetAt(0);
		xRows=ws.getLastRowNum()+1;
		xCols=ws.getRow(0).getLastCellNum();
		xData=new String[xRows][xCols];
		System.out.println(xRows);
		System.out.println(xCols);
		for(int i=0;i<xRows;i++) {
			XSSFRow row=ws.getRow(i);
			for(int j=0;j<xCols;j++) {
				cellValue="";
				cellValue=dataformater.formatCellValue(row.getCell(j));
				if(cellValue !=null) {
					cellValue=xData[i][j];
					
				}
				
			}
				
				
			
		}
		
				
	
		return xData;
		
	}

	public static void main(String[] args) throws Exception {
		
		readXL("C:\\Users\\karne\\Desktop\\FileWriter\\Excel.xlsx");
		
		
		
		
	}

}
