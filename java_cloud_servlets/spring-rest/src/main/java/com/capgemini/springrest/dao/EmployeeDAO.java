package com.capgemini.springrest.dao;

import java.util.List;

import com.capgemini.springrest.dto.EmployeeInfoBean;

public interface EmployeeDAO {
	public EmployeeInfoBean auth(String email, String password);

	public boolean register(EmployeeInfoBean bean);

	public boolean changePassword(int id, String password);

	public List<EmployeeInfoBean> search(String name);

	public boolean deleteEmployee(int id);
}
