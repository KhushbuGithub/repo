package com.capgemini.assignment.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.assignment.dto.Employee;

public class ReadDemo1 {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
		EntityManager manager = factory.createEntityManager();
		String jpql = "Select s from Employee s where s.emp_id=4";

		TypedQuery<Employee> query = manager.createQuery(jpql, Employee.class);
		Employee record = query.getSingleResult();
		System.out.println(record.getDesignation());
		System.out.println(record.getEmp_name());
		System.out.println("*****************************");
	}

}
