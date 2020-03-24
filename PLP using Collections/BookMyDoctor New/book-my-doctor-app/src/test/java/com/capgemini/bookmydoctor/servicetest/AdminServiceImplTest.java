package com.capgemini.bookmydoctor.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.bookmydoctor.dto.AdminDto;
import com.capgemini.bookmydoctor.exceptions.ValidInputException;
import com.capgemini.bookmydoctor.service.AdminService;
import com.capgemini.bookmydoctor.service.AdminServiceImpl;

class AdminServiceImplTest {

	private AdminDto dto = new AdminDto();
	private AdminService dao = new AdminServiceImpl();

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
		dto.setAdminId(2);
		boolean expectedFlag = dao.deleteAdmin(dto.getAdminId());
		assertFalse(expectedFlag);
	}

	@Test
	public void getAllAdmin() {
		List<AdminDto> all = dao.getAllAdmin();
		assertNotNull(all);
	}

}
