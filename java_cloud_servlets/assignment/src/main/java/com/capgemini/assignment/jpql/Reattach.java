package com.capgemini.assignment.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.assignment.dto.Employee;

public class Reattach {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("test1");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			
			Employee record = manager.find(Employee.class, 76);
			System.out.println(manager.contains(record));
			manager.detach(record);
			System.out.println("before detach"+manager.contains(record));
			
			//System.out.println(manager.merge(record));
			Employee emp=manager.merge(record);
			
//			record.setEmp_name("Jacky");
//			record.setOfficial_mail("jacky@gmail.com");
			record.setDesignation("Accountant");
//			record.setPhone_no(909090909);

			//System.out.println("Record Updated");
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
