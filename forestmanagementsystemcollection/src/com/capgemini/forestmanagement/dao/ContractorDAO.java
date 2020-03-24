package com.capgemini.forestmanagement.dao;

import com.capgemini.forestmanagement.beans.ContractorBean;

public interface ContractorDAO {

	boolean addContract(ContractorBean bean);

	boolean deleteContract(int contractorNo);

}
