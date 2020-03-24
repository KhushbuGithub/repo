package com.capgemini.assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.assignment.dto.Employee;

public class UpdateMaven {
	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("test1");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Employee record = manager.find(Employee.class, 2);
			record.setEmp_name("Jacky");
			record.setOfficial_mail("jacky@gmail.com");
			record.setDesignation("Accountant");
			record.setPhone_no(909090909);

			System.out.println("Record Updated");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {

			manager.close();
			factory.close();
		}
	}

}
