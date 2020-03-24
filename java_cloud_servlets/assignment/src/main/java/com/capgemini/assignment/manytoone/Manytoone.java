package com.capgemini.assignment.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.assignment.dto.Employee;
import com.capgemini.assignment.onetoone.EmployeeSec;

public class Manytoone {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction trans = null;

		
			Employee employee = new Employee();

			employee.setEmp_id(70);
			employee.setEmp_name("Jiva");
			employee.setSalary("90000");
			employee.setDept_id(101);
			employee.setPhone_no(789900);
			employee.setOfficial_mail("khush@gmail.com");
			employee.setDesignation("Manager");
			employee.setDob(java.sql.Date.valueOf("1989-03-21"));
			employee.setManager_id(90);
			employee.setExperience(7);

			EmpAddressPK pk=new EmpAddressPK();
			pk.setEmp_id(70);
			pk.setAddress_type("present");
			
			EmpAddressInfo add= new EmpAddressInfo();
			add.setAddressPK(pk);
			add.setAddress1("BTM");
			add.setAddress2("Ranchi");
			add.setCity("bangalore");
			add.setHouse_no("777");
			add.setPincode(678905);
			add.setLandmark("axa building");
			add.setPrimary(employee);

			try {
			factory = Persistence.createEntityManagerFactory("test1");
			manager = factory.createEntityManager();
			trans = manager.getTransaction();
			trans.begin();
			Employee info=manager.find(Employee.class, 70);
			//add.setPrimary(info);
			System.out.println(info.getAddinfo().get(0).getAddressPK().getAddress_type());//fetching the data
			
			
              //manager.persist(add);
			//manager.persist(employee);
			//manager.persist(emp);
		//	Employee prinfo= manager.find(Employee.class, 70);
			//System.out.println(prinfo.getSecondary().getGovt_id());//fetching the record
			System.out.println("Record Saved");
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
