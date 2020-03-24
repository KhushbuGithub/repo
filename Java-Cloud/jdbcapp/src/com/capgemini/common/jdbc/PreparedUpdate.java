package com.capgemini.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class PreparedUpdate {
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pre = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String dburl = "jdbc:mysql://localhost:3306/cg_db";
			con = DriverManager.getConnection(dburl, "root", "bobo");

			String query = " update movie_info set rating = 10 where id=?";
			pre = con.prepareStatement(query);
			pre.setInt(1, Integer.parseInt(args[0]));
			int count = pre.executeUpdate();
			System.out.println(count);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
