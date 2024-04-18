package genericUtilities;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {
	Connection con=null;
	
	public void connectToDB() throws SQLException
	{
		Driver driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstant.DBURL, IPathConstant.DBUsername, IPathConstant.DBPassword);
	}
	public void executeAndgetData(String query, int colIndex, String expData) throws SQLException
	{
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			String actual=result.getString(colIndex);
			if(actual.contains(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("--data is verified");
			
			
		}
		else {
			System.out.println("data is not present");
		}
			
		}
	public void closeDB() throws SQLException
	{
		con.close();
	}
	}

