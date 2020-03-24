package com.capgemini.assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.assignment.dto.Employee;

public class InsertMaven {
	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction trans = null;

		try {
			Employee employee = new Employee();
			employee.setEmp_id(40);
			employee.setEmp_name("Jolly");
			employee.setSalary("90000");
			employee.setDept_id(777);
			employee.setPhone_no(789900);
			employee.setOfficial_mail("khush@gmail.com");
			employee.setDesignation("Manager");
			employee.setDob(java.sql.Date.valueOf("1989-03-21"));
			employee.setManager_id(90);
			employee.setExperience(7);

			factory = Persistence.createEntityManagerFactory("test1");
			manager = factory.createEntityManager();
			trans = manager.getTransaction();
			trans.begin();
			manager.persist(employee);
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
