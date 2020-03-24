package com.capgemini.assignment.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicUpdate {
	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction trans = null;

		try {
			factory = Persistence.createEntityManagerFactory("test1");
			manager = factory.createEntityManager();
			trans = manager.getTransaction();
			trans.begin();
			String jpql = "Update Employee e set e.manager_id=:mn where e.emp_id=:mid";
			Query query = manager.createQuery(jpql);
			// TypedQuery<Employee> query=manager.createQuery(jpql,Employee.class);
			query.setParameter("mn", 22);
			query.setParameter("mid", 8);
			int result = query.executeUpdate();
			System.out.println(result);
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
