package com.capgemini.filehandling.concept;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput2 {

	public static void main(String[] args) {
// try resourse
		try(FileOutputStream f= new FileOutputStream("F:\\Khush\\file1.txt")) {
			String s1= "hiiiiiiiiiiiiiiiiiiiiiii hello, how r u";
			byte[] b1=s1.getBytes();
			f.write(b1);
			System.out.println("file created");
		} catch (IOException e) {
			e.getMessage();

		}
	}
}
