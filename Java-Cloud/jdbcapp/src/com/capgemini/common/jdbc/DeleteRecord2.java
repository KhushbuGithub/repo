package com.capgemini.common.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DeleteRecord2 {

	public static void main(String[] args) {
		Connection con = null;
		Statement sat = null;

		try {

			FileInputStream file = new FileInputStream("db1.properties");
			Properties pro = new Properties();
			pro.load(file);

			con = DriverManager.getConnection(pro.getProperty("dburl"), pro);

			Class.forName(pro.getProperty("driver")).newInstance();

			String query = "Delete from emp_primary_info where emp_id=5 or manager_id=67";
			sat = con.createStatement();
			int count = sat.executeUpdate(query);
			System.out.println("no of row affected-" + " " + count);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (sat != null) {
					sat.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
