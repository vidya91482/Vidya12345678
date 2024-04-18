package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		String value =sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		wb.close();
		return value;
		
	}



public void writeDataIntoExcel(String sheetName, int rowNo, int cellNo, String data) throws EncryptedDocumentException, IOException
{
	FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
	Workbook wb=WorkbookFactory.create(fi);

	Sheet sh = wb.getSheet(sheetName);
	sh.getRow(rowNo).getCell(cellNo).setCellValue(data);
	FileOutputStream fout=new FileOutputStream(IPathConstant.ExcelPath);
	wb.write(fout);
	wb.close();

	
}

public int getTotalRowCount(String sheetName) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int rowCount=sh.getLastRowNum();
	return rowCount;
	
}

public HashMap<String, String> readMultipleData(String sheetName, int cellNo) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int rowCount=sh.getLastRowNum();
	HashMap<String, String>map=new HashMap<String, String>();
	for(int i=0;i<=rowCount;i++) {
		String key = sh.getRow(i).getCell(cellNo).getStringCellValue();
		String value = sh.getRow(i).getCell(cellNo+1).getStringCellValue();
		map.put(key, value);
	}
	return map;
}
}
