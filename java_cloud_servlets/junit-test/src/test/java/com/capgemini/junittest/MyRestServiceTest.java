package com.capgemini.junittest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class MyRestServiceTest {

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void getStudentName() {
		MyRestService m = new MyRestService();
		String name = m.getStudentName();
		assertNotNull(name);

	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void getTeacherName() {
		MyRestService m = new MyRestService();
		String name = m.getTeacherName();
		assertNotNull(name);

	}

}
