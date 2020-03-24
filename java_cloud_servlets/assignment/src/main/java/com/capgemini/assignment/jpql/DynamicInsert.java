package com.capgemini.assignment.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.assignment.dto.Employee;

public class DynamicInsert {
	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction trans = null;

		try {
			factory = Persistence.createEntityManagerFactory("test1");
			manager = factory.createEntityManager();
			trans = manager.getTransaction();
			trans.begin();
			String jpql = "Insert into Employee e values(e.emp_id=:id,e.emp_name=:na,"
					+ "e.salary=:sa,e.dept_id=:did,e.phone_no=:ph,"
					+ "e.official_mail=:om,e.designation=:de,e.manager_id=:mid,e.experience=ex";

			TypedQuery<Employee> query = manager.createQuery(jpql, Employee.class);
			query.setParameter("id", 89);
			query.setParameter("na", "Raj");
			query.setParameter("sa", 5000);
			query.setParameter("did", 171);
			query.setParameter("ph", 890890890);
			query.setParameter("om", "raj@gmail.com");
			query.setParameter("de", "TechnicalSupport");
			query.setParameter("mid", 9090);
			query.setParameter("ex", 9);
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
