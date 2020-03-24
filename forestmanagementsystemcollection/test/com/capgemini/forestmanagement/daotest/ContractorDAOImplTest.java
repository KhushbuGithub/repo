package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagement.beans.ContractorBean;
import com.capgemini.forestmanagement.dao.ContractorDAO;
import com.capgemini.forestmanagement.dao.ContractorDAOImpl;
import com.capgemini.forestmanagement.exception.ForestrymanagementException;

class ContractorDAOImplTest {

	private ContractorBean contract= new ContractorBean();
	private ContractorDAO dao=new ContractorDAOImpl();
	
	@BeforeEach
	void addCustomer() {
		contract.setContractNo(2019002);
		contract.setCustomerId(2019001);
		contract.setProductId(2019001);
		contract.setHaulierId(2019001);
		contract.setDeliveryDate("12/12/2020");
		contract.setDeliveryDay("mon");
		contract.setQuantity(1000);
		dao.addContract(contract);
		
	}
	
	@Test
	void testAddContract() {
		try {
		contract =new ContractorBean();
		contract.setContractNo(87867);
		contract.setCustomerId(20190);
		contract.setProductId(201900);
		contract.setHaulierId(201900);
		contract.setDeliveryDate("12/12/2020");
		contract.setDeliveryDay("mon");
		contract.setQuantity(100);
		boolean flag=dao.addContract(contract);
			assertEquals(flag,true);
		}catch(Exception e) {
			assertThrows(ForestrymanagementException.class, () -> {
				dao.addContract(contract);
			});
			
		}
		
	}

	@Test
	void testDeleteContract() {
		contract.setContractNo(20190011);
		boolean flag=dao.deleteContract(contract.getContractNo());
		assertTrue(flag);
		
	}

}
