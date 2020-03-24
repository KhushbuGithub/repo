package com.capgemini.forestmanagement.dao;

import com.capgemini.forestmanagement.beans.HaulierBean;

public interface HaulierDAO {

	boolean addHaulier(HaulierBean bean);

	boolean deleteHaulier(int haulierId);

	boolean modifyHaulier(HaulierBean bean);

}
