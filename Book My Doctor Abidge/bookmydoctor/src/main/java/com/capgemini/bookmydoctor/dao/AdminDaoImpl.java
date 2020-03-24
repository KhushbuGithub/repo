package com.capgemini.bookmydoctor.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.bookmydoctor.dto.AdminDto;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;
import com.capgemini.bookmydoctor.dto.UserDto;
import com.capgemini.bookmydoctor.exception.AdminException;
import com.capgemini.bookmydoctor.factory.Factory;

public class AdminDaoImpl implements AdminDao {

	FileReader reader;
	Properties pro;
	AdminDto dto = Factory.getAdminDto();

	public AdminDaoImpl() {
		try(FileReader reader = new FileReader("admin.properties");) {
			pro = new Properties();
			pro.load(reader);
			Class.forName(pro.getProperty("driverClass"));
		} catch (Exception e) {

		}
	}

	@Override
	public boolean registerAdmin(AdminDto admin) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("insertquery"))) {

			pstmt.setInt(1, admin.getAdminId());
			pstmt.setInt(2, admin.getUserId());
			pstmt.setString(3, admin.getAdminName());
			pstmt.setString(4, admin.getPassword());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			//throw new AdminException("Id already exists");
		}
		return false;
	}

	@Override
	public boolean loginAdmin(int adminId, String password) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("loginquery"))) {
			pstmt.setInt(1, adminId);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			AdminDto user1 = new AdminDto();
			while (rs.next()) {
				user1.setAdminId(rs.getInt(1));
				user1.setPassword(rs.getString(2));
			}
			if (user1.getAdminId() == adminId || user1.getPassword() == password) {
				return true;
			}

		} catch (Exception e) {

		}
		return false;
		//throw new AdminException("login failed\nEnter valid credentials");
	}

	@Override
	public boolean addDoctor(DoctorDetailsDto doctor) {

		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("insertDoctor"))) {
			pstmt.setInt(1, doctor.getDoctorId());
			pstmt.setString(2, doctor.getDoctorName());
			pstmt.setString(3, doctor.getSpecialization());
			pstmt.setInt(4, doctor.getYearOfExperience());
			pstmt.setString(5, doctor.getAvailabilityFromDay());
			pstmt.setString(6, doctor.getAvailabilityEndDay());
			pstmt.setTime(7, doctor.getAvailabilityStartTime());
			pstmt.setTime(8, doctor.getAvailabilityEndTime());
            pstmt.setInt(9, doctor.getCharges());
            pstmt.setInt(10, doctor.getRating());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {

		}
        return false;
		//throw new AdminException("Doctor cannot be added");
	}
	
	@Override
	public boolean deleteDoctor(int doctorId) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("deleteDoctor"))) {

			pstmt.setInt(1, doctorId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}
	
//	@Override
//	public boolean addPatient(PatientRegistrationDto patient) {
//		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("password"));
//				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("addPatient"))) {
//			pstmt.setInt(1, patient.getPatientId());
//			pstmt.setString(2, patient.getFirstName());
//			pstmt.setString(3, patient.getLastName());
//			pstmt.setLong(4, patient.getPhoneNumber());
//			pstmt.setString(5, patient.getEmailId());
//			pstmt.setDate(6, patient.getDOB());
//			pstmt.setInt(7, patient.getAge());
//			pstmt.setString(8, patient.getGender());
//			pstmt.setDate(9, patient.getDateOfRegistration());
//			pstmt.setString(10, patient.getAddress());
//			pstmt.setInt(11, patient.getPincode());
//			pstmt.setString(12, patient.getProblem());
//		} catch (Exception e) {
//			
//		}
//		return false;
//	}

	@Override
	public boolean deletePatient(int patientId) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("delete"))) {

			pstmt.setInt(1, patientId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (Exception e) {

		}
		//throw new AdminException("patient cannot be deleted");
		return false;
	}

	@Override
	public List<AppointmentDto> viewAppointment(int appointmentId) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("view"))) {
			List<AppointmentDto> list = new ArrayList<AppointmentDto>();
			pstmt.setInt(1, appointmentId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				AppointmentDto dto = new AppointmentDto();

				dto.setAppointmentId(rs.getInt(1));
				dto.setDoctorId(rs.getInt(2));
				dto.setNumberOfInPatients(rs.getInt(3));
				dto.setNumberOfOutPatients(rs.getInt(4));
				dto.setAppointmentDate(rs.getDate(5));
				dto.setAppointmentTime(rs.getTime(6));
				list.add(dto);
			}

			return list;

		} catch (Exception e) {

		}
		//throw new AdminException("No appointments found");
		return null;
	}
	
	@Override
	public boolean updateAppointment(Date appointmentDate,Time appointmentTime,int appointmentId) {
		
	try (Connection conn = DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("update"))) {

		
		pstmt.setDate(1, appointmentDate);
		pstmt.setTime(2, appointmentTime);
		pstmt.setInt(3, appointmentId);

		int i = pstmt.executeUpdate();
		if (i == 1) {
			return true;
		}
	} catch (Exception e) {
		
	}
		return false;
		
	}

	@Override
	public List<DoctorDetailsDto> viewDoctor(int doctorId) {

		List<DoctorDetailsDto> list = new ArrayList<DoctorDetailsDto>();

		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("viewDoctor"))) {

			pstmt.setInt(1, doctorId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				DoctorDetailsDto dto = new DoctorDetailsDto();
                
				dto.setDoctorId(rs.getInt(1));
				dto.setDoctorName(rs.getString(2));
				dto.setSpecialization(rs.getString(3));
				dto.setYearOfExperience(rs.getInt(4));
				dto.setAvailabilityFromDay(rs.getString(5));
				dto.setAvailabilityEndDay(rs.getString(6));
				dto.setAvailabilityStartTime(rs.getTime(7));
				dto.setAvailabilityEndTime(rs.getTime(8));
				dto.setCharges(rs.getInt(9));
				dto.setRating(rs.getInt(10));
				list.add(dto);
			}

			

		} catch (Exception e) {

		}
		return list;
         
		//throw new AdminException("Enter valid doctorId\nNo doctors found");

	}

	@Override
	public boolean deleteAdmin(int adminId) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("deleteAdmin"))) {

			pstmt.setInt(1, adminId);

			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (Exception e) {

		}
		//throw new AdminException("Enter valid adminId\nadmin cannot be deleted");
        return false;
	}

}
