package com.capgemini.assignment.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.assignment.dto.Employee;

public class StaticInsert {
public static void main(String[] args) {
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction trans= null;
		
		try {
		factory= Persistence.createEntityManagerFactory("test1");
		 manager= factory.createEntityManager();
		 trans= manager.getTransaction();
		 trans.begin();
		String jpql="Insert into Employee e values(e.salary=8000,e.emp_id=34)";
		//Query query=manager.createQuery(jpql);
		TypedQuery<Employee> query=manager.createQuery(jpql,Employee.class);
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
