package com.capgemini.bookmydoctor.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.capgemini.bookmydoctor.dto.UserDto;
import com.capgemini.bookmydoctor.factory.UserFactory;

public class UserDaoImpl implements UserDao {
	
	FileReader reader;
	Properties pro;
	UserDto dto = UserFactory.getUserDto();
	
	public UserDaoImpl() {
		try(FileReader reader = new FileReader("admin.properties");) {
			pro = new Properties();
			pro.load(reader);
			Class.forName(pro.getProperty("driverClass"));
		} catch (Exception e) {

		}
	}

	@Override
	public boolean registerUser(UserDto user) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("insertuser"))) {

			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setLong(3, user.getUserContact());
			pstmt.setString(4, user.getEmailId());
			pstmt.setString(5, user.getPassword());
			pstmt.setString(6, user.getUserType());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			//throw new AdminException("Id already exists");
		}
		return false;
	}

	@Override
	public boolean addUser(UserDto user) {
		
			try (Connection conn = DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("password"));
					PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("adduser"))) {
				pstmt.setInt(1, user.getUserId());
				pstmt.setString(2, user.getUserName());
				pstmt.setLong(3, user.getUserContact());
				pstmt.setString(4, user.getEmailId());
				pstmt.setString(5, user.getPassword());
				pstmt.setString(6, user.getUserType());

				int count = pstmt.executeUpdate();
				if (count > 0) {
					return true;
				}
			} catch (Exception e) {

			}
	        return false;
			//throw new AdminException("Doctor cannot be added");
		}
}
