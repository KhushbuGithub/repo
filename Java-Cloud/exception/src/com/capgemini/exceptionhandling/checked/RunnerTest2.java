package com.capgemini.exceptionhandling.checked;

public class RunnerTest2 {

	public static void main(String[] args) {
		Test2 t= new Test2();
         System.out.println("main Started");
         try {
        	 try {
        		 Class.forName("Test1");
        	 }catch(ClassNotFoundException e) {
        		 System.out.println(e.getMessage());
        	 }
        	 t.clone();
         }catch(CloneNotSupportedException e){
        	 System.out.println(e.getMessage());
         }
	}

}
