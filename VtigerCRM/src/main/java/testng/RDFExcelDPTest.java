package testng;

import org.testng.annotations.Test;

public class RDFExcelDPTest {
	@Test(dataProviderClass=ReadDataFromExcelDPTest.class,dataProvider="readDataFromExcel")
	public void getData(String orgname,String Loc,String Course)
	{
		System.out.println(orgname +"  "+ Loc +" "+Course);
	}


}
