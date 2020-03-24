package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.beans.HaulierBean;

public class HaulierDAOImpl implements HaulierDAO {

	private List<HaulierBean> haulierBean = new ArrayList<HaulierBean>();

	@Override
	public boolean addHaulier(HaulierBean bean) {
		for (HaulierBean haulierBean2 : haulierBean) {
			if (haulierBean2.getHaulierId() == bean.getHaulierId()) {
				return false;
			}

		}
		haulierBean.add(bean);
		return true;
	}

	@Override
	public boolean deleteHaulier(int haulierId) {
		HaulierBean bean = null;
		for (HaulierBean haulierBean2 : haulierBean) {
			if (haulierBean2.getHaulierId() == haulierId) {
				bean = haulierBean2;
			}

		}
		if (bean != null) {
			haulierBean.remove(bean);
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyHaulier(HaulierBean bean) {
		for (HaulierBean haulierBean2 : haulierBean) {
			if (haulierBean2.getHaulierId() == bean.getHaulierId()) {
				haulierBean.contains(haulierBean2);
				return true;
			} else {
				System.err.println("HaulierId Does'nt Exists!!!");
				return false;
			}
		}
		return false;
	}

}
