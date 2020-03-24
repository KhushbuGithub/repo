package com.capgemini.assignment.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.assignment.dto.Employee;

public class Update {
	public static void main(String[] args) {
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction trans= null;
		
		try {
		factory= Persistence.createEntityManagerFactory("test1");
		 manager= factory.createEntityManager();
		 trans= manager.getTransaction();
		 trans.begin();
		String jpql="Update Employee e set e.manager_id=77 where e.emp_id=4";
		Query query=manager.createQuery(jpql);
		//TypedQuery<Employee> query=manager.createQuery(jpql,Employee.class);
		int result= query.executeUpdate();
		System.out.println(result);
		trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally{
			manager.close();
			factory.close();
		}
	}
	

}
