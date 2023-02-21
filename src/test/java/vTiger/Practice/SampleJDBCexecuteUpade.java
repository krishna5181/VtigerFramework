package vTiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCexecuteUpade 
{
	@Test
	public void sampleUpdate() throws SQLException
	{
		Driver driverRef = new Driver();
		
		//Step1: Register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step2: Get the connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcsm23db", "root", "msn@5181");
		
		//Step3: Issue the create Statement
		Statement stmt = con.createStatement();
		
		//Step4: Execute the query
		String query = "insert into candidateinfo values('Chaitra', 1, 'Karnataka')";
		int result = stmt.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("data added successfully");
		}
		stmt.executeUpdate("insert into candidateinfo values('Dhishan', 2, 'Delhi');");
		
		ResultSet data = stmt.executeQuery("select * from candidateinfo;");
		while(data.next())
		{
			System.out.println(data.getString(1)+"-------->"+data.getInt(2)+"-------->"+data.getString(3));
		}
		
		//Step5: Close the database
		con.close();
		
		System.out.println("Database closed successfully");
	}

}
