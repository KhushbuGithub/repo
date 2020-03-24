package com.capgemini.filehandling.concept;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput1 {

	public static void main(String[] args) {
		FileOutputStream f=null;
		try {
			f= new FileOutputStream("F:\\Khush\\file.txt");
			f=new FileOutputStream("F:\\\\Khush\\\\file.txt");
			String s1= "hiiiiiiiiiiiiiiiiiiiiiii hello";
			byte[] b1=s1.getBytes();
			f.write(b1);
			System.out.println("file created");
		} catch (IOException e) {
			e.getMessage();
		}finally {
			try {
			if(f!=null) {
				f.close();
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}

	}
}
}



