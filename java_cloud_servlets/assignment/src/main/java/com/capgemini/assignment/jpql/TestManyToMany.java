package com.capgemini.assignment.jpql;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.assignment.dto.Employee;
import com.capgemini.assignment.manytomany.ProjectInfo;

public class TestManyToMany {
	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction trans = null;

		Employee employee = new Employee();
		employee.setEmp_id(40);
		employee.setEmp_name("Jolly");
		employee.setSalary("90000");
		employee.setDept_id(777);
		employee.setPhone_no(789900);
		employee.setOfficial_mail("khush@gmail.com");
		employee.setDesignation("Manager");
		employee.setDob(java.sql.Date.valueOf("1989-03-21"));
		employee.setManager_id(90);
		employee.setExperience(7);

		Employee employee1 = new Employee();
		employee1.setEmp_id(41);
		employee1.setEmp_name("Joy");
		employee1.setSalary("90090");
		employee1.setDept_id(888);
		employee1.setPhone_no(767890);
		employee1.setOfficial_mail("joy@gmail.com");
		employee1.setDesignation("Accountant");
		employee1.setDob(java.sql.Date.valueOf("1989-03-21"));
		employee1.setManager_id(90);
		employee1.setExperience(8);

		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(employee);
		al.add(employee1);

		ProjectInfo project = new ProjectInfo();
		project.setProject_id(50);
		project.setProject_name("Security System");
		project.setTechnology("Aurdino");
		project.setLocation("Pune");
		project.setDuration(1);
		project.setPrimary(al);

		ProjectInfo project1 = new ProjectInfo();
		project1.setProject_id(51);
		project1.setProject_name("Security System");
		project1.setTechnology("IOT");
		project1.setLocation("Chennai");
		project1.setDuration(2);

		ArrayList<ProjectInfo> al1 = new ArrayList<ProjectInfo>();
		al1.add(project);
		al1.add(project1);

		try {
			factory = Persistence.createEntityManagerFactory("test1");
			manager = factory.createEntityManager();
			trans = manager.getTransaction();
			trans.begin();
			manager.persist(project);
			System.out.println("Record Inserted");
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
