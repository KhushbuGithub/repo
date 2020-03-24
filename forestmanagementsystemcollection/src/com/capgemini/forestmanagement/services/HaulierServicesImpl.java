package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagement.beans.HaulierBean;
import com.capgemini.forestmanagement.dao.HaulierDAO;
import com.capgemini.forestmanagement.factory.HaulierFactory;

public class HaulierServicesImpl implements HaulierServices {

	HaulierDAO dao = HaulierFactory.instanceOfHaulierDaoImpl();

	@Override
	public boolean addHaulier(HaulierBean bean) {

		return dao.addHaulier(bean);
	}

	@Override
	public boolean deleteHaulier(int haulierId) {

		return dao.deleteHaulier(haulierId);
	}

	@Override
	public boolean modifyHaulier(HaulierBean bean) {

		return dao.modifyHaulier(bean);
	}

}
