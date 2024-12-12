package com.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TansactionDAO {

	public static void main(String[] args) {
		Connection con = null;
		try{
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
			Statement stmt = con.createStatement();
			con.setAutoCommit(false);
			stmt.executeUpdate("update account set bal=bal-500 where id=1");
			stmt.executeUpdate("update account set bal=bal+500 where id=2");
			con.commit();
		} catch (SQLException e) {
			
			try {
				con.rollback();
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
