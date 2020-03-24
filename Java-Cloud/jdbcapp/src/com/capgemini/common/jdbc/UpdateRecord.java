package com.capgemini.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecord {

	public static void main(String[] args) {
		Connection con= null;
		Statement sat= null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl="jdbc:mysql://localhost:3306/emp_mgmt_db";
			con= DriverManager.getConnection(dburl, "root", "bobo");

			String query="update emp_primary_info set official_mail='abc@gmail.com' ;";
			sat= con.createStatement();
			int count = sat.executeUpdate(query);
			System.out.println("no of row affected-"+" "+count);


		} catch ( Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(con!=null) {
					con.close();
				}
				if(sat!=null) {
					sat.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}


}
