package com.capgemini.bookmydoctor.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.HospitalDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;
import com.capgemini.bookmydoctor.factory.Factory;

public class PatientDaoImpl implements PatientDao {

	Logger log = LogManager.getLogger("");

	PatientRegisterDto dto = Factory.getPatientRegisterDto();
	Properties pro;
	FileInputStream stream;

	public PatientDaoImpl() {

		try (FileInputStream stream = new FileInputStream("db.properties");) {
			pro = new Properties();
			pro.load(stream);
			Class.forName(pro.getProperty("FQCN")).newInstance();

		} catch (Exception e) {

			//throw new PatientException("file not found");
		}

	}

	@Override
	public boolean patientDiscription(PatientRegisterDto regr) {

		try (Connection con = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),
				pro.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("insertpatientquery"))) {

			pstmt.setInt(1, regr.getPatientId());
			pstmt.setString(2, regr.getFirstName());
			pstmt.setString(3, regr.getLastName());
			pstmt.setLong(4, regr.getPhoneNumber());
			pstmt.setString(5, regr.getEmailId());
			pstmt.setDate(6, regr.getDOB());
			pstmt.setInt(7, regr.getAge());
			pstmt.setString(8, regr.getGender());
			pstmt.setDate(9, regr.getDateOfRegistration());
			pstmt.setString(10, regr.getAddress());
			pstmt.setInt(11, regr.getPincode());
			pstmt.setString(12, regr.getProblem());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {

		}
		//throw new PatientException("Patient is already registered \n patient cannot be added");
		return false;

	}

	// @Override
	// public boolean loginPatient(int userId, String password, String userType) {
	//
	// try (Connection con = DriverManager.getConnection(pro.getProperty("url"));
	// PreparedStatement pstmt =
	// con.prepareStatement(pro.getProperty("loginpatientquery"))) {
	//
	// pstmt.setInt(1, userId);
	// pstmt.setString(2, password);
	// pstmt.setString(3, userType);
	//
	// ResultSet rs = pstmt.executeQuery();
	// UserDto dto = new UserDto();
	// while (rs.next()) {
	// dto.setUserId(rs.getInt(1));
	// dto.setPassword(rs.getString(2));
	// dto.setUserType(rs.getString(3));
	//
	// }
	// if (dto.getUserId() == userId && dto.getPassword().equals(password)) {
	// return true;
	// }
	//
	// } catch (Exception e) {
	//
	// }
	// throw new PatientException("Login Failed \n Enter valid credentials");
	//
	// }

	@Override
	public List<HospitalDetailsDto> chooseHospital(int rating, int hospitalId) {
		List<HospitalDetailsDto> lst = new ArrayList<HospitalDetailsDto>();
		try (Connection con = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),
				pro.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("choosehospital"))) {
			pstmt.setInt(1, rating);
			pstmt.setInt(2, hospitalId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					HospitalDetailsDto dto = new HospitalDetailsDto();

					dto.setHospitalId(rs.getInt(1));
					dto.setHospitalName(rs.getString(2));
					dto.setAddress(rs.getString(3));

					dto.setMobno(rs.getLong(4));
					dto.setEmail(rs.getString(5));
					dto.setRating(rs.getInt(6));
					lst.add(dto);

				}
				return lst;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// throw new PatientException("hospital not found");
		return null;

	}

	@Override
	public List<DoctorDetailsDto> searchDoctor(String specialization) {
		List<DoctorDetailsDto> lst = new ArrayList<DoctorDetailsDto>();
		try (Connection con = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),
				pro.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("searchdoctor"))) {

			pstmt.setString(1, specialization);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
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
					lst.add(dto);

				}
				return lst;
			}
		} catch (Exception e) {

		}
		// throw new PatientException("doctor is not available");
		return null;
	}

	@Override
	public List<DoctorDetailsDto> selectDoctor(int doctorId, String doctorName, String specialization) {
		List<DoctorDetailsDto> lst = new ArrayList<DoctorDetailsDto>();
		try (Connection con = DriverManager.getConnection(pro.getProperty("url"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("selectdoctor"))) {

			pstmt.setInt(1, doctorId);
			pstmt.setString(2, doctorName);
			pstmt.setString(3, specialization);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
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

			}

		} catch (Exception e) {
			//throw new PatientException("doctor is not available");

		}
		return lst;
	}

	@Override
	public boolean makePayment(int patientId, String paymentType, Date paymentDate, int amount) {
		try (Connection con = DriverManager.getConnection(pro.getProperty("url"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("payment"))) {

			pstmt.setInt(1, patientId);
			pstmt.setString(2, paymentType);
			pstmt.setDate(3, paymentDate);
			pstmt.setInt(4, amount);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}

		} catch (Exception e) {
			// throw new PatientException("payment is cancelled \n if amount is deducted,
			// the amount will be refund withinn 2 to 3 working days");

		}
		return false;

	}

	@Override
	public boolean manageAppointment(int patientId) {
		try (Connection con = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),
				pro.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("cancelpayment"))) {

			pstmt.setInt(1, patientId);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// throw new PatientException("payment is not cancelled/ managed");
		return false;
	}




}
