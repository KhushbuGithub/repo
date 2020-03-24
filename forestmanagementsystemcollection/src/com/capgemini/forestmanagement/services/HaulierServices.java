package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagement.beans.HaulierBean;

public interface HaulierServices {
	boolean addHaulier(HaulierBean bean);

	boolean deleteHaulier(int haulierId);

	boolean modifyHaulier(HaulierBean bean);
}
