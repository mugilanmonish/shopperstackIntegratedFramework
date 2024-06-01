package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
//	Connection con = null;
//	public void connectToDB() throws SQLException {
//		Driver driver = new Driver();
//		DriverManager.registerDriver(driver);
//		con = DriverManager.getConnection(IPathConstant.DbUrl,IPathConstant.DbUsername,IPathConstant.DbPassword);
//
//	}
//
//	public void executeAndGetData(String query, int colIndex, String expData) throws SQLException {
//		Statement state = con.createStatement();
//		ResultSet result = state.executeQuery(query);
//		boolean flag = false;
//		while (result.next()) {
//			String actual = result.getString(colIndex);
//			if(actual.contains(expData)) {
//				flag = true;
//				break;
//			}
//		}
//		if(flag==true)
//			System.out.println("---DATA IS VERIFIED---");
//		else
//			System.out.println("---DATA IS NOT PRESENT");
//	}
//
//	public void closeDb() throws SQLException {
//		con.close();
//	}
}