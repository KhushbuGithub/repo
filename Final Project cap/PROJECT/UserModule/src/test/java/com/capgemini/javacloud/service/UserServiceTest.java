package com.capgemini.javacloud.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.javacloud.dto.User;
import com.capgemini.javacloud.service.UserService;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService service;
	User bean = null;
	boolean addUser = false;

	@BeforeEach
	void addUser() {
		bean = new User();
		bean.setName("John");
		bean.setEmail("john@gmail.com");
		bean.setPassword("Qwerty@123");
		bean.setUserType("patient");
		addUser = service.addUser(bean);
	}

	@AfterEach
	void testDeleteUser() {
		service.deleteUser(bean.getUserId());
	}

//	@Test
//	void testLogin() {
//		bean.getUserId();
//		User lqist = service.login("tarun@gmail.com", "Qwerty@123");
//		assertNotNull(list);
//	}

	@Test
	void testGetAllUsers() {
		List<User> list = service.getAllUsers();
		assertNotNull(list);
	}

}
