package com.capgemini.empspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.empspringmvc.dao.EmployeeDAO;
import com.capgemini.empspringmvc.dto.EmployeeInfoBean;

@Service

public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeInfoBean auth(String email, String password) {
		return dao.auth(email, password);
	}

	@Override
	public boolean register(EmployeeInfoBean bean) {
		return dao.register(bean);
	}

	@Override
	public void changePassword(int id, String password) {
		dao.changePassword(id, password);
	}

	@Override
	public List<EmployeeInfoBean> search(String name) {
		return dao.search(name);
	}

}
