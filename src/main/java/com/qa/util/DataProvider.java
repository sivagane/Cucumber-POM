package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProvider {
	
public static Object[][] getData() throws IOException {
	String name=" ";
	File f= new File("C:\\Users\\sivag\\eclipse-workspace\\CucumberPOM\\src\\main\\java\\com\\qa\\excel\\Siva.xlsx - Shortcut.lnk");
	FileInputStream stream = new FileInputStream(f);
	Workbook w= new XSSFWorkbook(stream);
	Sheet s = w.getSheet("Sheet2");
	Row r = s.getRow(0);
	int rc = s.getPhysicalNumberOfRows();
	int cc = r.getPhysicalNumberOfCells();
	Object[][] ob= new Object[rc][cc];
	int i;
	int j;
	for(i=1;i<rc;i++) {
		Row eachrow= s.getRow(i);
	for(j=0;j<cc;j++) {
		Cell eachcell = r.getCell(j);
		int type = eachcell.getCellType();
		if(type==1) {
			name = eachcell.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(eachcell)) {
				Date d = eachcell.getDateCellValue();
				SimpleDateFormat sim= new SimpleDateFormat("mm-dd-yyyy");
				name = sim.format(d);
			}
			else {
				double bo = eachcell.getNumericCellValue();
				long l= (long)bo;
			    name = String.valueOf(l);
			}
			
		}
		ob[i][j]=name;
	}
}
	return ob;	
}
//@Dataprovider is present in testng. 
public static Object[][] data() throws IOException {
	return getData();
}

}