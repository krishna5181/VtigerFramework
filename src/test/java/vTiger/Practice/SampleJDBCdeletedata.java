package vTiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCdeletedata 
{
	@Test
	public void deletedata() throws SQLException 
	{
		Driver ref = new Driver();
		
		DriverManager.registerDriver(ref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcsm23db", "root", "msn@5181");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("delete from candidateinfo where name='Chaitra' limit 1;");
		con.close();
	}
}
