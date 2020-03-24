package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagement.beans.HaulierBean;
import com.capgemini.forestmanagement.dao.HaulierDAO;
import com.capgemini.forestmanagement.dao.HaulierDAOImpl;
import com.capgemini.forestmanagement.exception.ForestrymanagementException;

class HaulierDAOImplTest {

	
	private HaulierBean haulier= new HaulierBean();
	private HaulierDAO dao= new HaulierDAOImpl();
	
	@BeforeEach
	void addHaulier() {
		haulier.setHaulierId(2019001);
		haulier.setHaulierName("vaishna");
		haulier.setHaulierAddress1("fgdg");
		haulier.setHaulierAddress2("sdgfd");
		haulier.setTown("fgd");
		haulier.setPostCode(123456);
		haulier.setTelephone(12345678);
		haulier.setNumber(1234);
		haulier.setEmail("vaidsh45@gmail.com");
		dao.addHaulier(haulier);
	}
	
	@Test
	void testAddHaulier() {
		haulier=new HaulierBean();
		haulier.setHaulierId(2019002);
		haulier.setHaulierName("vaishna");
		haulier.setHaulierAddress1("fgdg");
		haulier.setHaulierAddress2("sdgfd");
		haulier.setTown("fgd");
		haulier.setPostCode(123456);
		haulier.setTelephone(12345678);
		haulier.setNumber(1234);
		haulier.setEmail("vaidsh45@gmail.com");
		try {
			boolean flag=dao.addHaulier(haulier);
			assertEquals(flag,true);
		}catch(Exception e) {
			assertThrows(ForestrymanagementException.class, () -> {
				dao.addHaulier(haulier);
			});

		}
		
	}

	@Test
	void testDeleteHaulier() {
		haulier=new HaulierBean();
		haulier.setHaulierId(2019001);
		try {
			boolean flag=dao.deleteHaulier(haulier.getHaulierId());
				assertEquals(flag,true);
			
		}catch(Exception e) {
			assertThrows(ForestrymanagementException.class, () -> {
				dao.deleteHaulier(haulier.getHaulierId());
			});

		}
		
	}

	@Test
	void testModifyHaulier() {
		haulier=new HaulierBean();
		haulier.setHaulierId(2019001);
		haulier.setHaulierName("vaishna");
		haulier.setHaulierAddress1("fgdg");
		haulier.setHaulierAddress2("sdgfd");
		haulier.setTown("fgd");
		haulier.setPostCode(123456);
		haulier.setTelephone(12345678);
		haulier.setNumber(1234);
		haulier.setEmail("vaidsh45@gmail.com");
		try {
			boolean flag=dao.modifyHaulier(haulier);
				assertEquals(flag,true);
			
		}catch(Exception e) {
			assertThrows(ForestrymanagementException.class, () -> {
				dao.modifyHaulier(haulier);
			});

		}
		
	}

}
