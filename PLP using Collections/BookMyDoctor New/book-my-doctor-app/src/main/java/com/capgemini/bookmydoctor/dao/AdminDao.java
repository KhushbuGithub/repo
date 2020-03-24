package com.capgemini.bookmydoctor.dao;

import java.util.List;

import com.capgemini.bookmydoctor.dto.AdminDto;

public interface AdminDao {

	   public boolean registerAdmin(AdminDto admin);

       public  boolean deleteAdmin(int adminId);
       
       public boolean updateAdmin(AdminDto admin);
       
       public AdminDto getAdmin(int adminId);
       
       List<AdminDto> getAllAdmin(); 
       
       
       
       

}
