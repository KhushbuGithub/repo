package com.capgemini.bookmydoctor.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.HospitalDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;
import com.capgemini.bookmydoctor.dto.PaymentDto;
import com.capgemini.bookmydoctor.factory.Factory;

public class DoctorDaoImpl implements DoctorDao {
	Properties pro;
	FileInputStream Stream;
	DoctorDetailsDto doctorDto = Factory.getDoctorDetailsDto();

	public DoctorDaoImpl() {
		try (FileInputStream stream = new FileInputStream("doctor.properties")) {
			pro = new Properties();

			pro.load(stream);
			Class.forName(pro.getProperty("FQCN"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean doctorDescription(DoctorDetailsDto dto) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),
				pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("insertdoctorquery"))) {

			pstmt.setInt(1, dto.getDoctorId());
			pstmt.setString(2, dto.getDoctorName());
			pstmt.setString(3, dto.getSpecialization());
			pstmt.setLong(4, dto.getYearOfExperience());
			pstmt.setString(5, dto.getAvailabilityFromDay());
			pstmt.setString(6, dto.getAvailabilityEndDay());
			pstmt.setTime(7, dto.getAvailabilityStartTime());
			pstmt.setTime(8, dto.getAvailabilityEndTime());
			pstmt.setInt(9, dto.getCharges());
			pstmt.setInt(10, dto.getRating());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {

		}

		return false;
	}

	@Override
	public List<HospitalDetailsDto> viewFeedback(String hospitalName) {

		List<HospitalDetailsDto> list = new ArrayList<HospitalDetailsDto>();
		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),
				pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("viewfeedbackquery"))) {

			pstmt.setString(1, hospitalName);
			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {
					HospitalDetailsDto hospitalDto = new HospitalDetailsDto();
					hospitalDto.setHospitalId(rs.getInt(1));
					hospitalDto.setHospitalName(rs.getString(2));
					hospitalDto.setRating(rs.getInt(6));

					list.add(hospitalDto);
				}
				return list;
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public List<PatientRegisterDto> searchPatientHistory(int patientId) {

		List<PatientRegisterDto> list = new ArrayList<PatientRegisterDto>();
		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),
				pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("viewpatienthistory"))) {

			pstmt.setInt(1, patientId);

			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {
					PatientRegisterDto patientRegistrationDto = new PatientRegisterDto();

					patientRegistrationDto.setDateOfRegistration(rs.getDate(9));
					patientRegistrationDto.setProblem(rs.getString(12));

					list.add(patientRegistrationDto);
				}
				return list;
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public List<AppointmentDto> viewAppointment(int doctorId) {

		List<AppointmentDto> list = new ArrayList<AppointmentDto>();
		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),
				pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("viewappointment"))) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					AppointmentDto appointmentScheduleDto = new AppointmentDto();
					appointmentScheduleDto.setAppointmentId(rs.getInt(1));
					appointmentScheduleDto.setDoctorId(rs.getInt(2));
					appointmentScheduleDto.setNumberOfInPatients(rs.getInt(3));
					appointmentScheduleDto.setNumberOfOutPatients(rs.getInt(4));
					appointmentScheduleDto.setAppointmentDate(rs.getDate(5));
					appointmentScheduleDto.setAppointmentTime(rs.getTime(6));
					list.add(appointmentScheduleDto);
				}

				return list;
			}
		} catch (Exception e) {

		}
		return null;

	}

	@Override
	public List<PaymentDto> viewPaymentDetails(int patientId) {
		List<PaymentDto> list = new ArrayList<PaymentDto>();
		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),
				pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("viewappointment"))) {

			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {
					PaymentDto paymentDto = new PaymentDto();
					paymentDto.setPatientId(rs.getInt(1));
					paymentDto.setPaymentType(rs.getString(2));
					paymentDto.setPaymentDate(rs.getDate(3));
					paymentDto.setAmount(rs.getInt(4));

					list.add(paymentDto);
				}
				return list;
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public boolean manageAvailability(int doctorId, String availabilityFromDay, String availabilityEndDay,
			Time availabilityStartTime, Time availabilityEndTime, int charges) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),
				pro.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("manageavailability"))) {

			pstmt.setString(1, availabilityFromDay);
			pstmt.setString(2, availabilityEndDay);
			pstmt.setTime(3, availabilityStartTime);
			pstmt.setTime(4, availabilityEndTime);
			pstmt.setInt(5, charges);
			pstmt.setInt(6, doctorId);
			int count = pstmt.executeUpdate();

			if (count > 0) {

				return true;
			}
		} catch (Exception e) {
		
		}
		return false;
	}

}
