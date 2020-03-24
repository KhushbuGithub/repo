package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagement.beans.ContractorBean;
import com.capgemini.forestmanagement.dao.ContractorDAO;
import com.capgemini.forestmanagement.factory.ContractorFactory;

public class ContractorServicesImpl implements ContractorServices {
	ContractorDAO dao = ContractorFactory.instanceOfContractorDaoImpl();

	@Override
	public boolean addContract(ContractorBean bean) {

		return dao.addContract(bean);
	}

	@Override
	public boolean deleteContract(int contractorNo) {

		return dao.deleteContract(contractorNo);
	}

}
