package com.capgemini.empspringmvc.service;

import java.util.List;

import com.capgemini.empspringmvc.dto.EmployeeInfoBean;

public interface EmployeeService {
	public EmployeeInfoBean auth(String email,String password);
    public boolean register(EmployeeInfoBean bean);
    public void changePassword(int id,String password);
    public List<EmployeeInfoBean> search(String name);

}
