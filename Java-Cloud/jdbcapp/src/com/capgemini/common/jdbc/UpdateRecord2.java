package com.capgemini.common.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class UpdateRecord2 {

	public static void main(String[] args) {
		Connection con = null;
		Statement sat = null;

		try {

			FileInputStream file = new FileInputStream("db1.properties");
			Properties pro = new Properties();
			pro.load(file);

			Class.forName(pro.getProperty("driver")).newInstance();

			con = DriverManager.getConnection(pro.getProperty("dburl"), pro);

			String query = "update emp_primary_info set experience=2 where designation='JE' or dept_id=111";
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
