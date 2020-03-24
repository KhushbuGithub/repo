package com.capgemini.junittest;

public class MyRestService {
	
	public String getStudentName() {
		return "Priyaa";
	}
	
	public String getTeacherName() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Shilpa";
	}

}
