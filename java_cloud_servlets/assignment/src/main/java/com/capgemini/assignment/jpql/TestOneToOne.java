package com.capgemini.assignment.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.assignment.dto.Employee;
import com.capgemini.assignment.onetoone.EmployeeSec;

public class TestOneToOne {
	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction trans = null;

		try {
			Employee employee = new Employee();

			employee.setEmp_id(76);
			employee.setEmp_name("Jiva");
			employee.setSalary("90000");
			employee.setDept_id(101);
			employee.setPhone_no(789900);
			employee.setOfficial_mail("khush@gmail.com");
			employee.setDesignation("Manager");
			employee.setDob(java.sql.Date.valueOf("1989-03-21"));
			employee.setManager_id(90);
			employee.setExperience(7);

			EmployeeSec emp = new EmployeeSec();

			//emp.setEmp_id(3);
			emp.setPrimary(employee);
			emp.setGender("F");
			emp.setJob_location("Bihar");
			emp.setBlood_group("B+");
			emp.setGuardian_name("Ajay");
			emp.setPersonal_email("Ziva@gamil.com");
			emp.setNationality("Indian");
			emp.setMarried("Unmarried");
			emp.setLanguage_known("Hindi,English");
			emp.setGovt_id("Adhar");

			factory = Persistence.createEntityManagerFactory("test1");
			manager = factory.createEntityManager();
			trans = manager.getTransaction();
			trans.begin();

			//manager.persist(employee);
			//manager.persist(emp);
			Employee prinfo= manager.find(Employee.class, 76);
			System.out.println(prinfo.getSecondary().getGovt_id());//fetching the record
			System.out.println("Record Inserted");
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			manager.close();
			factory.close();
		}

	}
}