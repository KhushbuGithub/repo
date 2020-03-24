package com.capgemini.filehandling.concept;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {

	public static void main(String[] args) {
        try {
			FileOutputStream f= new FileOutputStream("F:\\Khush\\file.txt");
        String s1= "hiiiiiiiiiiiiiiiiiiiiiii";
        byte[] b1=s1.getBytes();
        f.write(b1);
        System.out.println("file created");
        } catch (IOException e) {
               e.getMessage();
        }
	}

}
