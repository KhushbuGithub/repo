package com.capgemini.bookmydoctor.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.capgemini.bookmydoctor.dao.AdminDao;
import com.capgemini.bookmydoctor.dto.AdminDto;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.factory.DaoFactory;

public class AdminServiceImpl implements AdminService {

	private AdminDao dao = DaoFactory.getAdminDao();
	
	@Override
	public boolean registerAdmin(AdminDto admin) {
		return dao.registerAdmin(admin);
	}

	@Override
	public boolean deleteAdmin(int adminId) {
		return dao.deleteAdmin(adminId);
	}

	@Override
	public boolean updateAdmin(AdminDto admin) {
		return dao.updateAdmin(admin);
	}

	@Override
	public AdminDto getAdmin(int adminId) {
		return dao.getAdmin(adminId) ;
	}

	@Override
	public List<AdminDto> getAllAdmin() {
		return dao.getAllAdmin();
	}
	
	

}
