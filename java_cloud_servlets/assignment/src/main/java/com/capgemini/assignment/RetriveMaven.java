package com.capgemini.assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.assignment.dto.Employee;

public class RetriveMaven {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
		EntityManager manager = factory.createEntityManager();
		Employee res = manager.find(Employee.class, 4);
		System.out.println(res.getEmp_name());
		System.out.println(res.getSalary());
		System.out.println(res.getOfficial_mail());
		System.out.println(res.getDept_id());
		System.out.println(res.getPhone_no());
		System.out.println(res.getDesignation());
		System.out.println(res.getManager_id());
		System.out.println(res.getExperience());
		System.out.println(res.getDob());
		manager.close();
		factory.close();

	}

}
