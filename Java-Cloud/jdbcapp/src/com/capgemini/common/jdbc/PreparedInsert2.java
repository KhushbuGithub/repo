package com.capgemini.common.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedInsert2 {
	public static void main(String[] args) {
		
		PreparedStatement pre = null;
		DriverManager dm = null;
		Connection con= null;
		 
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl="jdbc:mysql://localhost:3306/emp_mgmt_info";
			con=DriverManager.getConnection("dburl", "root", "bobo");
			
			String query="insert into emp_primary_info values(?,?,?,?,?,?,?,'2019-03-02',?,?); ";
			pre=con.prepareStatement(query);
			
			pre.setInt(1, Integer.parseInt(args[0]));
			pre.setString(2, args[1]);
			pre.setString(3, args[2]);
			pre.setInt(4, Integer.parseInt(args[3]));
			pre.setDouble(5, Double.parseDouble(args[4]));
			pre.setString(6, args[5]);
			pre.setString(7, args[6]);
			//pre.setDate(8, (args[7]);
			pre.setInt(8,Integer.parseInt(args[7]));
			pre.setDouble(9, Double.parseDouble(args[8]));
			
			int count =pre.executeUpdate();
			System.out.println("number of row affected"+" "+count);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
