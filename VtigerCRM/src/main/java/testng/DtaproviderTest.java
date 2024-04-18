package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DtaproviderTest {
	@DataProvider
	public Object[][] logindata()
	{
		Object[][] obj = new Object[2][2];
		obj[0][0]="admin";
		obj[0][1]="admin";
		
		obj[1][0]="admin";
		obj[1][1]="admin";
         return obj;

}
}
