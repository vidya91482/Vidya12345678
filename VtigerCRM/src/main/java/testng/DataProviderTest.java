package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj = new Object[3][3];
		obj[0][0]="Qspider";
		obj[0][1]="Banglore";
		obj[0][2]="Automation";
		
		obj[1][0]="Qspider";
		obj[1][1]="Mysore";	
		obj[1][2]="Java";
		
		
		obj[2][0]="Prospider";
		obj[2][1]="Hyd";
		obj[2][2]="Python";
		return obj;
		
	}
	
	@Test(dataProvider="data")
	public void getdata(String orgname,String loc,String course)
	{
		System.out.println("organisation is "+orgname+"location is"+loc+"course is"+course);
		
	}

	


	
	

	
	

}
