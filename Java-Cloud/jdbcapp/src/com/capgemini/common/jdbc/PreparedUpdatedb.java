package com.capgemini.common.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PreparedUpdatedb {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pre = null;

		try {
			FileInputStream file = new FileInputStream("db2.properties");
			Properties pro = new Properties();
			pro.load(file);
			
			Class.forName(pro.getProperty("driver"));
			con = DriverManager.getConnection(pro.getProperty("dburl"), pro);

			String query = " update movie_info set rating = ? where id=5 ";
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
