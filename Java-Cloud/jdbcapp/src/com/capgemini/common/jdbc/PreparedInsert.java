package com.capgemini.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedInsert {

	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement pre= null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			String dburl="jdbc:mysql://localhost:3306/cg_db";
			con=DriverManager.getConnection(dburl, "root", "bobo");
			
			String s= " insert into movie_info values(?,?,?,?) ;";
			pre=con.prepareStatement(s);
			
			pre.setInt(1, Integer.parseInt(args[0]));
			pre.setString(2, args[1]);
    		pre.setInt(3, Integer.parseInt(args[2]));
    		pre.setInt(4, Integer.parseInt(args[3]));
			
			int count =pre.executeUpdate();
			System.out.println("number of rows affected--"+" "+count);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
				e.getMessage();
			}
		}

	}

}
