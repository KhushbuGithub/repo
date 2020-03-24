package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagement.beans.ContractorBean;

public interface ContractorServices {
	boolean addContract(ContractorBean bean);

	boolean deleteContract(int contractorNo);
}
