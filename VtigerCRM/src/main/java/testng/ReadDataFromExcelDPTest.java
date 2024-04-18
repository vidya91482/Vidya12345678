package testng;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.IPathConstant;

public class ReadDataFromExcelDPTest {
	@DataProvider(name="readDataFromExcel")
	public Object[][]orgdata() throws EncryptedDocumentException, IOException{
		FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("DPOR");
		int rowCount=sh.getLastRowNum()+1;
		int cellCount=sh.getRow(0).getLastCellNum();
		
		Object[][]obj=new Object[rowCount][cellCount];
		for(int i=0;i< rowCount;i++ )
		{
			for(int j=0;j<cellCount;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
	}
		return obj;
	
	

}
}
