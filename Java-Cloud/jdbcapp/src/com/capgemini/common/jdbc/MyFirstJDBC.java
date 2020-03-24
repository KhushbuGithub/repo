package com.capgemini.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class MyFirstJDBC {
	public static void main(String[] args) {

		Connection con=null;
		Statement stat=null;
		ResultSet rs=null;
		//1.Load the driver

		try {
			//			Driver driver = new Driver();
			//			DriverManager.registerDriver(driver);

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			//2.establish the connection via driver

			/*	  #first overloaded method#
			String dburl="jdbc:mysql://localhost:3306/cg_db?user=root&password=bobo";
			con =DriverManager.getConnection(dburl);*/

			String dburl="jdbc:mysql://localhost:3306/cg_db";
			con =DriverManager.getConnection(dburl, "root", "bobo");


			//3.Issue the sql query via connection
			String query="Select * from movie_info";
			stat=con.createStatement();
			rs= stat.executeQuery(query);

			//4.process the result returned sql query

			while(rs.next()) {
				int id=rs.getInt("id");
				String name =rs.getString("name");
				String rating = rs.getString("rating");
				int price =rs.getInt("price");


				System.out.println("id--"+id);
				System.out.println("name--"+name);
				System.out.println("rating--"+rating);
				System.out.println("price--"+price);
				System.out.println("******************************************");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try{
				if(con!=null) {
					con.close();
				}
				if(stat!=null) {
					stat.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

