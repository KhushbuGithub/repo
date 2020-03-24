package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.beans.ContractorBean;

public class ContractorDAOImpl implements ContractorDAO {

	private List<ContractorBean> contractorBean = new ArrayList<ContractorBean>();

	@Override
	public boolean addContract(ContractorBean bean) {
		for (ContractorBean contractorBean : contractorBean) {
			if (contractorBean.getContractNo() == bean.getContractNo()) {
				return false;
			}

		}
		contractorBean.add(bean);
		return true;

	}

	@Override
	public boolean deleteContract(int contractorid) {
		ContractorBean bean = null;
		for (ContractorBean contractorBean2 : contractorBean) {
			if (contractorBean2.getContractNo() == contractorid) {
				bean = contractorBean2;
			}

		}
		if (bean != null) {
			contractorBean.remove(bean);
			return true;
		}

		return false;
	}

}
