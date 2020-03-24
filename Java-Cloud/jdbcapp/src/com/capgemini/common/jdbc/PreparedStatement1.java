package com.capgemini.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class PreparedStatement1 {
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String dburl = "jdbc:mysql://localhost:3306/cg_db";
			con = DriverManager.getConnection(dburl, "root", "bobo");

			String query = " select * from movie_info where id=? ";
			pre = con.prepareStatement(query);
			pre.setInt(1, Integer.parseInt(args[0]));
			rs = pre.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String rating = rs.getString("rating");
				int price = rs.getInt("price");

				System.out.println("id--" + id);
				System.out.println("name--" + name);
				System.out.println("rating--" + rating);
				System.out.println("price--" + price);
				System.out.println("******************************************");
			}

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
