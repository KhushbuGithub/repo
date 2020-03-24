package com.capgemini.bookmydoctor.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.bookmydoctor.db.MyDoctorDB;
import com.capgemini.bookmydoctor.dto.AdminDto;

public class AdminDaoImpl implements AdminDao {

	private LinkedList<AdminDto> admindto = MyDoctorDB.adminDto;

	@Override
	public boolean registerAdmin(AdminDto admin) {
		for (AdminDto adminInfoDto : admindto) {
			if ((adminInfoDto.getAdminId() == admin.getAdminId())
					|| (adminInfoDto.getAdminEmailId() == admin.getAdminEmailId())) {
				return false;
			}

		}
		MyDoctorDB.adminDto.add(admin);
		return true;

	}

	@Override
	public boolean deleteAdmin(int adminId) {
		AdminDto dto = null;
		for (AdminDto adminInfoDto : admindto) {
			if (adminInfoDto.getAdminId() == adminId) {
				dto = adminInfoDto;
				MyDoctorDB.adminDto.remove(dto);
				return true;
			}
		}
		return false;
	}



	@Override
	public boolean updateAdmin(AdminDto admin) {
		for (AdminDto adminInfoDto : admindto) {
			if (adminInfoDto.getAdminId() == admin.getAdminId()) {
				adminInfoDto.setAdminName(admin.getAdminName());
				adminInfoDto.setAdminEmailId(admin.getAdminEmailId());
				adminInfoDto.setPassword(admin.getPassword());
				return true;
			}
		}
		return false;
	}

    @Override
	public AdminDto getAdmin(int adminId) {
		AdminDto dto = null;
		for (AdminDto adminInfoBean : admindto) {
			if (adminInfoBean.getAdminId() == adminId) {
				dto = adminInfoBean;
				return dto;
			}
		}
		return null;
		
	}
    @Override
	public List<AdminDto> getAllAdmin() {
		List<AdminDto> adminDtos = admindto;
		return adminDtos;
	}

}
