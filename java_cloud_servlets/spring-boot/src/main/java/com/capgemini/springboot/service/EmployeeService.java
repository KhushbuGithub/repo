package com.capgemini.springboot.service;

import java.util.List;

import com.capgemini.springboot.dto.EmployeeInfoBean;

public interface EmployeeService {
	public EmployeeInfoBean auth(String email, String password);

	public boolean register(EmployeeInfoBean bean);

	public boolean changePassword(int id, String password);

	public List<EmployeeInfoBean> search(String name);

	public boolean deleteEmployee(int id);
}
