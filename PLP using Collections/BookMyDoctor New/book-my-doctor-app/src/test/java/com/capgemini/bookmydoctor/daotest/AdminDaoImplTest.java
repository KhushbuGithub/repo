package com.capgemini.bookmydoctor.daotest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.bookmydoctor.dao.AdminDao;
import com.capgemini.bookmydoctor.dao.AdminDaoImpl;
import com.capgemini.bookmydoctor.dto.AdminDto;
import com.capgemini.bookmydoctor.exceptions.ValidInputException;

class AdminDaoImplTest {
	private AdminDto dto = new AdminDto();
	private AdminDao dao = new AdminDaoImpl();

	@Test
	public void registerAdminTest() {
		try {

			dto.setAdminId(2);
			dto.setAdminEmailId("khush@gmail.com");
			dto.setAdminName("Khushbu");
			dto.setPassword("querty@1A");
			boolean expectedFlag = dao.registerAdmin(dto);
			assertEquals(expectedFlag, true);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.registerAdmin(dto);
			});
		}
	}

	@Test
	public void deleteAdminTest() {
		try {
			dto.setAdminId(2);
			boolean expectedFlag = dao.deleteAdmin(dto.getAdminId());
			assertFalse(expectedFlag);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.deleteAdmin(dto.getAdminId());
			});
		}
	}

	@Test
	public void getAllAdmin() {
		List<AdminDto> all = dao.getAllAdmin();
		assertNotNull(all);
	}

}
