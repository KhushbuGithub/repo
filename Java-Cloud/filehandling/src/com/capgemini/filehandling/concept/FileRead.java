package com.capgemini.filehandling.concept;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileRead {
	public static void main(String[] args) {
		try(FileInputStream f= new FileInputStream("F:\\Khush\\file.txt")){
			
			int i=0;
			while((i=f.read())!=-1) {
				System.out.print((char)i);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
