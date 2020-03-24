package com.capgemini.common.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {

	public static void main(String[] args) {
		Connection con= null;
		Statement sat= null;
		//ResultSet rs= null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl="jdbc:mysql://localhost:3306/cg_db";
			con= DriverManager.getConnection(dburl, "root", "bobo");

			String query=" insert into movie_info values(12,'ABC',9,800);";
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
