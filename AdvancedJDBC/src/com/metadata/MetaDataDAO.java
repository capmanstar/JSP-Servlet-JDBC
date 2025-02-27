package com.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaDataDAO {

	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
				Statement stmt = con.createStatement()){
			
			ResultSet resultSet = stmt.executeQuery("select * from account");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int count = resultSetMetaData.getColumnCount();
			for(int i=1; i<=count; i++) {
				System.out.print(resultSetMetaData.getColumnName(i)+" ");
				System.out.println(resultSetMetaData.getColumnTypeName(i));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
