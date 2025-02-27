package com.advancedjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {

	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
				Statement stmt = con.createStatement()){
			
			stmt.addBatch("insert into account values(1,'Darshan','Sonawane',1200000)");
			stmt.addBatch("insert into account values(1,'Divyesh','Sonawane',1300000)");
			
			int[] result = stmt.executeBatch();
			
			for(int i:result) {
				System.out.println(i);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
