package com.capgemini.bookmydoctor.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.User;

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

	@Test
	void testDeleteUser() {
		service.deleteUser(bean.getUserId());
	}

	@Test
	void testGetAllUsers() {
		List<User> list = service.getAllUsers();
		assertNotNull(list);
	}

	@Test
	void testAddUser() {
		assertTrue(addUser);
	}
}
