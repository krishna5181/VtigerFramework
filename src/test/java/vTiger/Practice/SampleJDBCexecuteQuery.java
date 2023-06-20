package vTiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;


public class SampleJDBCexecuteQuery 
{
	@Test
	public void sampleJDBC() throws SQLException 
	{
		Driver driverRef = new Driver();
		
		//Step1: Register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step2: get the connection with drive ---->database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcsm23db", "root", "msn@5181");
		
		//Step3: Issue the create statement
		Statement state = con.createStatement();
		
		//Step4: Execute the query
		ResultSet result = state.executeQuery("select * from candidateinfo order by id;");
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
		}
		
		//Step5: Close the database
		con.close();
		System.out.println("datababse closed successfully");
		
		
	}

}
