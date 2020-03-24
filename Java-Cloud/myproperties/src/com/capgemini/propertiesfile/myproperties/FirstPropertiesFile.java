package com.capgemini.propertiesfile.myproperties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class FirstPropertiesFile {

	public static void main(String[] args) {
		try {
			FileOutputStream stream = new FileOutputStream("First.properties");
			Properties pro = new Properties();
			pro.setProperty("name", "Khush");
			pro.setProperty("phone", "98765431");
			pro.store(stream, "new file");
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
