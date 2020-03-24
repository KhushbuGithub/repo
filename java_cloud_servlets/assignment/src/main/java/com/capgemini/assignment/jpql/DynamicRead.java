package com.capgemini.assignment.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.assignment.dto.Employee;

public class DynamicRead {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
		EntityManager manager = factory.createEntityManager();
		String jpql = "Select s from Employee s where s.emp_id=:id";

		TypedQuery<Employee> query = manager.createQuery(jpql, Employee.class);
		query.setParameter("id", 8);
		Employee record = query.getSingleResult();
		System.out.println(record.getDesignation());
		System.out.println(record.getEmp_name());
		System.out.println(record.getOfficial_mail());
		System.out.println("*****************************");
	}

}
