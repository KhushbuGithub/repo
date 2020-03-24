package com.capgemini.propertiesfile.myproperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadFirstFile {
	public static void main(String[] args) {
		 
		try {
			FileInputStream stream= new FileInputStream("db.properties");
			Properties pro=new Properties();
			pro.load(stream);
			System.out.println(pro.getProperty("user"));
			System.out.println(pro.getProperty("password"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
