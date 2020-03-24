package com.capgemini.bookmydoctor.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.capgemini.bookmydoctor.dto.AdminDto;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;

public interface AdminService {
	
	 public boolean registerAdmin(AdminDto admin);

     public  boolean deleteAdmin(int adminId);
     
     public boolean updateAdmin(AdminDto admin);
     
     public AdminDto getAdmin(int adminId);
     
     List<AdminDto> getAllAdmin();

	
}
