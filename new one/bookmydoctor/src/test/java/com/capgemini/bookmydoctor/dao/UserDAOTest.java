package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.User;

@SpringBootTest
class UserDAOTest {
	
	@Autowired
	 private UserDAO dao;
	 User bean =null;
	 boolean addUser = false;

	@BeforeEach
	void addUser() {
		bean = new User();
		bean.setName("Soumya");
		bean.setEmail("soumya@gmail.com");
		bean.setPassword("Qwerty@123");
		bean.setUserType("patient");
		addUser = dao.addUser(bean);
	}
	
	@AfterEach
	void testDeleteUser() {
		dao.deleteUser(bean.getUserId());
	}

//	@Test
//	void testLogin() {
//		bean.getUserId();
// 		User list = dao.login("tarun@gmail.com", "Qwerty@123");
//		assertNotNull(list);
//	}

	@Test
	void testGetAllUsers() {
		List<User> list = dao.getAllUsers();
		assertNotNull(list);
	}

	@Test
	void testChangePassword() {
		bean = new User();
		bean.setName("Rashmi");
		bean.setEmail("rashmi@gmail.com");
		bean.setPassword("Qwerty@123");
		bean.setUserType("patient");
		addUser = dao.addUser(bean);
		bean.getUserId();
		dao.changePassword(bean.getUserId(), bean.getPassword());
		
	}

}
