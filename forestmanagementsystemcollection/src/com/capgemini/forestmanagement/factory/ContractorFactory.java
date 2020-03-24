package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.ContractorDAO;
import com.capgemini.forestmanagement.dao.ContractorDAOImpl;

public class ContractorFactory {
	public static ContractorDAO instanceOfContractorDaoImpl() {
		ContractorDAO dao = new ContractorDAOImpl();
		return dao;
	}

}
