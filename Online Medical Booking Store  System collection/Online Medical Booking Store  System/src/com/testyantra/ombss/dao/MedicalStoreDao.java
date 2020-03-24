package com.testyantra.ombss.dao;

import java.util.LinkedList;

import com.testyantra.ombss.bean.MedicineInfoBean;
import com.testyantra.ombss.bean.UserInfoBean;

public interface MedicalStoreDao {

	@SuppressWarnings("rawtypes")
	boolean addMedicine(MedicineInfoBean medicineInfoBean,LinkedList li);
	
	boolean deleteMedicine(int id);
	
	boolean deleteUser(int id);
	 
	boolean updateMedicine(int id);
	
	boolean signUp(UserInfoBean userInfoBean); 
	
	boolean userAuthenticate(int id ,String password);
	
	boolean addCart(MedicineInfoBean medicineInfoBean);
	

}
