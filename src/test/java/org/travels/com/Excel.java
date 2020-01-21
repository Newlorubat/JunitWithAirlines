package org.travels.com;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Excel {

	public static String demo(int rowno, int cellno) throws Throwable {
		String v = null;
		File loc = new File("C:\\Users\\RUBAN\\eclipse-workspace\\Maven\\Folder\\Book2.xlsx");
		FileInputStream Stream = new FileInputStream(loc);
		Workbook book = new XSSFWorkbook(Stream);
		Sheet sheet = book.getSheet("PassengerList");
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		int type = cell.getCellType();
		if (type == 1) {
			v = cell.getStringCellValue();
		}

		else if (type == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd-mm-yy");
				v = sim.format(dateCellValue);
			}

			else {
				double numericCellValue = cell.getNumericCellValue();
				long i = (long) numericCellValue;
				v = String.valueOf(i);

			}
		}
		return v;
	}

	public static void dropDown(WebElement e, String value){
		
		Select s = new Select(e);
		s.selectByValue(value);
	}
}
