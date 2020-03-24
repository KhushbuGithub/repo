package com.capgemini.assignment.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.assignment.dto.Employee;

public class ReadMaven {
	public static void main(String[] args) {
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("test1");
		EntityManager manager= factory.createEntityManager();
		String jpql="Select s.emp_name from Employee s";
	//	Query query= manager.createQuery(jpql);
		TypedQuery<String> query=manager.createQuery(jpql,String.class);
		List<String> record=query.getResultList();
		System.out.println(record);
		for (String emp : record) {
	           System.out.println(emp);
	            System.out.println("*****************************");
		}
		}	
}
